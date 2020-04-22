import java.util.*;

public class Gameplay
{
   private Player[] players;
   private int[] playerScores;
   private Stack<Card> drawPile;
   private ArrayList<Card> discardPile;

   public Gameplay(int numPlayers) {
       drawPile = new Stack<Card>();
       createDrawPile();
       drawPile = shuffleDrawPile();
       discardPile = new ArrayList<Card>();
       discardPile.add(dealCard());
       players = new Player[numPlayers];
       playerScores = new int[numPlayers];
       players[0] = new Human();
       players[0].changeTurn(true);

       for(int i = 1; i < numPlayers; ++i) {
           players[i] = new Computer();
           playerScores[i] = 0;
       }
       
      dealFirstHands();
      
   }

   public void createDrawPile() {
       String color;

       for(int i = 0; i < 4; ++ i) {
           if(i == 0) {
               color = "r";
           } else if(i == 1) {
               color = "o";
           } else if(i == 2) {
               color = "g";
           } else {
               color = "b";
           }

           drawPile.add(new Card("rev" + color, 5, 5));
           drawPile.add(new Card("skip" + color, 5, 5));
           drawPile.add(new Card("p2" + color, 5, 5));
           drawPile.add(new Card("rev" + color + "2", 5, 5));
           drawPile.add(new Card("skip" + color + "2", 5, 5));
           drawPile.add(newCard("p2" + color + "2", 5, 5));

           for(int j = 0; j < 10; ++j) {
               drawPile.add(new Card(j + color, 5, 5));

               if(j != 0) {
                   drawPile.add(new Card(j + color + "2", 5, 5));
               }
           }
       }

       for(int i = 1; i < 5; ++i) {
           drawPile.add(new Card("wild" + i, 5, 5));
           drawPile.add(new Card("p4" + i, 5, 5));
       }
   }

   public Stack<Card> shuffleDrawPile() {
       Random rand = new Random();
       Stack<Card> newDrawPile = new Stack<Card>();

       while(!drawPile.empty()) {
           int index = rand.nextInt(drawPile.size());
           newDrawPile.add(drawPile[index]);
           drawPile.remove(index);
       }

       return newDrawPile;
   }

   public void dealFirstHands() {
       for(int i = 0; i < players.length; ++i) {
          for(int j = 0; j < 7; ++j) {
              players[i].addCardToHand(dealCard());
          }
       }

       discardPile.add(dealCard());
   }

   public boolean isDrawPileEmpty() {
       return drawPile.empty();
   }

   public Card dealCard() {
       return drawPile.pop();
   }

   public void addToDiscardPile(Card c) {
       discardPile.add(c);
   }

   public Card getTopOfDiscardPile() {
       return discardPile[discardPile.size() - 1];
   }

   public Player conductTurn(Player p) {
       if(p instanceof Computer) {
           while(!p.makeMove(getTopOfDiscardPile) && !isDrawPileEmpty()){
               p.addCardToHand(dealCard());
           }

       } else {
           // card events for human
       }

       if(p.getLastDiscarded() != null) {
           discardPile.add(p.getLastDiscarded());
           p.setLastDiscarded(null);
       }

       if(p.getSaysUno) {
           for(int i = 0; i < players.length; ++i) {
               playerScores[i] += players[p].sumHand();
               
               if(playerScores[i] >= 500) {
                   return players[i];
               }
             if(i == 0) {
                 players[i] = new Human();
             } else {
                 players[i] = new Computer();     
             }
              
             drawPile = new Stack<Card>();
             createDrawPile();
             drawPile = shuffleDrawPile();
             discardPile = new ArrayList<Card>();
             discardPile.add(dealCard());
             dealFirstHands();
           }
       }
   }
}
