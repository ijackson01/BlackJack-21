package BlackJack.ui;

import BlackJack.controller.GameController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainSceneOld {
    private Stage stage;
    private GameController controller;
    private Label playerLabel;
    private Label dealerLabel;
    private Label resultLabel;

    public MainSceneOld(Stage stage) {
        this.stage = stage;
        controller = new GameController();
    }

    public Scene createScene() {
        playerLabel = new Label();
        dealerLabel = new Label();
        resultLabel = new Label();

        Button hitButton = new Button("Hit");
        Button stayButton = new Button("Stay");

        hitButton.setOnAction(e -> handleHit());
        stayButton.setOnAction(e -> handleStay());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(playerLabel, dealerLabel, resultLabel, hitButton, stayButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: white; -fx-padding: 50; -fx-font-size: 16px;");

        updateLabels();

        return new Scene(layout, 800, 600);
    }

    private void handleHit() {
        controller.playerHit();
        updateLabels();
        if (controller.isPlayerBusted()) {
            resultLabel.setText("You went over 21. Dealer wins this round.");
        }
    }

    private void handleStay() {
        controller.playerStay();
        updateLabels();
        String result = controller.checkWinner();
        resultLabel.setText(result);
    }

    private void updateLabels() {
        playerLabel.setText("Player: " + controller.getPlayerHand());
        dealerLabel.setText("Dealer: " + controller.getDealerVisibleHand());
    }
}
