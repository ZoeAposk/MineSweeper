package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoadMenu {
	public LoadMenu() {
		Stage st = new Stage();
		AnchorPane pane = new AnchorPane();
		Scene createScene = new Scene(pane,300,250);
		st.setTitle("Load Scenario File");
		st.setScene(createScene);
		st.show();
		
		Label l1 = new Label("Choose SCENARIO-ID:");
		AnchorPane.setTopAnchor(l1, 10.0);
		AnchorPane.setLeftAnchor(l1, 10.0);
	
		TextField idText = new TextField("ID");
		idText.setPromptText("ID");
		idText.setPrefWidth(100);
		AnchorPane.setTopAnchor(idText, 10.0);
		AnchorPane.setRightAnchor(idText, 30.0);
		
		
		Button sb=new Button("Load");
		AnchorPane.setTopAnchor(sb, 150.0);
		AnchorPane.setLeftAnchor(sb, 100.0);
		pane.getChildren().addAll(l1, idText, sb);
		EventHandler<ActionEvent> submit = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String id=idText.getText();
				try {
					File myObj = new File("src/medialab/SCENARIO-" + id + ".txt");
					Scanner myReader = new Scanner(myObj);       
					myReader.close();
					App.ms = new Minesweeper(myObj);
				} catch (IOException e) {
					System.out.println("Error loading file.");
				}		
				st.close();
			}
		};
		sb.setOnAction(submit);
		
		

	}
}
