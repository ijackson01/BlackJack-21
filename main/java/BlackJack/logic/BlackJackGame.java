package BlackJack.logic;

import BlackJack.model.*;

public class BlackJackGame {
    private Deck deck;
    private Player player;
    private Dealer dealer;

    public BlackJackGame() {
        deck = new Deck();
        player = new Player("Player");
        dealer = new Dealer();
        startGame();
    }

    public void startGame() {
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        System.out.println("The game has started. Good luck!");
    }

    public void dealerTurn() {
        while (dealer.getHandValue() < 17 + (int)(Math.random() * 3)) {
            dealer.addCard(deck.drawCard());
        }
        System.out.println("The dealer has completed the turn.");
    }

    public String checkWinner() {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        if (playerValue > 21) {
            System.out.println("You went over 21. Dealer wins this round!");
            return "Player busts! Dealer wins!";
        }
        if (dealerValue > 21) {
            System.out.println("Dealer went over 21. You win this round!");
            return "Dealer busts! Player wins!";
        }
        if (playerValue > dealerValue && playerValue <= 21) {
            System.out.println("Congratulations! You win this round!");
            return "Player wins!";
        }
        if (dealerValue > playerValue && dealerValue <= 21) {
            System.out.println("Dealer wins this round. Better luck next time!");
            return "Dealer wins!";
        }

        System.out.println("It is a tie. Well played!");
        return "It's a tie!";
    }

    public Deck getDeck() {
        return deck;
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }
}
