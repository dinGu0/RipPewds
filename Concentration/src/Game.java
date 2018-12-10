import java.awt.Dimension;
import javax.swing.JFrame;


public class Game{
	
    public static void main(String[] args){
        Board board = new Board();
        board.setPreferredSize(new Dimension(500,500));

        board.setLocation(500, 250);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.pack();
        board.setResizable(false); 
        board.setVisible(true);
    }
}

