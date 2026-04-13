package BlackJack.controller;

import BlackJack.logic.BlackJackGame;
import BlackJack.model.Card;
import java.util.List;

public class GameController {

    private BlackJackGame game;
    private int gamesPlayed = 0;
    private int playerScore = 0;
    private int dealerScore = 0;
    private boolean playerTurn = true;
    private long startTimeMillis;

    public GameController() {
        game = new BlackJackGame();
        startTimeMillis = System.currentTimeMillis();
    }

    public void playerHit() {
        game.getPlayer().addCard(game.getDeck().drawCard());
        playerTurn = true;
    }

    public void playerStay() {
        playerTurn = false;
        game.dealerTurn();
    }

    public boolean isPlayerBusted() {
        return game.getPlayer().getHandValue() > 21;
    }

    public String getPlayerHand() {
        return handToString(game.getPlayer().getHand()) + " (" + game.getPlayer().getHandValue() + ")";
    }

    public String getDealerVisibleHand() {
        List<Card> cards = game.getDealer().getHand();
        if (cards.isEmpty()) {
            return "[Hidden]";
        }
        Card first = cards.get(0);
        if (cards.size() > 1) {
            return first.toString() + ", [Hidden]";
        }
        return first.toString();
    }



    public String getDealerFullHand() {
        return handToString(game.getDealer().getHand()) + " (" + game.getDealer().getHandValue() + ")";
    }


    public String checkWinner() {
        String result = game.checkWinner();
        if (result != null) {
            String lower = result.toLowerCase();
            gamesPlayed++;
            if (lower.contains("player wins")) {
                playerScore++;
            } else if (lower.contains("dealer wins")) {
                dealerScore++;
            }
        }
        //playerTurn = true;
        return result;
    }

    private String handToString(List<Card> cards) {
        StringBuilder result = new StringBuilder();
        for (Card card : cards) {
            result.append(card.toString()).append(", ");
        }
        return result.toString();
    }

    public void restartClock() {
        startTimeMillis = System.currentTimeMillis();
    }

    public void updateTime() {
    }

    public void resetRound() {
        game = new BlackJackGame();
        playerTurn = true;

    }

    public BlackJack.model.Player getPlayer() {
        return game.getPlayer();
    }

    public BlackJack.model.Dealer getDealer() {
        return game.getDealer();
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getDealerScore() {
        return dealerScore;
    }

    public boolean isPlayerTurn() {

        return playerTurn;
    }

    public boolean isDealerTurn() {
        return !playerTurn;
    }

    public void setPlayerTurn(boolean turn) {
        this.playerTurn = turn;
    }



    public String getElapsedTime() {
        long elapsedMillis = System.currentTimeMillis() - startTimeMillis;
        long seconds = elapsedMillis / 1000;
        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}
