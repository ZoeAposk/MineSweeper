package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

import java.time.LocalDate;

public class Bar {
	private VBox bar;
	public Bar() {
	       	Menu menu1 = new Menu("Application");
	        // create menuitems
	        MenuItem m1 = new MenuItem("Create");
	        MenuItem m2 = new MenuItem("Load");
	        MenuItem m3 = new MenuItem("Start");
	        MenuItem m4 = new MenuItem("Exit");
	  
	        // add menu items to menu
	        menu1.getItems().add(m1);
	        menu1.getItems().add(m2);
	        menu1.getItems().add(m3);
	        menu1.getItems().add(m4);
	        
	        Menu mmenu2 = new Menu("Details");
		       
	        // create menuitems
	        MenuItem m5 = new MenuItem("Rounds");
	        MenuItem m6 = new MenuItem("Solution");
	  
	        // add menu items to menu
	        mmenu2.getItems().add(m5);
	        mmenu2.getItems().add(m6);
	        // create a menubar
	        MenuBar mb = new MenuBar();
	  
	        // add menu to menubar
	        mb.getMenus().add(menu1);
	        mb.getMenus().add(mmenu2);
	  
	        // create a VBox
	        bar = new VBox(mb);
	        bar.setAlignment(Pos.TOP_LEFT);
	        //vb.setMouseTransparent(true);
	        m1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					CreateMenu a = new CreateMenu();
				}
					
			});
	        
	        m2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					LoadMenu screen = new LoadMenu();
				}
					
			});
	        
	        m3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					App.startGame();
				}
					
			});
	        
	        m4.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					System.exit(0);
				}
					
			});
	        
	        m5.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					CreateMenu a = new CreateMenu();
				}
					
			});
	        
	        m6.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					App.revealSolution();
				}
					
			});

	}
	public VBox getBar() {
		return bar;
	}
	
}
