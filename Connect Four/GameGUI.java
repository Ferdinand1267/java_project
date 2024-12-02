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
        setSize(700,600);     // the following lines are general gui codes that set up the window such as setting size and color
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setBackground(Color.BLUE);
        setVisible(true);
    }

    public void paint(Graphics g){ // this method prints the grid and its tokens
        super.paint(g);
        g.setColor(new Color(0,0,255));
        g.fillRect(0,0,700,600);
        int startX = 0; // starting x and y coordinates
        int startY = 0;
        char[][] gameBoard = board.getBoard();
        for (int i = 0; i<board.getRow();i++){  //these loops goes and prints the 6 by 7 grid of ovals and changes the color depending on which color the spot is set to.
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
                startX += 100; //this moves the position by one spot horizontally each time
            }
            startX = 0; // starts back at 0 to avoid it from keep incrementing over the grid size
            startY += 100; //moves downwards to the next row
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (gameOver == true) return;
        int column = e.getX() / 100; // getX() /100 gives the x coordinate which is also the column
        if(board.drop(column)){
            repaint(); //repaints to update the board each time
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

