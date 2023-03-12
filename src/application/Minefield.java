package application;

import javafx.scene.image.ImageView;

public class Minefield {
	Tile[][] tileGrid;
	int size;
	public Minefield(int[][] grid, int n) {
		size=n;
		tileGrid = new Tile[size][size];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tileGrid[i][j] = new Tile(i, j, grid[i][j]);
			}
		}
		
	}
	
	public void reveal(int x, int y) {
		tileGrid[x][y].setShown(tileGrid[x][y].getImg());
		tileGrid[x][y].setVisible(true);
		ImageView imView = new ImageView(tileGrid[x][y].getShown());
		App.pane.add(imView, y, x);
		if (tileGrid[x][y].getNum()==0) {	
			for(int a=x-1; a<=x+1; a++){
                for(int b=y-1; b<=y+1; b++){
                	if(a==x && b==y)
                		continue;
                    if(a>=0 && a<this.size && b>=0 && b<this.size ){
                    	if(!tileGrid[a][b].isVisible() && !tileGrid[a][b].isFlagged()) {
                    		this.reveal(a, b);
                    	}
                    }
                }
			}
		}

	}

}
