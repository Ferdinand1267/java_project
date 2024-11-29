import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame{
    private Board board;
    private Logic logic;   
    public GameGUI() {
        board = new Board();
        logic = new Logic(board.getBoard(), board.getTurn());
    }
}