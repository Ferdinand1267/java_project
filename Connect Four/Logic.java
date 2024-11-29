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
    
}