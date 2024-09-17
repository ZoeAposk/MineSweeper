package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RoundsScreen {
	static ObservableList<Level> games =  FXCollections.observableArrayList();
	//Level[] games = new Level[5]; 
	static TableView<Level> table;
	public RoundsScreen() {
		Stage st = new Stage();
		StackPane pane = new StackPane();
		//AnchorPane pane = new AnchorPane();
		Scene roundsScene = new Scene(pane, 400, 250);
		st.setTitle("Rounds");
		st.setScene(roundsScene);
		st.show();
		table = new TableView<>();
	    table.setEditable(false);
	    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	    TableColumn idCol = new TableColumn("Game");
	    idCol.setCellValueFactory(new PropertyValueFactory<>("mines"));
	    TableColumn minesCol = new TableColumn("Mines");
	    minesCol.setCellValueFactory(new PropertyValueFactory<>("mines"));
	    TableColumn clicksCol = new TableColumn("Tries");
	    clicksCol.setCellValueFactory(new PropertyValueFactory<>("tries"));
	    TableColumn timeCol = new TableColumn("Time");
	    timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
	    TableColumn winnerCol = new TableColumn("Winner");
	    winnerCol.setCellValueFactory(new PropertyValueFactory<>("winner"));
	            
	    table.getColumns().addAll(idCol, minesCol, clicksCol, timeCol, winnerCol);
	 	    
	    pane.getChildren().add(table);

	}
	
	static public void addGame() {
		games.add(App.myMinesweeper.myLevel);
	}
	
	
}

