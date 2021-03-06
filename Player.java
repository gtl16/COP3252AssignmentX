import java.util.*;
 
public class Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private boolean playersTurn = false;
    private boolean playerSkipsTurn = false;
    private boolean playerSaysUno = false;
    private boolean playerWon = false;
    private Card lastDiscarded;
    
    public Player() {
    }
    
    public void addCardToHand(Card c) {
        hand.add(c);
    }
    
    public void removeCardFromHand(Card c) {
        hand.remove(c);    
    }
    
    public void getHandSize() {
        return hand.size();
    }
    
    public int sumHand() {
        int sum = 0;
        
        for(Card c : hand) {
            if(c.getValue().startsWith("1") 
               || c.getValue().startsWith("2")
               || c.getValue().startsWith("3")
               || c.getValue().startsWith("4")
               || c.getValue().startsWith("5")
               || c.getValue().startsWith("6")
               || c.getValue().startsWith("7")
               || c.getValue().startsWith("8")
               || c.getValue().startsWith("9")) {
                  sum += c.getValue().charAt(0);
            } else if(c.getValue().startsWith("wild")) {
                sum += 50;
            } else {
                  sum += 20;
            }
        } 
        
        return sum;
    }
    
     public ArrayList<Card> getHand() {
        return hand;
    }
    
    public void changeTurn(boolean b) {
        playersTurn = b;
    }
    
    public boolean getTurn() {
        return playersTurn;
    }
    
    public void changeSkipTurn(boolean b) {
        playerSkipsTurn = b;
    }
    
    public boolean getSkipTurn() {
        return playerSkipsTurn;
    }
    
    public boolean getSaysUno() {
        return playerSaysUno;
    }
    
    public void changeSaysUno(boolean b) {
        playerSaysUno = b;
    }
    
    public Card getLastDiscarded() {
        return lastDiscarded();
    }
    
    public void setLastDiscarded(Card c) {
        lastDiscarded = c;
    }
    
    public boolean getPlayerWon() {
        return playerWon;
    }
    
    public void setPlayerWon(boolean b) {
        playerWon = b;
    }
}
