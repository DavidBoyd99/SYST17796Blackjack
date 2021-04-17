
package blackjack;

import java.util.ArrayList;


public class Player {
    
    public String name; //the unique name for this player
    public int credits; //the credits this player has to bet
    public ArrayList<Card> hand = new ArrayList(); //the cards in the player's hand
    public int bet;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) 
    {
        this.name = name;
        this.credits = 1000;
    }

    /**
     * @return the player name
     */
    public String getName() 
    {
        return name;
    }
    
    //Returns the player's credits
    public int getCredits()
    {
        return this.credits;
    }
    
    public int calculateHand()
    {
        int total = 0;
        
        for(Card card : hand)
        {
            if(card.value == 11 || card.value == 12 || card.value == 13)
            {
                total += 10;
            }
            else if(card.value == 1 && total >= 10)
            {
                total += 11;
            }
            else if(card.value == 1)
            {
                total += 1;
            }
            else
            {
                total += card.value;
            }
        }
        
        return total;
        
    }
    
}
    

