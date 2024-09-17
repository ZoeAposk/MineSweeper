package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * Class TimerBox. This class is responsible for creating a Timeline
 * that changes every 1 second and lasts for the starting amount of time given.
 * Every 1 second the class changes the static label App.timeLabel that displays
 * the remaining seconds in the game.
 */

public class TimerBox {
	
	private static int time;
	private static Timeline timeline;
	
	/**
	 * Constructor of class TimerBox. Initializes the Timeline so that it
	 * changes every 1 second and lasts for the starting amount of time given.
	 * Every 1 second the class changes the static label App.timeLabel that displays
	 * the remaining seconds in the game.
	 *  
	 * @param	t	the amount of starting time
	 * @see			Timeline	
	 */
	public TimerBox(int t) {
		time=t;
		App.timeLabel = new Label("Time: " + Integer.toString(time));
		timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
			time--;
			App.timeLabel.setText("Time: " + Integer.toString(time));

			if(time==0)
				App.loseGame();
	    }));
	    timeline.setCycleCount(t);
	    timeline.play();
	}
	
	/**
	 * Returns a Timeline object.
	 * @return	the static attribute timeline of the calss
	 * @see		Timeline
	 */
	public static Timeline getTimeline() {
		return timeline;
	}
	
	
}
