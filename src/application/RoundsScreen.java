package application;

public class RoundsScreen {

}

//Helper Class
class Game{
	int mines;
	int tries;
	int time;
	boolean winner;
	int place;
	
	public Game(int m, int tr, int time, boolean w) {
		this.mines=m;
		this.tries=tr;
		this.time=time;
		this.winner=w;
		this.place=1;
		
	}
}
