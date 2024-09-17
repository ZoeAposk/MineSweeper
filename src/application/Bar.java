package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class Bar {
	private static VBox bar;
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
					new CreateMenu();
				}
					
			});
	        
	        m2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					new LoadMenu();
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
					new RoundsScreen ();
				}
					
			});
	        
	        m6.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					App.loseGame();
				}
					
			});

	}
	public static VBox getBar() {
		return bar;
	}
	
}
