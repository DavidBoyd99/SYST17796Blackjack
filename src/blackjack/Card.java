
package blackjack;


public class Card {
    
    public String suit;
    public int value;
    
    public Card(String newSuit, int newValue)
    {
        
        if(newValue > 1 || newValue < 13)
        {
            this.value = newValue;
        }
        if(newSuit == "Hearts" || newSuit == "Diamonds" || newSuit == "Clubs" || newSuit == "Spades")
        {
            this.suit = newSuit;
        }
        
    }
    
    public String getSuit()
    {
        return this.suit;
    }
    
    public String toString()
    {
        if(this.value == 11)
            return "Jack of " + this.suit;
        else if(this.value == 12)
            return "Queen of " + this.suit;
        else if(this.value == 13)
            return "King of " + this.suit;
        else if(this.value == 1)
            return "Ace of " + this.suit;
        else
            return this.value + " of " + this.suit;
    }
    
    public String getValueName()
    {
        
        if(this.value == 1)
        {
            return "Ace";
        }
        else if(this.value == 2)
        {
            return "Two";
        }
        else if(this.value == 3)
        {
            return "Three";
        }
        else if(this.value == 4)
        {
            return "Four";
        }
        else if(this.value == 5)
        {
            return "Five";
        }
        else if(this.value == 6)
        {
            return "Six";
        }
        else if(this.value == 7)
        {
            return "Seven";
        }
        else if(this.value == 8)
        {
            return "Eight";
        }
        else if(this.value == 9)
        {
            return "Nine";
        }
        else if(this.value == 10)
        {
            return "Ten";
        }
        else if(this.value == 11)
        {
            return "Jack";
        }
        else if(this.value == 12)
        {
            return "Queen";
        }
        else if(this.value == 13)
        {
            return "King";
        }
        
        return "";
        
    }
    
    
}
