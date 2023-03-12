package application;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.Label;


public class TimerBox {
	int time;
	public TimerBox(int t) {
		time=t;
		Timer myTimer = new Timer();
		myTimer.schedule(new TimerTask() {
			
			
			@Override
			public void run() {
				Alert a = new Alert(AlertType.WARNING);
				a.show();
				App.pane.add(new Label("HI"), 0, -1);
				
			}
		}, time*10);
		
	}
}
