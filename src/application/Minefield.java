package application;

import javafx.scene.image.ImageView;

public class Minefield {
	private Tile[][] tileGrid;
	private int size;
	private int flags;
	private int revealedTiles;
	private int mines;

	public Minefield(int[][] grid, int n, int mines) {
		this.mines = mines;
		flags = 0;
		size = n;
		tileGrid = new Tile[size][size];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tileGrid[i][j] = new Tile(i, j, grid[i][j]);
			}
		}

	}

	public int getRevealedTiles() {
		return revealedTiles;
	}

	public void incFlags() {
		this.flags++;
	}

	public void decFlags() {
		this.flags--;
	}

	public int getFlags() {
		return flags;
	}

	public int getMines() {
		return mines;
	}

	public Tile getTileFromGrid(int x, int y) {
		return tileGrid[x][y];
	}

	public int getSize() {
		return size;
	}

	public void reveal(int x, int y) {
		if (tileGrid[x][y].isFlagged())
			decFlags();
		tileGrid[x][y].setShown(tileGrid[x][y].getImg());
		tileGrid[x][y].setVisible(true);
		revealedTiles = getRevealedTiles() + 1;
		ImageView imView = new ImageView(tileGrid[x][y].getShown());
		App.pane.add(imView, y, x);
		if (tileGrid[x][y].getNum() == 0) {
			for (int a = x - 1; a <= x + 1; a++) {
				for (int b = y - 1; b <= y + 1; b++) {
					if (a == x && b == y)
						continue;
					if (a >= 0 && a < this.size && b >= 0 && b < this.size) {
						if (!tileGrid[a][b].isVisible() && !tileGrid[a][b].isFlagged()) {
							this.reveal(a, b);
						}
					}
				}
			}
		}

	}

	public void revealCross(int x, int y) {
		for (int i = 0; i < this.size; i++) {
			if (!tileGrid[i][y].isVisible()) {
				if (tileGrid[i][y].isFlagged())
					decFlags();
				revealedTiles = getRevealedTiles() + 1;
				tileGrid[i][y].setShown(tileGrid[i][y].getImg());
				tileGrid[i][y].setVisible(true);
				ImageView imView = new ImageView(tileGrid[i][y].getShown());
				App.pane.add(imView, y, i);
			}
			if (!tileGrid[x][i].isVisible()) {
				if (tileGrid[x][i].isFlagged())
					decFlags();
				revealedTiles = getRevealedTiles() + 1;
				tileGrid[x][i].setShown(tileGrid[x][i].getImg());
				tileGrid[x][i].setVisible(true);
				ImageView imView1 = new ImageView(tileGrid[x][i].getShown());
				App.pane.add(imView1, i, x);
			}
		}

	}

}
