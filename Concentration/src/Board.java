import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@SuppressWarnings("serial")
public class Board extends JFrame{

    private List<Card> cards;
    private int pairs;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private Timer t;
	private List<Card> cardsList = new ArrayList<Card>();
	private List<Integer> cardVals = new ArrayList<Integer>();

    public Board(){

        pairs = 12;
   
        
        for (int i = 0; i < pairs; i++){ 
            cardVals.add(i);
            cardVals.add(i);
            
        }
        Collections.shuffle(cardVals);

        for (int val : cardVals){
            Card c = new Card(); 
            c.setId(val+3); 
            c.initImage();
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    selectedCard = c;
                    flipCards();
                }
            });
            cardsList.add(c);
        }
        this.cards = cardsList;
        t = new Timer(750, new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                checkCards();
            }
        });

        t.setRepeats(false);

        Container pane = getContentPane();
        int hgap = 20;
        int vgap = 20;
        pane.setLayout(new GridLayout(4, 6, hgap, vgap)); 
        for (Card c : cards){
            pane.add(c);
        }
        setTitle("Concentration");
    }

    public void flipCards(){
        if (c1 == null && c2 == null){
            c1 = selectedCard;
            c1.setImage(""+c1.getId()+".jpg"); 
        }

        if (c1 != null && c1 != selectedCard && c2 == null){
            c2 = selectedCard;
            c2.setImage(""+c2.getId()+".jpg");
            t.start(); 

        }
    }

    public void checkCards(){
        if (c1.getId() == c2.getId()){ 
            c1.setEnabled(false); 
            c2.setEnabled(false);
            c1.setMatched(true); 
            c2.setMatched(true);
            if (this.isGameOver() == true){
                JOptionPane.showMessageDialog(this, "Congratulations! You solved the board");
            }
        }

        else{
            c1.initImage(); 
            c2.initImage();
        }
        c1 = null; 
        c2 = null;
    }

    public boolean isGameOver(){
        for(Card c: this.cards){
            if (c.getMatched() == false){
                return false;
            }
        }
        return true;
    }
    
    

}