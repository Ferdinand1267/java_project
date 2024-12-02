import javax.swing.SwingUtilities;

public class Play {
    public static void main(String[] args){
        SwingUtilities.invokeLater(GameGUI::new);
        //new GameGUI();
        //paint()
    }
}
