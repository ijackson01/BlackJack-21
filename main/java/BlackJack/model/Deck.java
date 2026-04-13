package BlackJack.model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
                "2","3","4","5","6","7","8","9","10",
                "jack","queen","king","ace"
        };


        for (String suit : suits) {
            for (String rank : ranks) {
                int value;
                if (rank.equals("jack") || rank.equals("queen") || rank.equals("king")) {
                    value = 10;
                } else if (rank.equals("ace")) {
                    value = 11;
                } else {
                    value = Integer.parseInt(rank);
                }
                cards.add(new Card(suit, rank, value));
            }
        }
        Collections.shuffle(cards);
        System.out.println("The deck has been created and shuffled.");
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("No more cards left in the deck.");
            return null;
        }
        return cards.remove(0);
    }
}
