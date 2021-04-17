package blackjack;

import java.util.ArrayList;
import java.util.Collections;


public class GroupOfCards {
    
    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList();
    private int size;//the size of the deck
    

    public GroupOfCards() {
        this.size = 52;
        
        for(int i = 1; i <= 13; i++)
        {
            
            Card d = new Card("Diamonds", i);
            Card h = new Card("Hearts", i);
            Card c = new Card("Clubs", i);
            Card s = new Card("Spades", i);
            
            cards.add(d);
            cards.add(h);
            cards.add(s);
            cards.add(c);
            
        }
                
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() 
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }
    
    public void removeTopCard()
    {
        this.cards.remove(0);
    }

    
}
