import java.awt.Point;
import java.util.Stack;

public class Logic{
    private Board board;
    private Stack<Point> moves;
	private String error;
	private boolean gameOver;
	private boolean redWins;
	private boolean yellowWins;
    
    public Logic(Board board){
        this.board = board;
        moves = new Stack<>();
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
                if(gameBoard[0][gameBoard[0].length-1]==' '){
                    break;
                }
                else if(i == gameBoard.length - 1){
                    gameOver = true;
                    return true;
                }
            }
        }
    }
}