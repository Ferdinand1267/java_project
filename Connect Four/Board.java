<<<<<<< HEAD
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Board extends JFrame{
    private int row = 6;
    private int col = 7;
    private int cellSize = 100;
    
    
}
=======
public class Board{
    private int row = 6;
    private int col = 7;
    private char[][] board = new char[row][col];
    private char turn = 'r';
    
    // Constructor which initializes the board with empty values.
    public Board() {
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                board[i][j] = (Character) null;
            }
        }
    }

    // getter and setter methods for player's turn
    public char getTurn() {
        return turn;
    }

    public void setTurn(char x) {
        turn = x;
    }

    public void switchPlayer() {
        if(turn == 'r') {
            turn = 'y';
         } else {
            turn = 'r';
         }
    }
    
    //getter method to get board
    public char[][] getBoard() {
        return board;
    }

    
    
}
>>>>>>> 0f87e763801d0f98833a4598ce90482596719721
