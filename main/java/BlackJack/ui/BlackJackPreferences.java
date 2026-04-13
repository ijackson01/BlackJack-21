package BlackJack.ui;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import BlackJack.logic.BlackJackConstants;

public class BlackJackPreferences {

    private Stage window;
    private Scene scene;

    private HBox totalDecksHbox;
    private HBox deckColourHbox;
    private HBox gameThemeHbox;
    private HBox userNameHbox;
    private HBox buttonsHbox;

    private ComboBox<String> totalDecksComboBox;
    private ComboBox<String> deckColourComboBox;
    private ComboBox<String> gameThemeComboBox;
    private TextField userNameTextField;

    private BlackJackConstants constants;

    public BlackJackPreferences() {
        constants = new BlackJackConstants();
        buildUI();
    }

    private void buildUI() {

        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(constants.SPADE + " Preferences " + constants.CLUB);
        window.setResizable(false);

        // --- UI elements ---
        Label decksLabel = new Label(constants.SPADE + "Decks:");
        Label colourLabel = new Label(constants.HEART + "Deck Colour:");
        Label themeLabel = new Label(constants.DIAMOND + "Game Theme:");
        Label userLabel = new Label(constants.CLUB + "Player Name:");

        decksLabel.setTextFill(Color.WHITE);
        colourLabel.setTextFill(Color.WHITE);
        themeLabel.setTextFill(Color.WHITE);
        userLabel.setTextFill(Color.WHITE);

        totalDecksComboBox = new ComboBox<>();
        totalDecksComboBox.setItems(FXCollections.observableArrayList(
                "1 - 52 cards",
                "2 - 104 cards"
        ));
        totalDecksComboBox.setValue("1 - 52 cards");

        deckColourComboBox = new ComboBox<>();
        deckColourComboBox.setItems(FXCollections.observableArrayList("Red", "Blue"));
        deckColourComboBox.setValue("Red");

        gameThemeComboBox = new ComboBox<>();
        gameThemeComboBox.setItems(FXCollections.observableArrayList("Green", "Black"));
        gameThemeComboBox.setValue("Green");

        userNameTextField = new TextField("Player");

        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");

        okButton.setOnAction(e -> window.close());
        cancelButton.setOnAction(e -> window.close());

        totalDecksHbox = new HBox(20, decksLabel, totalDecksComboBox);
        deckColourHbox = new HBox(20, colourLabel, deckColourComboBox);
        gameThemeHbox = new HBox(20, themeLabel, gameThemeComboBox);
        userNameHbox = new HBox(20, userLabel, userNameTextField);
        buttonsHbox = new HBox(10, okButton, cancelButton);

        totalDecksHbox.setAlignment(Pos.CENTER_LEFT);
        deckColourHbox.setAlignment(Pos.CENTER_LEFT);
        gameThemeHbox.setAlignment(Pos.CENTER_LEFT);
        userNameHbox.setAlignment(Pos.CENTER_LEFT);
        buttonsHbox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(15,
                totalDecksHbox,
                deckColourHbox,
                gameThemeHbox,
                userNameHbox,
                buttonsHbox
        );

        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #222; -fx-border-color: gold; -fx-border-width: 3px;");

        scene = new Scene(layout, 350, 260);
        window.setScene(scene);
    }

    public void show() {
        window.showAndWait();
    }
}
