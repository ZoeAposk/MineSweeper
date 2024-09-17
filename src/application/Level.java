package application;

public class Level {
	private final int difficulty;
	private final int gridSize;
	private final int mineNum;
	private final int time;
	private final boolean superMine;
	private final int sceneSize;
	private int tries=0;
	private boolean winner;


	public Level(int a, int b, int c, int d) throws InvalidValueException {
		difficulty = a;

		if (a == 1) {
			gridSize = 9;
			sceneSize = 450;
			if (b > 8 && b < 12) {
				mineNum = b;
			} else {
				throw new InvalidValueException("For Difficulty 1 number of mines should be between 9 and 11");
			}
			if (c > 119 && c < 181) {
				time = c;
			} else {
				throw new InvalidValueException("For Difficulty 1 time should be between 120 and 180");
			}
			if (d == 0) {
				superMine = false;
			} else {
				throw new InvalidValueException("For Difficulty 1 super-mine value should be 0 (false)");
			}
		} else if (a == 2) {
			gridSize = 16;
			sceneSize = 600;
			if (b > 34 && b < 46) {
				mineNum = b;
			} else {
				throw new InvalidValueException("For Difficulty 2 number of mines should be between 35 and 45");
			}
			if (c > 239 && c < 361) {
				time = c;
			} else {
				throw new InvalidValueException("For Difficulty 2 time should be between 240 and 360");
			}
			if (d == 0 || d == 1) {
				superMine = (d == 1);
			} else {
				throw new InvalidValueException("Super-mine value can either be 0 (false) or 1 (true)");
			}
		} else {
			throw new InvalidValueException("Difficulty can be either 1 or 2.");
		}
	}

	public int getTries() {
		return tries;
	}

	public void incTries() {
		this.tries++;
	}
	
	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public int getGridSize() {
		return gridSize;
	}

	public int getMineNum() {
		return mineNum;
	}

	public int getTime() {
		return time;
	}

	public boolean isSuperMine() {
		return superMine;
	}

	public int getSceneSize() {
		return sceneSize;
	}

	public void printSpecs() {
		System.out.println("Difficulty: " + difficulty);
		System.out.println("Gride Size: " + gridSize);
		System.out.println("Mines: " + mineNum);
		System.out.println("Time: " + time);
		System.out.println("Super Mine: " + superMine);
	}

}