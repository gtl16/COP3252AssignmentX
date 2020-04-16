// in progress
public class Computer extends Player {
    public Computer() {
    }

    public Card makeMove(Card c) {
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
               || (xType.startsWith("9") && cType.startsWith("9"))) {
                  hand.remove(x);
                  return x;
            }
        }
    }
}
