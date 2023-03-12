package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;

public class App extends Application {
	static Minesweeper ms;
	static GridPane pane;
	static Scene scene;
	static ImageView[][] pics;
	static AnchorPane root;
	static Stage stage;

  @Override
  public void start(Stage primaryStage) {
	  stage=primaryStage;
	  root = new AnchorPane();
	  scene = new Scene(root,500,250);
	  
	  Bar bar = new Bar();
	  root.getChildren().add(bar.getBar());  
	  
	    
//	  pane = new GridPane();
//	  pane.setAlignment(Pos.BOTTOM_CENTER);
//	  pics = new ImageView[ms.field.size][ms.field.size];
//	  for(int i=0; i<ms.field.size; i++) {
//			for(int j=0; j<ms.field.size; j++) {
//				Tile t = ms.field.tileGrid[i][j];
//				ImageView imView = new ImageView(t.getShown());
//				pane.add(imView, j, i);
//				imView.setPickOnBounds(true);
//				imView.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
//					@Override
//					public void handle(javafx.scene.input.MouseEvent ev) {
//						
//						if(ev.getButton()==MouseButton.SECONDARY) {
//							t.setShown(t.getFlag());
//							t.setFlagged(true);
//						}
//						else {
//							ms.field.reveal(t.getX_pos(), t.getY_pos());	
//						}
//						ImageView imView = new ImageView(t.getShown());
//						pane.add(imView, t.getY_pos(), t.getX_pos());
//					}
//	
//					
//				});
//
//				
//			}
//		}

//	  AnchorPane.setBottomAnchor(pane, 15.0);
//	  AnchorPane.setLeftAnchor(pane, 10.0);
//	  AnchorPane.setRightAnchor(pane, 10.0);
//	  
//	  root.getChildren().add(pane);
//	  
	  
	  //scene = new Scene(pane,500,500);



	  stage.setTitle("Medialab Minefield");
      stage.setScene(scene);
      stage.show();
  }
  
  static public void revealSolution() {
	  for(int i=0; i<ms.field.size; i++) {
			for(int j=0; j<ms.field.size; j++) {
				Tile t = ms.field.tileGrid[i][j];
				ImageView imView = new ImageView(t.getImg());
				pane.add(imView, j, i);
				
//				imView.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
//					@Override
//					public void handle(javafx.scene.input.MouseEvent ev) {
//						
//						if(ev.getButton()==MouseButton.SECONDARY) {
//							t.shown = t.flag;
//							t.flagged=true;
//						}
//						else {
//							ms.field.reveal(t.x_pos, t.y_pos);	
//						}
//						ImageView imView = new ImageView(t.shown);
//						pane.add(imView, t.y_pos, t.x_pos);
//					}
//	
//					
//				});

				
			}
		}
	
}

  static public void startGame() {
	  if(ms!=null) {
		  
	  }
	  stage.setHeight(ms.myLevel.sceneSize);
	  stage.setResizable(false);
	  pane = new GridPane();
	  pane.setAlignment(Pos.BOTTOM_CENTER);
	  for(int i=0; i<ms.field.size; i++) {
			for(int j=0; j<ms.field.size; j++) {
				Tile t = ms.field.tileGrid[i][j];
				ImageView imView = new ImageView(t.getShown());
				pane.add(imView, j, i);
				imView.setPickOnBounds(true);
				imView.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
					@Override
					public void handle(javafx.scene.input.MouseEvent ev) {
						
						if(ev.getButton()==MouseButton.SECONDARY) {
							if (t.isFlagged()) {
								t.setShown(t.getStandard());
								t.setFlagged(false);
							}
							else {
							t.setShown(t.getFlag());
							t.setFlagged(true);
							}
						}
						else {
							ms.field.reveal(t.getX_pos(), t.getY_pos());	
						}
						imView.setImage(t.getShown());
						//pane.add(imView, t.getY_pos(), t.getX_pos());
						//imView.setPickOnBounds(true);
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