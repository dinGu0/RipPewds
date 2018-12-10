import java.awt.Dimension;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")

public class Card extends JButton{ 
	
	private int id;
    private boolean matched = false;

    public void setId(int id){ 
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void initImage() {
    		this.setPreferredSize(new Dimension(75, 100));
    		try {
	            Image card = ImageIO.read(getClass().getResource("card.jpeg")); 
	            this.setIcon(new ImageIcon(card));
	          } catch (Exception ex) { 
	            System.out.println(ex);
	          }
    }
    
    public void setImage(String imageName) {
    		this.setPreferredSize(new Dimension(75, 100));
    		try {
            Image card = ImageIO.read(getClass().getResource(imageName)); 
            this.setIcon(new ImageIcon(card));
          } catch (Exception ex) {
            System.out.println(ex);
          }
    }
    
    public void setMatched(boolean matched){
        this.matched = matched;
    }

    public boolean getMatched(){
        return this.matched;
    }
}