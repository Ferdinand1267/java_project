import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GameGUI extends JFrame implements  MouseListener{
    private JFrame frame;
    private Board board;
    private Logic logic;
    private boolean gameOver = false;
    
    public GameGUI() {
        Board board = new Board();
        Logic logic = new Logic(board);
        frame = new JFrame("Connect 4");
        frame.setSize(700,600);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addMouseListener(this);
        frame.setBackground(Color.BLUE);
        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,700,600);
        g.setColor(new Color(0,0,255));
        int startX = 0;
        int startY = 0;
        char[][] gameBoard = board.getBoard();
        for (int i = 0; i<board.getRow();i++){
            for (int j = 0; j<board.getCol();j++){
                if (gameBoard[i][j]=='r'){
                    g.setColor(new Color(255,0,0));
                    g.fillOval(startX,startY,80,80);
                }
                else if(gameBoard[i][j] == 'y'){
                    g.setColor(new Color(0,0,0));
                    g.fillOval(startX,startY,80,80);
                }
                else{
                    g.setColor(new Color(255,255,0));
                    g.fillOval(startX,startY,80,80);
                }
                startX += 80;
            }
            startX = 0;
            startY += 80;
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (gameOver == true) return;
        int column = e.getX() / 100;
        if(board.drop(column) == true){
            repaint();
        }
            if (logic.checkWin() == true){
               gameOver = true;
            }
        else{
            board.switchPlayer();
        }
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public static void main(String[] args){
        SwingUtilities.invokeLater(GameGUI::new);
    }

}