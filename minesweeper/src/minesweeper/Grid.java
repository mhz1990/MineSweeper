package minesweeper;
import java.util.Arrays;
import java.util.Random;


public class Grid {
    private int width,height,minesCount;
    private Square[][] field;
    private Mine[] mines;
    private Game CurrentGame;

    public Grid(int width,int height,int minesNumber) {
        this.width=width;
        this.height=height;
        this.minesCount=minesNumber;
        InitGrid();
    }
    public int getWidth(){return this.width;}
    public int getHeight(){return this.height;}

    public Square[][] getField() {
        return field;
    }

    public void InitGrid() {
        field = new Square[height][width];
        //to generate random coordinates for mines
        boolean[][] minesCoordinates = new boolean[height][width];
        //fill the matrix it with false 
         for (int i = 0 ;i < height; i++) { 
             Arrays.fill(minesCoordinates[i], false);
        }
         //fill random coordinates with true (number of coordinates according to nnumber of mines)
         for (int i = 0 ;i < minesCount; i++) {
             Random rand = new Random();
             int randomWidth,randomHeight;
             //checking that there is no duplicated mines in one square
             while (true) { 
                 randomWidth = rand.nextInt(width);
                 randomHeight = rand.nextInt(height);
                 if (!minesCoordinates[randomHeight][randomWidth]) { 
                     minesCoordinates[randomHeight][randomWidth] = true;
                     break;
                 }
             }
         }
        //init sqaures inside the field
        for (int i = 0 ;i < height; i++) { 
            for (int j = 0;j < width; j++) { 
                field[i][j] = new Square(i, j,minesCoordinates[i][j]);
            }
        }
    }
        
    public void AcceptMove(PlayerMove move) { 
        
    }
    
}
