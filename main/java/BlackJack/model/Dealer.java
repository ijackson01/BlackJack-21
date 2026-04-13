package BlackJack.model;

import java.util.List;

public class Dealer extends Player {
    public Dealer() {
        super("Dealer");
    }

    public List<Card> getVisibleCards() {
        if (hand.isEmpty()) {
            return hand;
        }
        return hand.subList(0, 1);
    }

    public int getVisibleValue() {
        if (hand.isEmpty()) {
            return 0;
        }
        return hand.get(0).getValue();
    }
}
