import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GameGUI extends JFrame implements  MouseListener{
    private Board board;
    private Logic logic;
    private boolean gameOver = false;
    
    public GameGUI() {
        this.board = new Board();
        this.logic = new Logic(board);
        setSize(700,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setBackground(Color.BLUE);
        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(0,0,255));
        g.fillRect(0,0,700,600);
        int startX = 0;
        int startY = 0;
        char[][] gameBoard = board.getBoard();
        for (int i = 0; i<board.getRow();i++){
            for (int j = 0; j<board.getCol();j++){
                if (gameBoard[i][j]=='r'){
                    g.setColor(new Color(255,0,0));
                }
                else if(gameBoard[i][j] == 'y'){
                    g.setColor(new Color(255,255,0));
                }
                else{
                    g.setColor(new Color(0,0,0));
                }
                g.fillOval(startX,startY,100,100);
                startX += 100;
            }
            startX = 0;
            startY += 100;
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (gameOver == true) return;
        int column = e.getX() / 100;
        if(board.drop(column)){
            repaint();
            if (logic.checkWin() == true){
                gameOver = true;
            }
            else{
                board.switchPlayer();
            }
        }
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    //public static void main(String[] args){
      //  SwingUtilities.invokeLater(GameGUI::new);
        //new GameGUI();
        //paint()
}

