package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Grid{
    int size;
    int[][] minesGrid;
    int[][] numGrid;
    boolean superMine;

    public Grid(Level l){
        size=l.gridSize;
        superMine=l.superMine;
        minesGrid = new int[size][size];
        this.fillGrid(l.mineNum);
        numGrid = new int[size][size];
        this.countNeighbours();
        
    }

    public void printGrid(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(minesGrid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public void printNeighbours(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(numGrid[i][j] + " ");
                if(numGrid[i][j]<10){
                    System.out.print(" ");    
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private void fillGrid(int num){
        try{
            File myObj = new File("src/medialab/mines.txt");
            myObj.createNewFile();
            FileWriter fileWriter =  new FileWriter ("src/medialab/mines.txt", false);
            int min=0;
            int max=this.size-1;
            int i,j;
            if (this.superMine==true){
                i=(int)Math.floor(Math.random()*(max-min+1)+min);
                j=(int)Math.floor(Math.random()*(max-min+1)+min);
                this.minesGrid[i][j]=10;
                num--;
                try {
                    fileWriter.write(i+","+j+","+"1\n");
                } catch (IOException e) {
                    System.out.println("An error occurred, while writing super-mine.");
                    e.printStackTrace();
                }
            }
            for(int z=0; z<num; z++){
                i=(int)Math.floor(Math.random()*(max-min+1)+min);
                j=(int)Math.floor(Math.random()*(max-min+1)+min);
                if(this.minesGrid[i][j]==0){
                    this.minesGrid[i][j]=1;
                    try {
                        fileWriter.write(i+","+j+","+"0\n");
                    } catch (IOException e) {
                        System.out.println("An error occurred, while writing mine.");
                        e.printStackTrace();
                    }
                }
                else{
                    z--;
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred, while creating mines.txt.");
            e.printStackTrace();
        }  
    }

    private void countNeighbours(){
        int sum;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                sum=0;

                for(int a=i-1; a<=i+1; a++){
                    for(int b=j-1; b<=j+1; b++){
                        if(a>=0 && a<this.size && b>=0 && b<this.size){
                            if(minesGrid[a][b]!=0){
                                sum++;
                            }
                        }
                    }
                    if(minesGrid[i][j]==0){
                        this.numGrid[i][j]=sum;
                    }
                    else if (minesGrid[i][j]==10){
                        this.numGrid[i][j]=100;
                    }
                    else {
                    	this.numGrid[i][j]=20;
                    }
                    
                }
            }
            System.out.println();
        }
    }

}