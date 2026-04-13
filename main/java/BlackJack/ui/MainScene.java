package BlackJack.ui;

import BlackJack.controller.GameController;
import BlackJack.logic.BlackJackConstants;
import BlackJack.model.Card;
import BlackJack.ui.CardView;
import BlackJack.ui.GameSceneHolder;
import BlackJack.sound.SoundManager;


import javafx.scene.effect.Reflection;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Light;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.TextAlignment;

import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.animation.ScaleTransition;
import javafx.util.Duration;
import javafx.animation.Timeline;

import javafx.animation.KeyFrame;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;

public class MainScene {

    private BlackJackConstants blackJackConstants = new BlackJackConstants();

    private Label dealerSpadeLabel = new Label(blackJackConstants.SPADE);
    private Label dealerClubLabel = new Label(blackJackConstants.CLUB);
    private Label dealerHeartLabel = new Label(blackJackConstants.HEART);
    private Label dealerDiamondLabel = new Label(blackJackConstants.DIAMOND);

    private Label playerSpadeLabel = new Label(blackJackConstants.SPADE);
    private Label playerClubLabel = new Label(blackJackConstants.CLUB);
    private Label playerHeartLabel = new Label(blackJackConstants.HEART);
    private Label playerDiamondLabel = new Label(blackJackConstants.DIAMOND);


    private Label playerNameLabel = new Label(" Player ");
    private Label dealerNameLabel = new Label(" Dealer ");

    private Label spadeScoresLabel = new Label(blackJackConstants.SPADE);
    private Label heartDealerPlayerLabel = new Label(blackJackConstants.HEART);
    private Label diamondNextMoveLabel = new Label(blackJackConstants.DIAMOND);
    private Label spadeClubHeartTimePlayedLabel = new Label(blackJackConstants.SPADE +
            blackJackConstants.CLUB + blackJackConstants.HEART);

    private Stage stage;
    private GameController controller;

    private SoundManager soundManager;

    private Timeline timer;

    private Label playerLabel;
    private Label dealerLabel;
    private Label resultLabel;

    private HBox dealerLabelHbox;
    private HBox playerLabelHbox;


    // Scoreboard labels
    private Label gamesPlayedLabel;
    private Label totalGamesPlayedLabel;
    private Label scoreTitleLabel;
    private Label scoresLabel;
    private Label nextMoveLabel;
    private Label timePlayedLabel;
    private Label dealerScoresLabel;
    private Label playerScoresLabel;
    private Label nextMoveNameLabel;
    private Label actualTimePlayedLabel;


    private VBox movingBlackjackVbox;


    // Layout Labels
    private Label deckLabel;
    private Label dealerHand1Label;
    private Label dealerHand2Label;
    private Label playerHand1Label;
    private Label playerHand2Label;

    // Menu and statusbar
    private BlackJackGameMenu blackJackGameMenu;
    private TextField statusBar;


    // Button Setup
    private Button hitButton;
    private Button stayButton;
    private Button splitButton;
    private Button foldButton;
    private Button doubleDownButton;

    // Container for game view
    private VBox layout;
    private VBox vbox1;
    private VBox vbox2;
    private VBox vbox3;
    private VBox vbox4;
    private VBox vbox5;
    private VBox vbox6;
    private HBox hboxContainerForVBoxes;

    // Image for dealers deck
    private Image dealersDeckImage;
    private ImageView dealersDeckImageView;

    // Hand 1a Dealer and Player
    private Image cardPositionImage2;
    private ImageView cardPositionImageView2;

    // Hand 1b Dealer and Player
    private Image cardPositionImage3;
    private ImageView cardPositionImageView3;

    // Hand 2a Dealer and Player
    private Image cardPositionImage4;
    private ImageView cardPositionImageView4;

    // Hand 2b Dealer and Player
    private Image cardPositionImage5;
    private ImageView cardPositionImageView5;

    // Stack pane for logo and vboxes
    private StackPane stackpane;


    // Stack panes 2 to 5 for card images and vboxes 2 to 5
    private StackPane sPane2;
    private StackPane sPane3;
    private StackPane sPane4;
    private StackPane sPane5;

    TextFlow blackjackTextFlow;

    Text blackjackLetterSlash;
    Text blackjackLetterCarot;
    Text blackjackLetterB;
    Text blackjackLetterL;
    Text blackjackLetterA;
    Text blackjackLetterC;
    Text blackjackLetterK;
    Text blackjackLetterJ;
    Text blackjackLetter2ndA;
    Text blackjackLetter2ndC;
    Text blackjackLetter2ndK;
    Text blackjackLetterDollar;
    Text blackjackLetter2ndSlash;


    Label movingBlackjackLabel;

    public MainScene(Stage stage, SoundManager sound) {
        this.stage = stage;
        controller = new GameController();
        this.soundManager = sound;
    }

    public Scene createScene() {

        GameSceneHolder.mainScene = this;

        playerLabel = new Label();
        dealerLabel = new Label();
        resultLabel = new Label();

        playerLabelHbox = new HBox();
        dealerLabelHbox = new HBox();


        statusBar = new TextField();

        // Dealer hand 1 & 2 labels
        dealerHand1Label = new Label(blackJackConstants.DIAMOND + "Hand" +
                blackJackConstants.ROMAN_NUMERAL_ONE +
                blackJackConstants.HEART.stripTrailing());
        dealerHand2Label = new Label(blackJackConstants.SPADE + "Hand" +
                blackJackConstants.ROMAN_NUMERAL_TWO +
                blackJackConstants.CLUB.stripTrailing());

        // Game deck label
        deckLabel = new Label(blackJackConstants.SPADE.stripLeading() + "Deck: ()");

        // Player hand 1 & 2 labels
        playerHand1Label = new Label(blackJackConstants.HEART + "Hand" +
                blackJackConstants.ROMAN_NUMERAL_ONE +
                blackJackConstants.SPADE.stripTrailing());
        playerHand2Label = new Label(blackJackConstants.CLUB + "Hand" +
                blackJackConstants.ROMAN_NUMERAL_TWO +
                blackJackConstants.DIAMOND.stripTrailing());

        // Scoreboard labels
        gamesPlayedLabel = new Label(blackJackConstants.DIAMOND + "Games Played" + blackJackConstants.HEART);
        totalGamesPlayedLabel = new Label("22,990\n");
        scoreTitleLabel = new Label(blackJackConstants.CLUB + "Scores" + blackJackConstants.SPADE);
        dealerScoresLabel = new Label("Dealer: 11,000");
        playerScoresLabel = new Label("Player: 11,990\n");
        nextMoveLabel = new Label(blackJackConstants.SPADE + "Next Move" + blackJackConstants.CLUB);
        nextMoveNameLabel = new Label("<Name>\n");
        timePlayedLabel = new Label(blackJackConstants.HEART + "Time Played" + blackJackConstants.DIAMOND);
        actualTimePlayedLabel = new Label("<hh:mm:ss>");
        movingBlackjackVbox = new VBox();



        // Button Setup
        hitButton = new Button(blackJackConstants.SPADE + "Hit  ");
        stayButton = new Button(blackJackConstants.DIAMOND + "Stay ");
        splitButton = new Button(blackJackConstants.SPADE + "Split");
        foldButton = new Button(blackJackConstants.DIAMOND + "Fold ");
        doubleDownButton = new Button(blackJackConstants.CLUB + "Double");


        setGamesPlayedLabelProperties();
        setScoreTitleLabelProperties();

        setActualTimePlayedLabelProperties();
        setNextMoveNameLabelProperties();
        setPlayerScoresLabelProperties();
        setDealerScoresLabelProperties();
        setTotalGamesPlayedLabelProperties();

        setNextMoveLabelProperties();
        setTimePlayedLabelProperties();

        // Disable advance buttons

        splitButton.setDisable(true);
        foldButton.setDisable(true);
        doubleDownButton.setDisable(true);



        // Layout objects for main view
        layout = new VBox();
        hboxContainerForVBoxes = new HBox();
        vbox1 = new VBox();
        vbox2 = new VBox();
        vbox3 = new VBox();
        vbox4 = new VBox();
        vbox5 = new VBox();
        vbox6 = new VBox();


        // Orlando - sPanes
        sPane2 = new StackPane();
        sPane3 = new StackPane();
        sPane4 = new StackPane();
        sPane5 = new StackPane();

        // Add vboxes to corresponding stackpane for card overlay
        addToSPane2();
        addToSPane3();
        addToSPane4();
        addToSPane5();


        stackpane = new StackPane();


        blackjackTextFlow = new TextFlow();

        blackjackLetterSlash = new Text("/ ");
        blackjackLetterCarot = new Text("^ ");
        blackjackLetterB = new Text("B ");
        blackjackLetterL = new Text("l ");
        blackjackLetterA = new Text("a ");
        blackjackLetterC = new Text("c ");
        blackjackLetterK = new Text("k ");
        blackjackLetterJ = new Text("J ");
        blackjackLetter2ndA = new Text("a ");
        blackjackLetter2ndC = new Text("c ");
        blackjackLetter2ndK = new Text("k ");
        blackjackLetterDollar = new Text("$ ");
        blackjackLetter2ndSlash = new Text("/");


        addToBlackjackTextFlow();
        setBlackjackTextFlowProperties();

        addTohboxContainerForVBoxes();
        setHboxContainerForVBoxesProperties();

        addToStackpane();
        setStackpaneProperties();
        setBlackjackLetterSlashProperties();
        setBlackjackLetterCarotProperties();
        setBlackjackLetterBProperties();
        setBlackjackLetterLProperties();
        setBlackjackLetterAProperties();
        setBlackjackLetterCProperties();
        setBlackjackLetterKProperties();
        setBlackjackLetterJProperties();
        setBlackjackLetter2ndAProperties();
        setBlackjackLetter2ndCProperties();
        setBlackjackLetter2ndKProperties();
        setBlackjackLetterDollarProperties();
        setBlackjackLetter2ndSlashProperties();


        // Menubar
        blackJackGameMenu = new BlackJackGameMenu(this);
        blackJackGameMenu.createMenuBar();
        dealersDeckImage = new Image(getClass().getResource("/Cards/b2fv.png").toExternalForm());
        dealersDeckImageView = new ImageView(dealersDeckImage);

        cardPositionImage2 = new Image(getClass().getResource(
                BlackJackConstants.CARD_PLACEHOLDER_IMAGE).toExternalForm());
        cardPositionImageView2 = new ImageView(cardPositionImage2);

        cardPositionImage3 = new Image(getClass().getResource(
                BlackJackConstants.CARD_PLACEHOLDER_IMAGE).toExternalForm());
        cardPositionImageView3 = new ImageView(cardPositionImage3);

        cardPositionImage4 = new Image(getClass().getResource(
                BlackJackConstants.CARD_PLACEHOLDER_IMAGE).toExternalForm());
        cardPositionImageView4 = new ImageView(cardPositionImage4);

        cardPositionImage5 = new Image(getClass().getResource(
                BlackJackConstants.CARD_PLACEHOLDER_IMAGE).toExternalForm());
        cardPositionImageView5 = new ImageView(cardPositionImage5);




        // Set properties for above
        setResultLabelProperties();
        setStatusBarProperties();
        setHitButtonProperties();
        setStayButtonProperties();
        setSplitButtonProperties();
        setFoldButtonProperties();
        setDoubleDownButtonProperties();


        // vBox1 - Add deckLabel, dealer image, and player buttons
        addToVbox1();
        setDealersDeckImageViewProperties();
        setVbox1Properties();
        setDeckLabelProperties();


        // vBox2 - Hand #1a
        addToVbox2();
        setCardPositionImageView2Properties();
        setVbox2Properties();
        setDealerHand1LabelProperties();
        setPlayerHand1LabelProperties();



        // vBox3 - Hand #1b
        addToVbox3();
        setCardPositionImageView3();
        setVbox3Properties();

        // vBox4 - Hand #2a
        addToVbox4();
        setCardPositionImageView4Properties();
        setVbox4Properties();
        setDealerHand2LabelProperties();
        setPlayerHand2LabelProperties();

        // vBox5 - Hand #2b
        addToVbox5();
        setCardPositionImageView5Properties();
        setVbox5Properties();

        // vBox6 - Scores
        movingBlackjackLabel = new Label(blackJackConstants.MOVING_SCOREBOARD_TEXT);

        addToMovingBlackjackVbox();
        setMovingBlackjackVboxProperties();
        setMovingBlackjackLabelProperties();

        addToVBox6();
        setVbox6Properties();

        // Create a DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GREY); // Color of the shadow
        dropShadow.setRadius(2.0); // Blur radius of the shadow
        dropShadow.setOffsetX(2.9); // X-offset of the shadow
        dropShadow.setOffsetY(2.9); // Y-offset of the shadow

        blackjackTextFlow.setEffect(dropShadow);
        movingBlackjackLabel.setEffect(dropShadow);
        movingBlackjackVbox.setEffect(dropShadow);
        playerHand1Label.setEffect(dropShadow);
        playerHand2Label.setEffect(dropShadow);
        dealerHand1Label.setEffect(dropShadow);
        dealerHand2Label.setEffect(dropShadow);
        dealerLabel.setEffect(dropShadow);
        playerLabel.setEffect(dropShadow);

        logoAnimation();

        Reflection reflection = new Reflection();
        reflection.setFraction(1.0); // Sets the visible portion of the reflection
        reflection.setTopOpacity(0.1); // Sets the opacity at the top of the reflection
        reflection.setBottomOpacity(0.0); // Sets the opacity at the bottom of the reflection
        reflection.setTopOffset(1.0);
        blackjackTextFlow.setEffect(reflection);

        scoreboardAnimation();

        addToPlayerLabelHbox();
        setPlayerLabelHboxProperties();

        addToDealerLabelHbox();
        setDealerLabelHboxProperties();

        // HBox - Children Insets
        addToLayout();
        setLayoutProperties();
        setDealerLabelProperties();
        setPlayerLabelProperties();

        updateLabels();


        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);

        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);

        layout.setAlignment(Pos.TOP_CENTER);
        layout.setEffect(lighting);

        startNewGame();

        soundManager.playCustom("background.mp3");

        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            controller.updateTime();
            updateLabels();
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

        StackPane root = new StackPane(layout);
        root.setStyle("-fx-background-color: " + BlackJackConstants.BACKGROUND_COLOUR + ";");

        Scene scene = new Scene(root);

        layout.prefWidthProperty().bind(root.widthProperty());
        layout.prefHeightProperty().bind(root.heightProperty());

        return scene;


    }


    private void disableButtons() {
        hitButton.setDisable(true);
        stayButton.setDisable(true);
    }


    // Player presses "Stay"
    private void handleStay() {
        updateStatus("Player stays");
        soundManager.playStay();
        disableButtons();

        controller.playerStay();
        updateLabels();


        startDealerTurnSequence().play();
    }


    private SequentialTransition startDealerTurnSequence() {
        SequentialTransition sequence = new SequentialTransition();



        if (controller.getDealer().getHand().size() > 1) {

            PauseTransition revealDelay = new PauseTransition(Duration.seconds(0.5));

            revealDelay.setOnFinished(e -> {
                Card hiddenCard = controller.getDealer().getHand().get(1);
                updateStatus("Dealer reveals " + hiddenCard.toString());
                CardView revealed = new CardView(hiddenCard);
                revealed.setFitWidth(90);
                revealed.setPreserveRatio(true);

                for (int i = 0; i < sPane3.getChildren().size(); i++) {
                    if (sPane3.getChildren().get(i) instanceof ImageView) {
                        ImageView iv = (ImageView) sPane3.getChildren().get(i);
                        String url = iv.getImage().getUrl();
                        if (url != null && url.contains("b2fv.png")) {
                            sPane3.getChildren().remove(i);
                            break;
                        }
                    }
                }

                sPane3.getChildren().add(revealed);
                sPane3.setAlignment(revealed, Pos.TOP_CENTER);
                revealed.setTranslateY(30);

                updateLabels();
                soundManager.playDeal();
            });

            sequence.getChildren().add(revealDelay);
        }



        int initialCardIndex = 2;
        int finalCardCount = controller.getDealer().getHand().size();

        for (int i = initialCardIndex; i < finalCardCount; i++) {

            Card newCard = controller.getDealer().getHand().get(i);
            CardView dealerCard = new CardView(newCard);
            dealerCard.setFitWidth(90);
            dealerCard.setPreserveRatio(true);

            FadeTransition cardFadeIn = new FadeTransition(Duration.seconds(0.4), dealerCard);
            cardFadeIn.setFromValue(0);
            cardFadeIn.setToValue(1);

            PauseTransition waitBeforeNextCard = new PauseTransition(Duration.seconds(0.3));

            final int cardIndex = i;

            cardFadeIn.setOnFinished(e -> {
                StackPane targetPane;
                if ((cardIndex % 2) == 0) {
                    targetPane = sPane4;
                } else {
                    targetPane = sPane5;
                }

                targetPane.getChildren().add(dealerCard);
                updateStatus("Dealer draws " + newCard.toString());
                targetPane.setAlignment(dealerCard, Pos.TOP_CENTER);

                int verticalOffset = 30;
                if (cardIndex >= 3) {
                    verticalOffset = 30 + (((cardIndex - 2) / 2) * 35);
                }
                dealerCard.setTranslateY(verticalOffset);

                soundManager.playDeal();
                updateLabels();
            });

            sequence.getChildren().addAll(cardFadeIn, waitBeforeNextCard);
        }



        PauseTransition finalWait = new PauseTransition(Duration.seconds(1.0));
        finalWait.setOnFinished(e -> {
            String r = controller.checkWinner();
            resultLabel.setText(r);
            updateStatus(r);
            String s = r.toLowerCase();

            if (s.contains("player wins")) {
                soundManager.playWin();
            }
            else if (s.contains("dealer wins")) {
                soundManager.playLose();
            }
            else if (s.contains("bust")) {
                soundManager.playLose();
            }
            else if (s.contains("push")){
                soundManager.playTie();
            }
            else if (s.contains("tie")) {
                soundManager.playTie();
            }
        });


        sequence.getChildren().add(finalWait);
        return sequence;
    }


    private void handleHit() {
        soundManager.playHit();

        controller.playerHit();
        updateStatus("Player hits");
        Card lastCard = controller.getPlayer().getHand().get(controller.getPlayer().getHand().size() - 1);
        updateStatus("Player draws " + lastCard.toString());
        CardView cardView = new CardView(lastCard);
        cardView.setFitWidth(90);
        cardView.setPreserveRatio(true);

        int totalCards = controller.getPlayer().getHand().size() - 1;
        if ((totalCards % 2) == 0) {
            sPane3.getChildren().add(cardView);
            sPane3.setAlignment(cardView, Pos.BOTTOM_CENTER);
            if (totalCards >= 4) {
                cardView.setTranslateY(-30 - ((totalCards - 2) / 2) * 35);
            }
        } else {
            sPane2.getChildren().add(cardView);
            sPane2.setAlignment(cardView, Pos.BOTTOM_CENTER);
            cardView.setTranslateY(-30);
            if (totalCards >= 3) {
                cardView.setTranslateY(-30 - ((totalCards - 2) / 2) * 35);
            }
        }

        FadeTransition fade = new FadeTransition(Duration.seconds(0.4), cardView);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

        soundManager.playDeal();

        updateLabels();

        if (controller.isPlayerBusted()) {
            updateStatus("Player busts");
            String result = controller.checkWinner();
            resultLabel.setText(result);
            disableButtons();
            soundManager.playLose(); // Assuming bust is a loss
        }
    }


    public void startNewGame() {
        updateStatus("New game started");
        controller = new GameController();
        controller.restartClock();
        controller.setPlayerTurn(true);



        if (timer != null) {
            timer.stop();
        }

        timer = new javafx.animation.Timeline(
                new javafx.animation.KeyFrame(
                        javafx.util.Duration.seconds(1), e -> updateLabels())
        );
        timer.setCycleCount(javafx.animation.Animation.INDEFINITE);
        timer.play();

        // clear table for new hand
        sPane2.getChildren().clear();
        addToSPane2();
        sPane3.getChildren().clear();
        addToSPane3();
        sPane4.getChildren().clear();
        addToSPane4();
        sPane5.getChildren().clear();
        addToSPane5();

        soundManager.playShuffle();

        // Card 1 Player
        if (!controller.getPlayer().getHand().isEmpty()) {
            Card p = controller.getPlayer().getHand().get(0);
            CardView pv = new CardView(p);

            pv.setFitWidth(90);
            pv.setPreserveRatio(true);

            sPane2.getChildren().add(pv);
            sPane2.setAlignment(pv, Pos.BOTTOM_CENTER);
            pv.setTranslateY(-30);
            soundManager.playDeal();
        }

        // Card 1 Dealer
        if (!controller.getDealer().getHand().isEmpty()) {
            Card d = controller.getDealer().getHand().get(0);
            CardView dv = new CardView(d);

            dv.setFitWidth(90);
            dv.setPreserveRatio(true);

            sPane2.getChildren().add(dv);
            sPane2.setAlignment(dv, Pos.TOP_CENTER);
            dv.setTranslateY(30);
            soundManager.playDeal();
        }

        // Card 2 Player
        if (controller.getPlayer().getHand().size() > 1) {
            Card p2 = controller.getPlayer().getHand().get(1);
            CardView pv2 = new CardView(p2);
            pv2.setFitWidth(90);
            pv2.setPreserveRatio(true);
            sPane3.getChildren().add(pv2);
            sPane3.setAlignment(pv2, Pos.BOTTOM_CENTER);
            pv2.setTranslateY(-30);
            soundManager.playDeal();
        }

        // Card 2 Dealer (Face Down)
        if (controller.getDealer().getHand().size() > 1) {
            Image backImage = new Image(getClass().getResource("/Cards/b2fv.png").toExternalForm());
            ImageView backView = new ImageView(backImage);
            backView.setFitWidth(90);
            backView.setPreserveRatio(true);
            sPane3.getChildren().add(backView);
            sPane3.setAlignment(backView, Pos.TOP_CENTER);
            backView.setTranslateY(30);
            soundManager.playDeal();
        }


        updateLabels();
        resultLabel.setText("");
        hitButton.setDisable(false);
        stayButton.setDisable(false);
    }


    public void resetGame() {
        updateStatus("Round reset");
        controller.resetRound();
        controller.setPlayerTurn(true);


        sPane2.getChildren().clear();
        addToSPane2();
        sPane3.getChildren().clear();
        addToSPane3();
        sPane4.getChildren().clear();
        addToSPane4();
        sPane5.getChildren().clear();
        addToSPane5();

        soundManager.playShuffle();

        // Card 1 Player
        if (!controller.getPlayer().getHand().isEmpty()) {
            Card p = controller.getPlayer().getHand().get(0);
            CardView pv = new CardView(p);
            pv.setFitWidth(90);
            pv.setPreserveRatio(true);
            sPane2.getChildren().add(pv);
            sPane2.setAlignment(pv, Pos.BOTTOM_CENTER);
            pv.setTranslateY(-30);
            soundManager.playDeal();
        }

        // Card 1 Dealer
        if (!controller.getDealer().getHand().isEmpty()) {
            Card d = controller.getDealer().getHand().get(0);
            CardView dv = new CardView(d);
            dv.setFitWidth(90);
            dv.setPreserveRatio(true);
            sPane2.getChildren().add(dv);
            sPane2.setAlignment(dv, Pos.TOP_CENTER);
            dv.setTranslateY(30);
            soundManager.playDeal();
        }

        // Card 2 Player
        if (controller.getPlayer().getHand().size() > 1) {
            Card p2 = controller.getPlayer().getHand().get(1);
            CardView pv2 = new CardView(p2);
            pv2.setFitWidth(90);
            pv2.setPreserveRatio(true);
            sPane3.getChildren().add(pv2);
            sPane3.setAlignment(pv2, Pos.BOTTOM_CENTER);
            pv2.setTranslateY(-30);
            soundManager.playDeal();
        }

        // Card 2 Dealer (Face Down)
        if (controller.getDealer().getHand().size() > 1) {
            Image backImage = new Image(getClass().getResource("/Cards/b2fv.png").toExternalForm());
            ImageView backView = new ImageView(backImage);
            backView.setFitWidth(90);
            backView.setPreserveRatio(true);
            sPane3.getChildren().add(backView);
            sPane3.setAlignment(backView, Pos.TOP_CENTER);
            backView.setTranslateY(30);
            soundManager.playDeal();
        }


        resultLabel.setText("");
        hitButton.setDisable(false);
        stayButton.setDisable(false);
        updateLabels();
    }


    // Isaac
    private void updateLabels() {
        String playerText = "Player: " + controller.getPlayerHand();
        playerLabel.setText(playerText);

        String dealerText;

        if (controller.isDealerTurn()) {
            dealerText = controller.getDealerFullHand();
        } else {
            dealerText = controller.getDealerVisibleHand();
        }

        dealerLabel.setText("Dealer: " + dealerText);



        String games = Integer.toString(controller.getGamesPlayed());
        totalGamesPlayedLabel.setText(games);

        String dealerScoreText = "Dealer: " + controller.getDealerScore();
        dealerScoresLabel.setText(dealerScoreText);

        String playerScoreText = "Player: " + controller.getPlayerScore();
        playerScoresLabel.setText(playerScoreText);

        if (controller.isPlayerTurn()) {
            nextMoveNameLabel.setText("Player\n");
        } else {
            nextMoveNameLabel.setText("Dealer\n");
        }

        String timeText = "Time Played: " + controller.getElapsedTime();
        actualTimePlayedLabel.setText(timeText);
    }



    private void logoAnimation() {

        // Forward Animation
        // Transition 1
        FadeTransition forwardFadeIn = new FadeTransition(Duration.millis(8000));
        forwardFadeIn.setNode(blackjackTextFlow);
        forwardFadeIn.setFromValue(0.0);
        forwardFadeIn.setToValue(1.0);

        // Transition 2
        PauseTransition forwardPt1 = new PauseTransition(Duration.seconds(0.2));

        // Transition 3
        PauseTransition forwardPt2 = new PauseTransition(Duration.seconds(5));

        // Transition 4
        FadeTransition forwardFadeOut = new FadeTransition(Duration.millis(8000));
        forwardFadeOut.setNode(blackjackTextFlow);
        forwardFadeOut.setFromValue(1.0);
        forwardFadeOut.setToValue(0.0);

        // Sequence events
        SequentialTransition logoForwardSeqT = new SequentialTransition(
                forwardPt1, forwardFadeIn, forwardPt2, forwardFadeOut);



        // Backwards Animation
        // Transition 1
        FadeTransition backwardsFadeIn = new FadeTransition(Duration.millis(8000));
        backwardsFadeIn.setNode(blackjackTextFlow);
        backwardsFadeIn.setFromValue(0.0);
        backwardsFadeIn.setToValue(1.0);

        // Transition 2
        PauseTransition backwardsPt1 = new PauseTransition(Duration.seconds(0.2));

        // Transition 3
        PauseTransition backwardsPt2 = new PauseTransition(Duration.seconds(5));

        // Transition 4
        FadeTransition backwardsFadeOut = new FadeTransition(Duration.millis(8000));
        backwardsFadeOut.setNode(blackjackTextFlow);
        backwardsFadeOut.setFromValue(1.0);
        backwardsFadeOut.setToValue(0.0);

        // Sequence events
        SequentialTransition logoBackwardsSeqT = new SequentialTransition(
                backwardsPt1,backwardsFadeIn,backwardsPt2,backwardsFadeOut);

        // After backwards movement move to forward animation
        logoBackwardsSeqT.setOnFinished(event -> {
            logoForwardSeqT.playFromStart();
        });

        // After forwards movement move to backwards animation
        logoForwardSeqT.setOnFinished(event -> {
            logoBackwardsSeqT.play();
        });

        logoForwardSeqT.play();
    }


    // Orlando
    private void scoreboardAnimation() {

        // Forward Animation
        // Transition 1
        FadeTransition forwardFadeIn = new FadeTransition(Duration.millis(5000));
        forwardFadeIn.setNode(movingBlackjackLabel);
        forwardFadeIn.setFromValue(0.0);
        forwardFadeIn.setToValue(1.0);

        // Transition 2
        TranslateTransition forwardTt = new TranslateTransition(Duration.seconds(8), movingBlackjackLabel);
        forwardTt.setByX(50);

        // Transition 3
        PauseTransition forwardPt1 = new PauseTransition(Duration.seconds(1.5));

        // Transition 4
        PauseTransition forwardPt2 = new PauseTransition(Duration.seconds(1.5));

        // Transition 5
        FadeTransition forwardFadeOut = new FadeTransition(Duration.millis(4000));
        forwardFadeOut.setNode(movingBlackjackLabel);
        forwardFadeOut.setFromValue(1.0);
        forwardFadeOut.setToValue(0.0);

        // Sequence events
        SequentialTransition forwardSeqT = new SequentialTransition(forwardFadeIn, forwardPt1,
                forwardTt, forwardPt2, forwardFadeOut);

        // Backwards Animation
        // Transition 1
        FadeTransition backwardsFadeIn = new FadeTransition(Duration.millis(5000));
        backwardsFadeIn.setNode(movingBlackjackLabel);
        backwardsFadeIn.setFromValue(0.0);
        backwardsFadeIn.setToValue(1.0);

        // Transition 2
        TranslateTransition backwardsTt = new TranslateTransition(Duration.seconds(8), movingBlackjackLabel);
        backwardsTt.setByX(-50);

        // Transition 3
        PauseTransition backwardsPt1 = new PauseTransition(Duration.seconds(1.5));

        // Transition 4
        PauseTransition backwardsPt2 = new PauseTransition(Duration.seconds(1.5));

        // Transition 5
        FadeTransition backwardsFadeOut = new FadeTransition(Duration.millis(4000));
        backwardsFadeOut.setNode(movingBlackjackLabel);
        backwardsFadeOut.setFromValue(1.0);
        backwardsFadeOut.setToValue(0.0);

        // Sequence events
        SequentialTransition backwardsSeqT = new SequentialTransition(backwardsFadeIn, backwardsPt1,
                backwardsTt, backwardsPt2, backwardsFadeOut);

        // After backwards movement move to forward animation
        backwardsSeqT.setOnFinished(event -> {
            forwardSeqT.playFromStart();
        });

        // After forwards movement move to backwards animation
        forwardSeqT.setOnFinished(event -> {
            backwardsSeqT.play();
        });

        forwardSeqT.play();
    }

    // setMovingBlackjackLabel
    private void setMovingBlackjackLabelProperties() {
        movingBlackjackLabel.setFont(Font.font("Arial"));
        movingBlackjackLabel.setTextFill(Color.WHITE);
        movingBlackjackLabel.setStyle("-fx-border-width: 1; -fx-border-color: GOLD;"+
                " -fx-font-color: white; -fx-background-color:black;"+
                "-fx-font-weight:bold; -fx-font-size:13px;");

        movingBlackjackLabel.setOnMouseEntered(e -> {
            movingBlackjackLabel.setStyle("-fx-border-width: 1; -fx-border-color: GOLD;"+
                    " -fx-font-color: grey; -fx-background-color:black;"+
                    "-fx-font-weight:bold; -fx-font-size:13px;");
        });

        movingBlackjackLabel.setOnMouseExited(e -> {
            movingBlackjackLabel.setStyle("-fx-border-width: 1; -fx-border-color: GOLD;"+
                    " -fx-font-color: white; -fx-background-color:black;"+
                    "-fx-font-weight:bold; -fx-font-size:13px;");
        });
    }
// end of transitions


    private void setHitButtonProperties() {
        hitButton.setStyle("-fx-background-color: grey; -fx-padding: 5;" +
                "-fx-font-size: 16px; -fx-font-color: black;" +
                "-fx-border-color: black; -fx-border-width: 2;" +
                "-fx-border-radius: 5;");
        hitButton.setMinWidth(80);
        hitButton.setPrefWidth(80);
        hitButton.setMaxWidth(80);
        hitButton.setMinHeight(40);
        hitButton.setPrefHeight(40);
        hitButton.setMaxHeight(40);
        hitButton.setOnAction(e -> {
            soundManager.playButton();
            handleHit();
        });
        hitButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                hitButton.setStyle("-fx-background-color: lightgrey; -fx-padding: 0;" +
                        "-fx-font-size: 16px; -fx-font-color: black;" +
                        "-fx-border-color: gold; -fx-border-width: 2;" +
                        "-fx-border-radius: 5;");
            } else {
                hitButton.setStyle("-fx-background-color: grey; -fx-padding: 0; " +
                        "-fx-font-size: 16px; -fx-font-color: black; " +
                        "-fx-border-color: black; -fx-border-width: 2; " +
                        " -fx-border-radius: 5;");
            }
        });
    };

    private void setStayButtonProperties() {
        stayButton.setStyle("-fx-background-color: grey; -fx-padding: 5;" +
                "-fx-font-size: 16px; -fx-font-color: black;" +
                "-fx-border-color: black; -fx-border-width: 2;" +
                "-fx-border-radius: 5;");
        stayButton.setMinWidth(80);
        stayButton.setPrefWidth(80);
        stayButton.setMaxWidth(80);
        stayButton.setMinHeight(40);
        stayButton.setPrefHeight(40);
        stayButton.setMaxHeight(40);
        stayButton.setOnAction(e -> {
            soundManager.playButton();
            handleStay();
        });
        stayButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                stayButton.setStyle("-fx-background-color: lightgrey; -fx-padding: 0;" +
                        "-fx-font-size: 16px; -fx-font-color: black;" +
                        "-fx-border-color: gold; -fx-border-width: 2;" +
                        "-fx-border-radius: 5;");
            } else {
                stayButton.setStyle("-fx-background-color: grey; -fx-padding: 0; " +
                        "-fx-font-size: 16px; -fx-font-color: black; " +
                        "-fx-border-color: black; -fx-border-width: 2; " +
                        " -fx-border-radius: 5;");
            }
        });
    }

    private void setSplitButtonProperties() {
        splitButton.setStyle("-fx-background-color: grey; -fx-padding: 5;" +
                "-fx-font-size: 16px; -fx-font-color: black;" +
                "-fx-border-color: black; -fx-border-width: 2;" +
                "-fx-border-radius: 5;");
        splitButton.setMinWidth(80);
        splitButton.setPrefWidth(80);
        splitButton.setMaxWidth(80);
        splitButton.setMinHeight(40);
        splitButton.setPrefHeight(40);
        splitButton.setMaxHeight(40);
        splitButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                splitButton.setStyle("-fx-background-color: lightgrey; -fx-padding: 0;" +
                        "-fx-font-size: 16px; -fx-font-color: black;" +
                        "-fx-border-color: gold; -fx-border-width: 2;" +
                        "-fx-border-radius: 5;");
            } else {
                splitButton.setStyle("-fx-background-color: grey; -fx-padding: 0; " +
                        "-fx-font-size: 16px; -fx-font-color: black; " +
                        "-fx-border-color: black; -fx-border-width: 2; " +
                        " -fx-border-radius: 5;");
            }
        });
    }

    private void setFoldButtonProperties() {
        foldButton.setStyle("-fx-background-color: grey; -fx-padding: 5;" +
                "-fx-font-size: 16px; -fx-font-color: black;" +
                "-fx-border-color: black; -fx-border-width: 2;" +
                "-fx-border-radius: 5;");
        foldButton.setMinWidth(80);
        foldButton.setPrefWidth(80);
        foldButton.setMaxWidth(80);
        foldButton.setMinHeight(40);
        foldButton.setPrefHeight(40);
        foldButton.setMaxHeight(40);
        foldButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                foldButton.setStyle("-fx-background-color: lightgrey; -fx-padding: 0;" +
                        "-fx-font-size: 16px; -fx-font-color: black;" +
                        "-fx-border-color: gold; -fx-border-width: 2;" +
                        "-fx-border-radius: 5;");
            } else {
                foldButton.setStyle("-fx-background-color: grey; -fx-padding: 0; " +
                        "-fx-font-size: 16px; -fx-font-color: black; " +
                        "-fx-border-color: black; -fx-border-width: 2; " +
                        " -fx-border-radius: 5;");
            }
        });
    }

    private void setDoubleDownButtonProperties() {
        doubleDownButton.setStyle("-fx-background-color: grey; -fx-padding: 0;" +
                "-fx-font-size: 14px; -fx-font-color: black;" +
                "-fx-border-color: black; -fx-border-width: 2;" +
                "-fx-border-radius: 5;");
        doubleDownButton.setMinWidth(80);
        doubleDownButton.setPrefWidth(80);
        doubleDownButton.setMaxWidth(80);
        doubleDownButton.setMinHeight(40);
        doubleDownButton.setPrefHeight(40);
        doubleDownButton.setMaxHeight(40);

        doubleDownButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                doubleDownButton.setStyle("-fx-background-color: lightgrey; -fx-padding: 0;" +
                        "-fx-font-size: 12px; -fx-font-color: black;" +
                        "-fx-border-color: gold; -fx-border-width: 2;" +
                        "-fx-border-radius: 5;");
            } else {
                doubleDownButton.setStyle("-fx-background-color: grey; -fx-padding: 0; " +
                        "-fx-font-size: 12px; -fx-font-color: black; " +
                        "-fx-border-color: black; -fx-border-width: 2; " +
                        " -fx-border-radius: 5;");
            }
        });
    }


    private void setVbox1Properties() {
        vbox1.setMargin(dealersDeckImageView, new Insets(5, 5, 30, 0));
        vbox1.setAlignment(Pos.CENTER);

        vbox1.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                "; -fx-border-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                "; -fx-border-width: .75;");

        vbox1.setOnMouseEntered(e -> {
            vbox1.setStyle("-fx-border-color: gold; -fx-border-width: .75;");
        });

        vbox1.setOnMouseExited(e -> {
            vbox1.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                    "; -fx-border-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                    "; -fx-border-width: .75;");
        });

    }


    private void setDealerHand1SpadeLabelProperties() {
    }



    private void setVbox2Properties() {
        vbox2.setMargin(cardPositionImageView2, new Insets(10, 5, 0, 0));

        vbox2.setAlignment(Pos.CENTER);
        vbox2.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                "; -fx-border-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                "; -fx-border-width: .35;");

        vbox2.setOnMouseEntered(e -> {
            vbox2.setStyle("-fx-border-color: gold; -fx-border-width: .35;");
        });

        vbox2.setOnMouseExited(e -> {
            vbox2.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                    "; -fx-border-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                    "; -fx-border-width: .35;");
        });

    }

    private void setVbox3Properties() {
        vbox3.setMargin(cardPositionImageView3, new Insets(10, 5, 0, 0));
        vbox3.setAlignment(Pos.CENTER);

        vbox3.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                "; -fx-border-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                "; -fx-border-width: .35;");

        vbox3.setOnMouseEntered(e -> {
            vbox3.setStyle("-fx-border-color: gold; -fx-border-width: .35;");
        });

        vbox3.setOnMouseExited(e -> {
            vbox3.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                    "; -fx-border-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                    "; -fx-border-width: .35;");
        });
    }

    private void setVbox4Properties() {
        vbox4.setMargin(cardPositionImageView4, new Insets(10, 5, 0, 0));
        vbox4.setAlignment(Pos.CENTER);

        vbox4.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                "; -fx-border-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                "; -fx-border-width: .35;");

        vbox4.setOnMouseEntered(e -> {
            vbox4.setStyle("-fx-border-color: gold; -fx-border-width: .35;");
        });

        vbox4.setOnMouseExited(e -> {
            vbox4.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                    "; -fx-border-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                    "; -fx-border-width: .35;");
        });
    }

    private void setVbox5Properties() {
        vbox5.setMargin(cardPositionImageView5, new Insets(10, 0, 0, 0));
        vbox5.setAlignment(Pos.CENTER);

        vbox5.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                ";-fx-border-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                "; -fx-border-width: .35;");

        vbox5.setOnMouseEntered(e -> {
            vbox5.setStyle("-fx-border-color: gold; -fx-border-width: .35;");
        });

        vbox5.setOnMouseExited(e -> {
            vbox5.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                    ";-fx-border-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                    "; -fx-border-width: .35;");
        });
    }

    // movingBlackjackLabel
    private void setVbox6Properties() {
        vbox6.setAlignment(Pos.CENTER);
        vbox6.setMinWidth(150);
        vbox6.setPrefWidth(150);
        vbox6.setMaxWidth(150);
        vbox6.setMinHeight(400);
        vbox6.setPrefHeight(400);
        vbox6.setMaxHeight(400);

        vbox6.setMargin(gamesPlayedLabel, new Insets(5, 0, 0, 0));
        vbox6.setMargin(scoreTitleLabel, new Insets(20, 0, 0, 0));
        vbox6.setMargin(nextMoveLabel, new Insets(20, 0, 0, 0));

        vbox6.setStyle("-fx-background-color: rgb(250,235,215,1); -fx-border-color: gold;" +
                " -fx-border-width: 4;");

        vbox6.setMargin(movingBlackjackVbox, new Insets(10, 0, 10, 0));

        vbox6.setOnMouseEntered(e -> {
        });

        vbox6.setOnMouseExited(e -> {
        });

    }

    private void setCardPositionImageView5Properties() {
        cardPositionImageView5.setFitWidth(90);
        cardPositionImageView5.setPreserveRatio(true);
        cardPositionImageView5.setSmooth(true);
    }

    private void setDealersDeckImageViewProperties(){
        dealersDeckImageView.setFitWidth(90);
        dealersDeckImageView.setPreserveRatio(true);
        dealersDeckImageView.setSmooth(true);
    }

    private void setCardPositionImageView2Properties(){
        cardPositionImageView2.setFitWidth(90);
        cardPositionImageView2.setPreserveRatio(true);
        cardPositionImageView2.setSmooth(true);
    }

    private void setCardPositionImageView3() {
        cardPositionImageView3.setFitWidth(90);
        cardPositionImageView3.setPreserveRatio(true);
        cardPositionImageView3.setSmooth(true);
    }

    private void setCardPositionImageView4Properties() {
        cardPositionImageView4.setFitWidth(90);
        cardPositionImageView4.setPreserveRatio(true);
        cardPositionImageView4.setSmooth(true);
    }
    private void setLayoutProperties() {
        layout.setStyle("-fx-background-color:" + BlackJackConstants.BACKGROUND_COLOUR +
                "; -fx-padding: 0; -fx-font-size: 16px; -fx-font-color: white;");
    }

    // Orlando - stackpane
    private void setHboxContainerForVBoxesProperties() {
        hboxContainerForVBoxes.setMargin(vbox1, new Insets(3, 0, 3, 30));
        hboxContainerForVBoxes.setMargin(sPane2, new Insets(3, 5, 3, 50));
        hboxContainerForVBoxes.setMargin(sPane3, new Insets(3, 30, 3, 5));
        hboxContainerForVBoxes.setMargin(sPane4, new Insets(3, 5, 3, 0));
        hboxContainerForVBoxes.setMargin(sPane5, new Insets(3, 5, 3, 0));
        hboxContainerForVBoxes.setMargin(vbox6, new Insets(0, 0, 0, 38));
    }



    private void addToBlackjackTextFlow() {
        blackjackTextFlow.getChildren().addAll( blackjackLetterSlash, blackjackLetterCarot,
                blackjackLetterB, blackjackLetterL, blackjackLetterA,
                blackjackLetterC, blackjackLetterK, blackjackLetterJ,
                blackjackLetter2ndA, blackjackLetter2ndC, blackjackLetter2ndK,
                blackjackLetterDollar, blackjackLetter2ndSlash);
    }

    private void setBlackjackTextFlowProperties() {
        blackjackTextFlow.setTextAlignment(TextAlignment.CENTER);
        blackjackTextFlow.setMinWidth(430);
        blackjackTextFlow.setPrefWidth(430);
        blackjackTextFlow.setMaxWidth(430);
        blackjackTextFlow.setMinHeight(40);
        blackjackTextFlow.setPrefHeight(40);
        blackjackTextFlow.setMaxHeight(40);

    }




    private void addToStackpane() {
        stackpane.getChildren().add(hboxContainerForVBoxes);
        stackpane.getChildren().add(blackjackTextFlow);
    }

    private void setBlackjackLetterSlashProperties() {
        blackjackLetterSlash.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetterSlash.setFill(Color.WHITE);
        blackjackLetterSlash.setOnMouseEntered(e -> {
            blackjackLetterSlash.setFill(Color.GREY);
        });

        blackjackLetterSlash.setOnMouseExited(e -> {
            blackjackLetterSlash.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetterCarotProperties() {
        blackjackLetterCarot.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetterCarot.setFill(Color.WHITE);
        blackjackLetterCarot.setOnMouseEntered(e -> {
            blackjackLetterCarot.setFill(Color.GREY);
        });

        blackjackLetterCarot.setOnMouseExited(e -> {
            blackjackLetterCarot.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetterBProperties() {
        blackjackLetterB.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetterB.setFill(Color.WHITE);
        blackjackLetterB.setOnMouseEntered(e -> {
            blackjackLetterB.setFill(Color.GREY);
        });

        blackjackLetterB.setOnMouseExited(e -> {
            blackjackLetterB.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetterLProperties() {
        blackjackLetterL.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetterL.setFill(Color.WHITE);
        blackjackLetterL.setOnMouseEntered(e -> {
            blackjackLetterL.setFill(Color.GREY);
        });

        blackjackLetterL.setOnMouseExited(e -> {
            blackjackLetterL.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetterAProperties() {
        blackjackLetterA.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetterA.setFill(Color.WHITE);
        blackjackLetterA.setOnMouseEntered(e -> {
            blackjackLetterA.setFill(Color.GREY);
        });

        blackjackLetterA.setOnMouseExited(e -> {
            blackjackLetterA.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetterCProperties() {
        blackjackLetterC.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetterC.setFill(Color.WHITE);
        blackjackLetterC.setOnMouseEntered(e -> {
            blackjackLetterC.setFill(Color.GREY);
        });

        blackjackLetterC.setOnMouseExited(e -> {
            blackjackLetterC.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetterKProperties() {
        blackjackLetterK.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetterK.setFill(Color.WHITE);

        blackjackLetterK.setOnMouseEntered(e -> {
            blackjackLetterK.setFill(Color.GREY);
        });

        blackjackLetterK.setOnMouseExited(e -> {
            blackjackLetterK.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetterJProperties() {
        blackjackLetterJ.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetterJ.setFill(Color.WHITE);

        blackjackLetterJ.setOnMouseEntered(e -> {
            blackjackLetterJ.setFill(Color.GREY);
        });

        blackjackLetterJ.setOnMouseExited(e -> {
            blackjackLetterJ.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetter2ndAProperties() {
        blackjackLetter2ndA.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetter2ndA.setFill(Color.WHITE);

        blackjackLetter2ndA.setOnMouseEntered(e -> {
            blackjackLetter2ndA.setFill(Color.GREY);
        });

        blackjackLetter2ndA.setOnMouseExited(e -> {
            blackjackLetter2ndA.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetter2ndCProperties() {
        blackjackLetter2ndC.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetter2ndC.setFill(Color.WHITE);

        blackjackLetter2ndC.setOnMouseEntered(e -> {
            blackjackLetter2ndC.setFill(Color.GREY);
        });

        blackjackLetter2ndC.setOnMouseExited(e -> {
            blackjackLetter2ndC.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetter2ndKProperties() {
        blackjackLetter2ndK.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetter2ndK.setFill(Color.WHITE);

        blackjackLetter2ndK.setOnMouseEntered(e -> {
            blackjackLetter2ndK.setFill(Color.GREY);
        });

        blackjackLetter2ndK.setOnMouseExited(e -> {
            blackjackLetter2ndK.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetterDollarProperties() {
        blackjackLetterDollar.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetterDollar.setFill(Color.WHITE);

        blackjackLetterDollar.setOnMouseEntered(e -> {
            blackjackLetterDollar.setFill(Color.GREY);
        });

        blackjackLetterDollar.setOnMouseExited(e -> {
            blackjackLetterDollar.setFill(Color.WHITE);
        });
    }
    private void setBlackjackLetter2ndSlashProperties() {
        blackjackLetter2ndSlash.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        blackjackLetter2ndSlash.setFill(Color.WHITE);

        blackjackLetter2ndSlash.setOnMouseEntered(e -> {
            blackjackLetter2ndSlash.setFill(Color.GREY);
        });

        blackjackLetter2ndSlash.setOnMouseExited(e -> {
            blackjackLetter2ndSlash.setFill(Color.WHITE);
        });
    }

    private void setStackpaneProperties() {
        stackpane.setAlignment(hboxContainerForVBoxes, Pos.CENTER);
        stackpane.setAlignment(blackjackTextFlow, Pos.CENTER);
        stackpane.setMargin(blackjackTextFlow, new Insets(15, 20, 0, 0));
        stackpane.setStyle("-fx-border-width: 3; -fx-border-color: GOLD;");
        stackpane.setMinWidth(800);
        stackpane.setPrefWidth(800);
        stackpane.setMaxWidth(800);
        stackpane.setMinHeight(400);
        stackpane.setPrefHeight(400);
        stackpane.setMaxHeight(400);
    }


    private void setStackpaneLabelProperties() {
        ScaleTransition st = new ScaleTransition(Duration.seconds(1), blackjackTextFlow);
        st.setByX(0.02);
        st.setByY(0.02);
        st.setCycleCount(Timeline.INDEFINITE);
        st.setDelay(Duration.millis(2000));
        st.setInterpolator(Interpolator.EASE_BOTH);
        st.setAutoReverse(true);
        st.play();
    }



    private void setDealerLabelProperties() {
        dealerLabel.setTextFill(Color.WHITE);
        dealerLabel.setOnMouseEntered(e -> {
            dealerLabel.setTextFill(Color.BLACK);
        });

        dealerLabel.setOnMouseExited(e -> {
            dealerLabel.setTextFill(Color.WHITE);
        });
    }


    private void setPlayerLabelProperties() {
        playerLabel.setTextFill(Color.WHITE);
        playerLabel.setOnMouseEntered(e -> {
            playerLabel.setTextFill(Color.BLACK);
        });
        playerLabel.setOnMouseExited(e -> {
            playerLabel.setTextFill(Color.WHITE);
        });
    }


    private void setPlayerLabelHboxProperties() {
        playerLabelHbox.setPadding(new Insets(12, 0, 12, 10));

        playerLabelHbox.setStyle("-fx-border-width: 3; -fx-border-color: GOLD; -fx-background-color:" +
                BlackJackConstants.BACKGROUND_COLOUR +";");

        playerLabelHbox.setMinWidth(800);
        playerLabelHbox.setPrefWidth(800);
        playerLabelHbox.setMaxWidth(800);
        playerLabelHbox.setMinHeight(52);
        playerLabelHbox.setPrefHeight(52);
        playerLabelHbox.setMaxHeight(52);

        playerLabelHbox.setOnMouseEntered(e -> {
            playerLabelHbox.setStyle("-fx-border-width: 3; -fx-border-color: GOLD; -fx-background-color:GREY;");
        });
        playerLabelHbox.setOnMouseExited(e -> {
            playerLabelHbox.setStyle("-fx-border-width: 3; -fx-border-color: GOLD; -fx-background-color:" +
                    BlackJackConstants.BACKGROUND_COLOUR + ";");
        });
    }

    private void addToPlayerLabelHbox() {
        playerLabelHbox.getChildren().add(playerSpadeLabel);
        playerLabelHbox.getChildren().add(playerNameLabel);
        playerLabelHbox.getChildren().add(playerDiamondLabel);
        playerLabelHbox.getChildren().add(playerLabel);
        playerLabelHbox.getChildren().add(playerHeartLabel);
    }


    private void setDealerLabelHboxProperties() {
        dealerLabelHbox.setPadding(new Insets(12, 0, 12, 10));

        dealerLabelHbox.setStyle("-fx-border-width: 3; -fx-border-color: GOLD; -fx-background-color:" +
                BlackJackConstants.BACKGROUND_COLOUR + ";");

        dealerLabelHbox.setMinWidth(800);
        dealerLabelHbox.setPrefWidth(800);
        dealerLabelHbox.setMaxWidth(800);
        dealerLabelHbox.setMinHeight(52);
        dealerLabelHbox.setPrefHeight(52);
        dealerLabelHbox.setMaxHeight(52);

        dealerLabelHbox.setOnMouseEntered(e -> {
            dealerLabelHbox.setStyle("-fx-border-width: 3; -fx-border-color: GOLD; -fx-background-color:GREY;");
        });
        dealerLabelHbox.setOnMouseExited(e -> {
            dealerLabelHbox.setStyle("-fx-border-width: 3; -fx-border-color: GOLD; -fx-background-color:" +
                    BlackJackConstants.BACKGROUND_COLOUR + ";");
        });
    }

    private void addToDealerLabelHbox() {
        dealerLabelHbox.getChildren().add(dealerDiamondLabel);
        dealerLabelHbox.getChildren().add(dealerNameLabel);
        dealerLabelHbox.getChildren().add(dealerClubLabel);
        dealerLabelHbox.getChildren().add(dealerLabel);
        dealerLabelHbox.getChildren().add(dealerSpadeLabel);
    }


    private void setDeckLabelProperties() {
        deckLabel.setTextFill(Color.WHITE);
        deckLabel.setOnMouseEntered(e -> {
            deckLabel.setTextFill(Color.GREY);
        });
        deckLabel.setOnMouseExited(e -> {
            deckLabel.setTextFill(Color.WHITE);
        });
    }

    private void setPlayerHand2LabelProperties() {
        playerHand2Label.setTextFill(Color.WHITE);

        playerHand2Label.setOnMouseEntered(e -> {
            playerHand2Label.setTextFill(Color.GREY);
        });
        playerHand2Label.setOnMouseExited(e -> {
            playerHand2Label.setTextFill(Color.WHITE);
        });
    }

    private void setDealerHand1LabelProperties() {
        dealerHand1Label.setTextFill(Color.WHITE);
        dealerHand1Label.setOnMouseEntered(e -> {
            dealerHand1Label.setTextFill(Color.GREY);
        });
        dealerHand1Label.setOnMouseExited(e -> {
            dealerHand1Label.setTextFill(Color.WHITE);
        });
    }
    private void setPlayerHand1LabelProperties() {
        playerHand1Label.setTextFill(Color.WHITE);
        playerHand1Label.setOnMouseEntered(e -> {
            playerHand1Label.setTextFill(Color.GREY);
        });
        playerHand1Label.setOnMouseExited(e -> {
            playerHand1Label.setTextFill(Color.WHITE);
        });
    }
    private void setDealerHand2LabelProperties() {
        dealerHand2Label.setTextFill(Color.WHITE);
        dealerHand2Label.setOnMouseEntered(e -> {
            dealerHand2Label.setTextFill(Color.GREY);
        });
        dealerHand2Label.setOnMouseExited(e -> {
            dealerHand2Label.setTextFill(Color.WHITE);
        });
    }


    private void addToLayout() {
        layout.getChildren().add(blackJackGameMenu.getMenuBar());
        layout.getChildren().add(dealerLabelHbox);
        layout.getChildren().add(stackpane);
        layout.getChildren().add(playerLabelHbox);
        layout.getChildren().add(statusBar);
    }

    private void addToMovingBlackjackVbox() {
        movingBlackjackVbox.getChildren().add(movingBlackjackLabel);
    }
    private void setMovingBlackjackVboxProperties() {
        movingBlackjackVbox.setAlignment(Pos.CENTER_LEFT);
    }

    private void addToVbox4() {
        vbox4.getChildren().add(dealerHand2Label);
        vbox4.getChildren().add(cardPositionImageView4);
        vbox4.getChildren().add(playerHand2Label);
    }


    private void setTotalGamesPlayedLabelProperties() {
        totalGamesPlayedLabel.setTextFill(Color.BLACK);
        totalGamesPlayedLabel.setOnMouseEntered(e -> {
            totalGamesPlayedLabel.setTextFill(Color.GREY);
        });
        totalGamesPlayedLabel.setOnMouseExited(e -> {
            totalGamesPlayedLabel.setTextFill(Color.BLACK);
        });
    }

    private void setDealerScoresLabelProperties() {
        dealerScoresLabel.setTextFill(Color.BLACK);
        dealerScoresLabel.setOnMouseEntered(e -> {
            dealerScoresLabel.setTextFill(Color.GREY);
        });
        dealerScoresLabel.setOnMouseExited(e -> {
            dealerScoresLabel.setTextFill(Color.BLACK);
        });
    }

    private void setPlayerScoresLabelProperties() {
        playerScoresLabel.setTextFill(Color.BLACK);
        playerScoresLabel.setOnMouseEntered(e -> {
            playerScoresLabel.setTextFill(Color.GREY);
        });
        playerScoresLabel.setOnMouseExited(e -> {
            playerScoresLabel.setTextFill(Color.BLACK);
        });
    }

    private void setNextMoveNameLabelProperties() {
        nextMoveNameLabel.setTextFill(Color.BLACK);
        nextMoveNameLabel.setOnMouseEntered(e -> {
            nextMoveNameLabel.setTextFill(Color.GREY);
        });
        nextMoveNameLabel.setOnMouseExited(e -> {
            nextMoveNameLabel.setTextFill(Color.BLACK);
        });
    }

    private void setActualTimePlayedLabelProperties() {
        actualTimePlayedLabel.setTextFill(Color.BLACK);
        actualTimePlayedLabel.setOnMouseEntered(e -> {
            actualTimePlayedLabel.setTextFill(Color.GREY);
        });
        actualTimePlayedLabel.setOnMouseExited(e -> {
            actualTimePlayedLabel.setTextFill(Color.BLACK);
        });
    }


    private void addToVBox6() {
        vbox6.getChildren().add(gamesPlayedLabel);
        vbox6.getChildren().add(totalGamesPlayedLabel);

        vbox6.getChildren().add(scoreTitleLabel);

        vbox6.getChildren().add(dealerScoresLabel);
        vbox6.getChildren().add(playerScoresLabel);

        vbox6.getChildren().add(nextMoveLabel);
        vbox6.getChildren().add(nextMoveNameLabel);

        vbox6.getChildren().add(resultLabel);

        vbox6.getChildren().add(timePlayedLabel);
        vbox6.getChildren().add(actualTimePlayedLabel);

        vbox6.getChildren().add(movingBlackjackVbox);

    }
    private void addToVbox3() {
        vbox3.getChildren().add(cardPositionImageView3);
    }

    private void addToVbox5() {
        vbox5.getChildren().add(cardPositionImageView5);
    }


    private void addToSPane2() {
        sPane2.getChildren().add(vbox2);
    }
    private void addToSPane3() {
        sPane3.getChildren().add(vbox3);
    }
    private void addToSPane4() {
        sPane4.getChildren().add(vbox4);
    }
    private void addToSPane5() {
        sPane5.getChildren().add(vbox5);
    }


    private void addToVbox2() {
        vbox2.getChildren().add(dealerHand1Label);
        vbox2.getChildren().add(cardPositionImageView2);
        vbox2.getChildren().add(playerHand1Label);
    }


    private void addToVbox1() {
        vbox1.getChildren().add(deckLabel);
        vbox1.getChildren().add(dealersDeckImageView);
        vbox1.getChildren().add(hitButton);
        vbox1.getChildren().add(stayButton);
        vbox1.getChildren().add(splitButton);
        vbox1.getChildren().add(foldButton);
        vbox1.getChildren().add(doubleDownButton);
    }

    private void addTohboxContainerForVBoxes() {
        //hboxContainerForVBoxes.getChildren().addAll(vbox1, vbox2, vbox3, vbox4, vbox5, vbox6);
        hboxContainerForVBoxes.getChildren().addAll(vbox1, sPane2, sPane3, sPane4, sPane5, vbox6);
        //hboxContainerForVBoxes.getChildren().addAll(vbox1, vbox2Inner, vbox3, vbox4, vbox5, vbox6);
    }

    private void setGamesPlayedLabelProperties() {
        gamesPlayedLabel.setTextFill(Color.BLACK);
        gamesPlayedLabel.setOnMouseEntered(e -> {
            gamesPlayedLabel.setTextFill(Color.GREY);
        });
        gamesPlayedLabel.setOnMouseExited(e -> {
            gamesPlayedLabel.setTextFill(Color.BLACK);
        });
    }
    private void setScoreTitleLabelProperties() {
        scoreTitleLabel.setTextFill(Color.BLACK);
        scoreTitleLabel.setOnMouseEntered(e -> {
            scoreTitleLabel.setTextFill(Color.GREY);
        });
        scoreTitleLabel.setOnMouseExited(e -> {
            scoreTitleLabel.setTextFill(Color.BLACK);
        });
    }


    // Orlando - scores ...
    private void setScoresLabelProperties() {
        scoresLabel.setTextFill(Color.BLACK);
        scoresLabel.setMinHeight(60);
        scoresLabel.setPrefHeight(60);
        scoresLabel.setMaxHeight(60);

        scoresLabel.setOnMouseEntered(e -> {
            scoresLabel.setTextFill(Color.GREY);
        });
        scoresLabel.setOnMouseExited(e -> {
            scoresLabel.setTextFill(Color.BLACK);
        });
    }



    private void setNextMoveLabelProperties() {
        nextMoveLabel.setTextFill(Color.BLACK);
        nextMoveLabel.setOnMouseEntered(e -> {
            nextMoveLabel.setTextFill(Color.GREY);
        });
        nextMoveLabel.setOnMouseExited(e -> {
            nextMoveLabel.setTextFill(Color.BLACK);
        });
    }
    private void setTimePlayedLabelProperties() {
        timePlayedLabel.setTextFill(Color.BLACK);
        timePlayedLabel.setOnMouseEntered(e -> {
            timePlayedLabel.setTextFill(Color.GREY);
        });
        timePlayedLabel.setOnMouseExited(e -> {
            timePlayedLabel.setTextFill(Color.BLACK);
        });
    }

    private void setStatusBarProperties() {
        statusBar.setEditable(false);
        statusBar.setFont(Font.font("Times", 16));

        statusBar.setStyle("-fx-text-fill: BLACK; -fx-background-color:GREY; " +
                "-fx-border-color: GOLD;-fx-border-width:3;");


        statusBar.setText(blackJackConstants.CLUB + "Statusbar" + blackJackConstants.SPADE);

        statusBar.setMinWidth(800);
        statusBar.setPrefWidth(800);
        statusBar.setMaxWidth(800);
        statusBar.setMinHeight(50);
        statusBar.setPrefHeight(50);
        statusBar.setMaxHeight(50);

        statusBar.setOnMouseEntered(e -> {
            statusBar.setStyle("-fx-text-fill: GREY; -fx-background-color:LIGHTGREY;" +
                    " -fx-border-color: GOLD;-fx-border-width:3;");
        });

        statusBar.setOnMouseExited(e -> {
            statusBar.setStyle("-fx-text-fill: BLACK; -fx-background-color:GREY; " +
                    "-fx-border-color: GOLD;-fx-border-width:3;");
        });
    }

    private void setResultLabelProperties() {
        resultLabel.setWrapText(true);
        resultLabel.setTextFill(Color.GREY);

        resultLabel.setMinHeight(50);
        resultLabel.setPrefHeight(50);
        resultLabel.setMaxHeight(50);

        resultLabel.setOnMouseEntered(e -> {
            resultLabel.setTextFill(Color.WHITE);
        });
        resultLabel.setOnMouseExited(e -> {
            resultLabel.setTextFill(Color.GREY);
        });
    };

    private void updateStatus(String message) {
        statusBar.setText(message);
    }


    public int getUiGamesPlayed() {
        return controller.getGamesPlayed();
    }

    public int getUiPlayerScore() {
        return controller.getPlayerScore();
    }

    public int getUiDealerScore() {
        return controller.getDealerScore();
    }

    public SoundManager getSoundManager() {
        return soundManager;
    }

    public Stage getStage() {
        return stage;
    }



}