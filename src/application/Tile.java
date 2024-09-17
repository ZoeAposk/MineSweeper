package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.*;

public class Tile {
	private int x_pos;
	private int y_pos;
	private int num;
	private FileInputStream input;
	private Image shown;
	private Image standard;
	private Image img;
	private Image flag;
	private boolean visible = false;
	private boolean flagged = false;

	public Tile(int x, int y, int n) {
		num = n;
		x_pos = x;
		y_pos = y;
		try {
			standard = new Image(new FileInputStream("src/assets/blank.png"));
			shown = standard;
			flag = new Image(new FileInputStream("src/assets/flag.png"));
			if (n > 0 && n < 10) {
				input = new FileInputStream("src/assets/number" + Integer.toString(num) + ".png");
				img = new Image(input);
			} else if (n == 20) {
				input = new FileInputStream("src/assets/mine.png");
				img = new Image(input);
			} else if (n == 100) {
				input = new FileInputStream("src/assets/supermine.png");
				img = new Image(input);
			} else if (n == 0) {
				input = new FileInputStream("src/assets/exposed.png");
				img = new Image(input);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Image not Found");
			e.printStackTrace();
		}

	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

	public int getX_pos() {
		return x_pos;
	}

	public int getY_pos() {
		return y_pos;
	}

	public int getNum() {
		return num;
	}

	public FileInputStream getInput() {
		return input;
	}

	public Image getShown() {
		return shown;
	}

	public Image getStandard() {
		return standard;
	}

	public Image getImg() {
		return img;
	}

	public Image getFlag() {
		return flag;
	}

	public boolean isVisible() {
		return visible;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setShown(Image shown) {
		this.shown = shown;
	}

}
