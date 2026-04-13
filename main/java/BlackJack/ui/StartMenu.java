package BlackJack.ui;

import BlackJack.sound.SoundManager;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartMenu {

    private SoundManager sound;
    private Stage stage;

    public StartMenu(Stage stage) {
        this.stage = stage;
        sound = new SoundManager();
    }

    public Scene Scene() {

        sound.toggleMusic(true);
        sound.playCustom("StartScene.mp3");

        Image logoImage = new Image(
                getClass().getResource("/Images/BlackJack21.png").toExternalForm()
        );
        ImageView logoView = new ImageView(logoImage);
        logoView.setFitWidth(350);
        logoView.setPreserveRatio(true);

        FadeTransition glow = new FadeTransition(Duration.seconds(1.5), logoView);
        glow.setFromValue(0.6);
        glow.setToValue(1.0);
        glow.setCycleCount(FadeTransition.INDEFINITE);
        glow.setAutoReverse(true);
        glow.play();

        Text subtitle = new Text("Created by Isaac Jackson & Orlando Cicchello");
        subtitle.setFont(Font.font("Verdana", 20));
        subtitle.setFill(Color.web("#ffcc00"));

        Button startButton = neonButton("Start Game");
        Button settingsButton = neonButton("Settings");
        Button quitButton = neonButton("Quit");

        VBox innerBox = new VBox(25, logoView, subtitle, startButton, settingsButton, quitButton);
        innerBox.setAlignment(Pos.CENTER);

        innerBox.setMaxWidth(500);
        innerBox.setPadding(new Insets(40));

        StackPane root = new StackPane(innerBox);
        root.setStyle("-fx-background-color: linear-gradient(#0b001a, #000000);");

        Scene scene = new Scene(root, 800, 600);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1.2), innerBox);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();

        startButton.setOnAction(e -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), innerBox);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);

            fadeOut.setOnFinished(event -> {
                sound.fadeOutMusic();
                MainScene gameScene = new MainScene(stage, sound);
                Scene mainScene = gameScene.createScene();
                stage.setScene(mainScene);
            });

            fadeOut.play();
        });

        settingsButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Settings are available in the main game menu.");
            alert.show();
        });

        quitButton.setOnAction(e -> stage.close());

        return scene;
    }

    private Button neonButton(String text) {
        Button b = new Button(text);
        b.setFont(Font.font("Arial", 18));
        b.setMinWidth(180);
        b.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #00eaff;" +
                        "-fx-border-color: #00eaff;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 6;"
        );

        b.setOnMouseEntered(e -> b.setStyle(
                "-fx-background-color: rgba(0,234,255,0.2);" +
                        "-fx-text-fill: #00eaff;" +
                        "-fx-border-color: #00eaff;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 6;"
        ));

        b.setOnMouseExited(e -> b.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #00eaff;" +
                        "-fx-border-color: #00eaff;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 6;"
        ));

        return b;
    }
}
