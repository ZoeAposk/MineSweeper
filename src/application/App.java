package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
	static Minesweeper myMinesweeper;
	static GridPane pane;
	static Scene scene;
	static ImageView[][] pics;
	static AnchorPane root;
	static Stage stage;
	static Label timeLabel;
	static Label minesLabel;
	static Label flagsLabel;
	static Label triesLabel;
	static boolean gameRunning=false;
	//static ;
	
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		root = new AnchorPane();
		scene = new Scene(root, 500, 250);

		new Bar();
		root.getChildren().add(Bar.getBar());

		stage.setTitle("Medialab Minesweeper");
		stage.setScene(scene);
		stage.show();
	}

	static public void revealSolution() {
		for (int i = 0; i < myMinesweeper.field.getSize(); i++) {
			for (int j = 0; j < myMinesweeper.field.getSize(); j++) {
				Tile t = myMinesweeper.field.getTileFromGrid(i, j);
				ImageView imView = new ImageView(t.getImg());
				pane.add(imView, j, i);

			}
		}

	}

	static public void loseGame() {
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText("You lost the game :(");
		alert.show();
		TimerBox.getTimeline().stop();
		revealSolution();
		myMinesweeper.myLevel.setWinner(false);
		RoundsScreen.addGame();
	}
	
	static public void winGame() {
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText("You won the game :)");
		alert.show();
		
		TimerBox.getTimeline().stop();

		myMinesweeper.myLevel.setWinner(true);
	}

	static public void startGame() {
		if (gameRunning) {
			loseGame();
			root.getChildren().removeAll(pane,minesLabel, timeLabel, flagsLabel, triesLabel);	
		}
		gameRunning=true;
		stage.setHeight(myMinesweeper.myLevel.getSceneSize());
		stage.setResizable(false);
		minesLabel = new Label("Mines: " + Integer.toString(myMinesweeper.myLevel.getMineNum()));
		AnchorPane.setTopAnchor(minesLabel, 35.0);
		AnchorPane.setLeftAnchor(minesLabel, 10.0);
		flagsLabel = new Label("Flags: " + Integer.toString(myMinesweeper.field.getFlags()));
		AnchorPane.setTopAnchor(flagsLabel, 75.0);
		AnchorPane.setLeftAnchor(flagsLabel, 10.0);
		triesLabel = new Label("Clicks: " + Integer.toString(myMinesweeper.myLevel.getTries()));
		AnchorPane.setTopAnchor(triesLabel, 115.0);
		AnchorPane.setLeftAnchor(triesLabel, 10.0);
		new TimerBox(myMinesweeper.myLevel.getTime());
		AnchorPane.setTopAnchor(timeLabel, 35.0);
		AnchorPane.setRightAnchor(timeLabel, 30.0);
		root.getChildren().addAll(minesLabel, flagsLabel,triesLabel, timeLabel);
		// AnchorPane.setRightAnchor(pane, 10.0);
		pane = new GridPane();
		pane.setAlignment(Pos.BOTTOM_CENTER);
		for (int i = 0; i < myMinesweeper.field.getSize(); i++) {
			for (int j = 0; j < myMinesweeper.field.getSize(); j++) {
				Tile t = myMinesweeper.field.getTileFromGrid(i, j);
				ImageView imView = new ImageView(t.getShown());
				pane.add(imView, j, i);
				imView.setPickOnBounds(true);
				imView.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
					@Override
					public void handle(javafx.scene.input.MouseEvent ev) {

						if (ev.getButton() == MouseButton.SECONDARY) {
							if (myMinesweeper.myGrid.getMinesGrid()[t.getX_pos()][t.getY_pos()] == 10 && myMinesweeper.myLevel.getTries()<5) {
								myMinesweeper.field.revealCross(t.getX_pos(), t.getY_pos());
							}
							else if (t.isFlagged()) {
								t.setShown(t.getStandard());
								t.setFlagged(false);
								myMinesweeper.field.decFlags();
							} else if (myMinesweeper.field.getFlags() < myMinesweeper.field.getMines()) {
								t.setShown(t.getFlag());
								t.setFlagged(true);
								myMinesweeper.field.incFlags();
							} 
							
							flagsLabel.setText("Flags: " + Integer.toString(myMinesweeper.field.getFlags()));
						} else {
							
							myMinesweeper.myLevel.incTries();
							triesLabel.setText("Clicks: " + Integer.toString(myMinesweeper.myLevel.getTries()));
							if (myMinesweeper.myGrid.getMinesGrid()[t.getX_pos()][t.getY_pos()] != 0) {
								loseGame();
							} else {
								myMinesweeper.field.reveal(t.getX_pos(), t.getY_pos());
							}
						}
						imView.setImage(t.getShown());
						if((myMinesweeper.field.getFlags()+myMinesweeper.field.getRevealedTiles())==(Math.pow(myMinesweeper.field.getSize(),2))) {
							winGame();
						}
					}

				});

			}
		}
		AnchorPane.setBottomAnchor(pane, 15.0);
		AnchorPane.setLeftAnchor(pane, 10.0);
		AnchorPane.setRightAnchor(pane, 10.0);

		root.getChildren().add(pane);

	}

}