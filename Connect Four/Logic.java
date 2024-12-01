import java.awt.Point;
import java.util.Stack;

public class Logic{
    private Board board;
    // "private Stack<Point> moves;" might not be needed
	private String error;
	private boolean gameOver;
	private boolean redWins;
	private boolean yellowWins;
    
    public Logic(Board board){
        this.board = board;
        // "moves = new Stack<>();" might not be needed
        gameOver = false;
        redWins = false;
        yellowWins = false;
    }
    
    public boolean checkWin(){
        gameOver = false;
        redWins = false;
        yellowWins = false;
        char[][] gameBoard = board.getBoard();
        char turn = board.getTurn();
        if (checkRows(gameBoard,turn) || checkColumns(gameBoard,turn) || checkDiagonal(gameBoard,turn)){
            if(turn == 'r'){
                redWins = true;
                gameOver = true;
                return true;
            }
            else{
                yellowWins = true;
                gameOver = true;
                return true;
            }
        }
        else{
            for (int i = 0;i<gameBoard.length;i++){
                if(gameBoard[i][gameBoard[0].length-1]==' '){
                    break;
                }
                else if(i == gameBoard.length - 1){
                    gameOver = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRows(char[][] gameBoard, char turn){
        int count = 0;
        for (int i = 0; i < board.getRow();i++){
            for (int j = 0;j < board.getCol();j++){
                if(gameBoard[i][j] == ' ' || gameBoard[i][j]!= turn){
                    count = 0;
                }
                else { 
                    count += 1;
                    if(count==4){
                        return true;
                    }
                }
                
            }
        }
        return false;   
    }

    public boolean checkColumns(char[][] gameBoard, char turn){
        int count = 0;
        for (int i = 0; i < board.getCol();i++){
            for (int j = 0;j < board.getRow();j++){
                if(gameBoard[i][j] == ' ' || gameBoard[i][j]!= turn){
                    count = 0;
                }
                else { 
                    count += 1;
                    if(count==4){
                        return true;
                    }
                }
                
            }
        }
        return false;   
    }

    public boolean checkDiagonal(char[][] gameBoard, char turn){
        for (int i = 0; i < 3;i++){
            for (int j = 0; j < 4;j++){
                if (gameBoard[i][j] == turn && gameBoard[i+1][j+1] == turn && gameBoard[i+2][j+2] == turn &&gameBoard[i+3][j+3] == turn){
                    return true;
                }
            }
        }
        for (int i = board.getRow();i>board.getRow()-3;i--){
            for (int j = 0; j<4;j++){
                if (gameBoard[i][j] == turn && gameBoard[i-1][j+1] == turn && gameBoard[i-2][j+2] == turn &&gameBoard[i-3][j+3] == turn){
                    return true;
                }
            }
        }
        return false;
    }
}