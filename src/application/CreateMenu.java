package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;

public class CreateMenu {
	private String id;
	private int level;
	private int minesMin;
	private int minesMax;
	private int timeMin;
	private int timeMax;
	private int mines;
	private int time;
	private boolean supermine;

	public CreateMenu() {
		Stage st = new Stage();
		AnchorPane pane = new AnchorPane();
		Scene createScene = new Scene(pane,350,350);
		st.setTitle("Create Scenario File");
		st.setScene(createScene);
		st.show();
		
		Label l1 = new Label("Choose SCENARIO-ID:");
		AnchorPane.setTopAnchor(l1, 10.0);
		AnchorPane.setLeftAnchor(l1, 30.0);

		TextField idText = new TextField("ID");
		idText.setPromptText("ID");
		idText.setPrefWidth(100);
		AnchorPane.setTopAnchor(idText, 10.0);
		AnchorPane.setRightAnchor(idText, 50.0);
		
		Label l2 = new Label("Choose Level:");
		AnchorPane.setTopAnchor(l2, 50.0);
		AnchorPane.setLeftAnchor(l2, 30.0);
		
		ToggleGroup levelGroup = new ToggleGroup();
		RadioButton r1 = new RadioButton("Level 1");
		RadioButton r2 = new RadioButton("Level 2");
		r1.setToggleGroup(levelGroup);
		r2.setToggleGroup(levelGroup);
		AnchorPane.setTopAnchor(r1, 50.0);
		AnchorPane.setTopAnchor(r2, 50.0);
		AnchorPane.setLeftAnchor(r1, 150.0);
		AnchorPane.setRightAnchor(r2, 50.0);
		pane.getChildren().addAll(l1,idText,l2,r1,r2);
		
		
		levelGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n){
	                RadioButton rb = (RadioButton)levelGroup.getSelectedToggle();
	                r1.setDisable(true);
	                r2.setDisable(true);
	                String s = rb.getText();
	                if(s=="Level 1") {
	                	level=1;
	                	minesMax=11;
	                	minesMin=9;
	                	timeMax=180;
	                	timeMin=120;
	                	supermine=false;
	                }
	                else if(s=="Level 2") {
	                	level=2;
	                	minesMax=45;
	                	minesMin=35;
	                	timeMax=360;
	                	timeMin=240;
	                	supermine=true;
	                }
	                
	                Label l3 = new Label("Number of mines:");
	                AnchorPane.setTopAnchor(l3, 90.0);
	       			AnchorPane.setLeftAnchor(l3, 30.0);
	                
	       		 	Spinner mineSpinner = new Spinner(minesMin, minesMax, minesMin);
	       		 	mineSpinner.setEditable(true);
	       			AnchorPane.setTopAnchor(mineSpinner,90.0);
	       			AnchorPane.setLeftAnchor(mineSpinner, 150.0);
	       			
	       			Label l4 = new Label("Time Limit:");
	       			AnchorPane.setTopAnchor(l4, 130.0);
	       			AnchorPane.setLeftAnchor(l4, 30.0);
	       			
	       		 	Spinner timeSpinner = new Spinner(timeMin, timeMax, timeMin);
	       		 	timeSpinner.setEditable(true);
	       			AnchorPane.setTopAnchor(timeSpinner,130.0);
	       			AnchorPane.setLeftAnchor(timeSpinner, 150.0);
	       			pane.getChildren().addAll(l3, mineSpinner, l4, timeSpinner);
	       			
	       			if(supermine) {
	       				Label l5 = new Label("Supermine?:");
	       				AnchorPane.setTopAnchor(l5, 170.0);
	       				AnchorPane.setLeftAnchor(l5, 30.0);
	       				
	       				ToggleGroup superGroup = new ToggleGroup();
	       				RadioButton r3 = new RadioButton("Yes");
	       				RadioButton r4 = new RadioButton("No");
	       				r3.setToggleGroup(superGroup);
	       				r4.setToggleGroup(superGroup);
	       				AnchorPane.setTopAnchor(r3, 170.0);
	       				AnchorPane.setTopAnchor(r4, 170.0);
	       				AnchorPane.setLeftAnchor(r3, 150.0);
	       				AnchorPane.setRightAnchor(r4, 50.0);
	       				pane.getChildren().addAll(l5,r3,r4);
	       				
			       		superGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() { 
			       				@Override
			       				public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n){
				 	                RadioButton rb = (RadioButton)levelGroup.getSelectedToggle();
				 	                r3.setDisable(true);
				 	                r4.setDisable(true);
				 	                String s = rb.getText();
				 	                if(s=="No") {
				 	                	supermine=false;
				 	                }
				 	                else if(s=="Yes") {
				 	                	supermine=true;
				 	                }
			       				}
			       				
			       		});
	                	
	       			}
	       			
	       			Button sb=new Button("Create");
	       			Button cb=new Button("Cancel");
	       			cb.setCancelButton(true);
	       			AnchorPane.setTopAnchor(sb, 210.0);
       				AnchorPane.setTopAnchor(cb, 210.0);
       				AnchorPane.setLeftAnchor(sb, 100.0);
       				AnchorPane.setRightAnchor(cb, 100.0);
       				pane.getChildren().addAll(sb,cb);
       				
       				EventHandler<ActionEvent> submit = new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							id=idText.getText();
							mineSpinner.commitValue();
							mines=(int) mineSpinner.getValue();
							time=(int) timeSpinner.getValue();
							writeFile(id,level,mines,time,supermine);
							st.close();			
						}
					};
					
      				EventHandler<ActionEvent> cancel = new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							st.close();
						}
					};
					
					sb.setOnAction(submit);
					cb.setOnAction(cancel);
	            }
	        });

		//return "File SCENARIO-"+id+".txt created succesfully. Available for Loading.";
	}
	
	private void writeFile(String id, int level, int mines, int time, boolean supermine) {
		try {
			File myObj = new File("src/medialab/SCENARIO-" + id + ".txt");
			myObj.createNewFile();
	        FileWriter fileWriter =  new FileWriter ("src/medialab/SCENARIO-" + id + ".txt", false);
	        
	        fileWriter.write(level +"\n");
	        fileWriter.write(mines +"\n");
	        fileWriter.write(time +"\n");
	        
	        if(supermine)
	        	fileWriter.write("1\n");
	        else
	        	fileWriter.write("0\n");
        
	        fileWriter.close();
		} catch (IOException e) {
            System.out.println("An error occurred, while creating scenario file.");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("An error occurred, while creating scenario file.");
			alert.show();
            e.printStackTrace();
        }
	
	}
}
