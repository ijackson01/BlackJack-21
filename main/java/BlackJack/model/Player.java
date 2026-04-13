package BlackJack.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    protected String name;
    protected List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Card>();
        System.out.println("Player " + name + " has joined the game.");
    }

    public void addCard(Card card) {
        hand.add(card);
        System.out.println(name + " received a card: " + card.toString());
    }

    public int getHandValue() {
        int total = 0;
        int aceCount = 0;
        for (Card c : hand) {
            total += c.getValue();
            if (c.getRank().equals("A")) {
                aceCount++;
            }
        }
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }
        return total;
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}
