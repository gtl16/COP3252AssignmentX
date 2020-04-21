public class Computer extends Player {
    public Computer() {
    }
    
    public boolean makeMove(Card c) {
        for(Card x : hand) {
            String xType = x.getValue();
            String cType = c.getValue();
            
            if((xType.startsWith("1") && cType.startsWith("1"))
               || (xType.startsWith("2") && cType.startsWith("2"))
               || (xType.startsWith("3") && cType.startsWith("3"))
               || (xType.startsWith("4") && cType.startsWith("4"))
               || (xType.startsWith("5") && cType.startsWith("5"))
               || (xType.startsWith("6") && cType.startsWith("6"))
               || (xType.startsWith("7") && cType.startsWith("7"))
               || (xType.startsWith("8") && cType.startsWith("8"))
               || (xType.startsWith("9") && cType.startsWith("9"))
               || (xType.startsWith("skip") && cType.startsWith("skip"))
               || (xType.startsWith("rev") && cType.startsWith("rev"))
               || (xType.startsWith("p2") && cType.startsWith("p2"))
               || (xType.startsWith("wild"))) {
                  lastDiscarded = x;
                  hand.remove(x);
                  
                  if(getHandSize() == 0) {
                      changeSaysUno(true);
                  }
                        
                  return true;
            } 
            
            return false;
        }
    }
}
