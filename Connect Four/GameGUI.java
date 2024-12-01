import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GameGUI extends JFrame{
    private JFrame frame;
    private JPanel panel;
    
    public GameGUI() {
        Board board = new Board();
        Logic logic = new Logic(board);
        setBackground(Color.BLUE);
        frame = new JFrame("Connect 4");
        frame.setSize(700,600);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
    }
}