
package blackjack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Blackjack {
    
    private static ArrayList<Player> players = new ArrayList();// the players of the game
    private static Scanner input = new Scanner(System.in);
    private static GroupOfCards deck = new GroupOfCards();//The deck of cards

    
    public static void main(String[] args) 
    {
        
        
        System.out.println("Welcome to Blackjack!");
        System.out.println("");
        System.out.println("Rules:");
        System.out.println(" - For each round, players can bet their credits, with a minimum bet of 100 per round.");
        System.out.println(" - You can either Hit or Stand, to either keep your current hand or get a new ceard dealt to you.");
        System.out.println(" - If you are closer to 21 than the dealer, then you win the round, and get double the credits you bet");
        System.out.println(" - You are out of the game once your credits reach 0, the last remaining player wins!");
        System.out.println("");
        System.out.print("Enter the number of players (up to 4) : ");
        int numPlayers = input.nextInt();
        System.out.println();
        
        for(int i = 0; i < numPlayers; i ++)
        {
            System.out.print("Enter the name of player "+ (i+1) +": ");
            String playerName = input.next();
            System.out.println();
            Player p = new Player(playerName);
            players.add(p);
        }
        
        play(players);
        
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) 
    {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public static void play(ArrayList<Player> players)
    {
        
        Player dealer = new Player("Dealer");
        
        //Initializing the players
        for(Player player : players)
        {
            System.out.println("Your credits: " + player.getCredits());
            System.out.println(player.name+ ", enter how much you want to bet this round (min 100, multiple of 100)(or \"1\" to exit):"); 
            int bet = input.nextInt();
            if(bet == 1)
            {
                System.exit(0);
            }
            while(bet < 100 || bet % 100 != 0)
            {
                System.out.println("Minimum 100 per bet and multiples of 100! Enter another bet: ");
                bet = input.nextInt();   
            }
            player.bet = bet;
            player.credits -= bet;
        }
        
        deck.shuffle();
        
        //Getting the player's starting hand
        for(Player player : players)
        {
            ArrayList<Card> cardsToRemove = new ArrayList();
            for(Card card : player.hand)
            {
                cardsToRemove.add(card);
            }
            player.hand.removeAll(cardsToRemove);
            
            player.hand.add(deck.getCards().get(0));
            player.hand.add(deck.getCards().get(1));
            
            deck.removeTopCard();
            deck.removeTopCard();
            
        }
        
        dealer.hand.add(deck.getCards().get(0));
        System.out.println("The Dealer's first card is: "+deck.getCards().get(0));
        System.out.println();
        dealer.hand.add(deck.getCards().get(1)); 
        deck.removeTopCard();
        deck.removeTopCard();
        
        //Player's turns
        for(Player player : players)
        {
            while(true)
            {
                System.out.print(player.getName() + ", your hand: ");
                for(Card card : player.hand)
                {
                    System.out.print(card.toString() + " ");
                }
                System.out.println();
                System.out.println("Your total is: " + player.calculateHand());
                
                System.out.println("Would you like to Hit or Stand?");
                String choice = input.next();
                System.out.println();
                if(choice.equals("Hit"))
                {
                    while(true)
                    {
                        
                        player.hand.add(deck.getCards().get(0));
                        deck.removeTopCard();
                        for(Card card : player.hand)
                        {
                            System.out.print(card.toString() + ", ");
                        }
                        System.out.println();
                        if(player.calculateHand() > 21)
                        {
                            System.out.println("Your total is: " + player.calculateHand());
                            System.out.println("You busted!");
                            System.out.println();
                            break;
                        }
                        System.out.println("Your total is: " + player.calculateHand());
                        System.out.println("Would you like to Hit or Stand?");
                        choice = input.next();
                        System.out.println();
                        if(choice.equals("Stand"))
                        {
                            break;
                        }
                        
                    }
                }
                else
                {
                    break;
                }
                break;
            }
        }
        System.out.println();
        
        //Dealer's Turn
        while(true)
        {
            
            System.out.println("Dealer's Turn!");
            
            for(Card card : dealer.hand)
                {
                    System.out.print(card.toString() + ", ");
                }
            System.out.println();
            System.out.println("Dealer's total is: " + dealer.calculateHand());
            
            if(dealer.calculateHand() < 15)
            {
                while(true)
                {
                    System.out.println("Dealer Hits!");
                    dealer.hand.add(deck.getCards().get(0));
                    System.out.println("Dealer pulled " + deck.getCards().get(0).toString());
                    deck.removeTopCard();
                    System.out.println("Dealer's total is: " + dealer.calculateHand());
                    System.out.println();
                    if(dealer.calculateHand() >= 15)
                    {
                        break;
                    }
                }
            }
            else
            {
                
                System.out.println("Dealer Stands!");
                System.out.println();
                
            }
            
            break;    
        }
        
        //Calculating who won the round
        for(Player player : players)
        {
            if(player.calculateHand() <= 21 && dealer.calculateHand() > 21)
            {
                System.out.println(player.getName() + " beat the dealer!");
                player.credits += player.bet * 2;
                System.out.println();
            }
            else if(player.calculateHand() > dealer.calculateHand() && player.calculateHand() <= 21 && dealer.calculateHand() <= 21)
            {
                System.out.println(player.getName() + " beat the dealer!");
                player.credits += player.bet * 2;
                System.out.println();
            }
            else if(player.calculateHand() == dealer.calculateHand() && player.calculateHand() <= 21)
            {
                System.out.println(player.getName() + " tied the dealer!");
                player.credits += player.bet;
                System.out.println();
            }
            else
            {
                System.out.println(player.getName() + " lost to the dealer!");
                System.out.println();
            }
        }
        
        //Removing players who are out of the game
        ArrayList<Player> toRemove = new ArrayList();
        for(Player player : players)
        {
            if(player.credits == 0)
            {
                System.out.println(player.getName() + " is out of the game!");
                System.out.println();
                toRemove.add(player);
            }
        }
        players.removeAll(toRemove);
        
        //Checking to see if there is a winner
        if(players.size() > 1)
        {
            play(players);
        }
        else if(players.size() == 0)
        {
            System.out.println("Everyone lost! :)");
        }
        else
        {
            declareWinner();
        }
        
                
    }

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public static void declareWinner()
    {
        System.out.println(players.get(0).getName() + " won the game!");
    }
}