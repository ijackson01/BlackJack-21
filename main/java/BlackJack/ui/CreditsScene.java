package BlackJack.ui;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class CreditsScene {

    private Stage stage;

    public CreditsScene(Stage stage) {
        this.stage = stage;
    }

    public Scene createScene() {

        Text title = new Text("Credits");
        title.setFont(Font.font("Verdana", 50));
        title.setFill(Color.GOLD);

        Text names = new Text(
                "Developed by:\n\n" +
                        "• Isaac Jackson\n" +
                        "• Orlando Cicchello\n\n" +
                        "Course: MAD200 – Java Programming\n" +
                        "College: St. Clair College\n" +
                        "Year: 2025\n\n" +
                        "Card images from:\n" +
                        "Google Code Archive – Vector Playing Cards\n" +
                        "https://code.google.com/archive/p/vector-playing-cards/downloads\n\n" +
                        "Images used only for educational and non-commercial purposes."
        );



        names.setFont(Font.font("Arial", 18));
        names.setFill(Color.WHITE);

        Button backButton = new Button("Back");
        backButton.setFont(Font.font("Arial", 18));
        backButton.setStyle("-fx-background-color: lightgrey; -fx-border-color: black; -fx-border-width: 2;");
        backButton.setMinWidth(150);

        VBox layout = new VBox(25, title, names, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40, 20, 40, 20));
        layout.setStyle("-fx-background-color: linear-gradient(#003d1f, #001a0d);");

        Scene scene = new Scene(layout);
        layout.prefWidthProperty().bind(scene.widthProperty());
        layout.prefHeightProperty().bind(scene.heightProperty());


        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1.2), layout);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();


        backButton.setOnAction(e -> {


            MainScene mainScene = GameSceneHolder.mainScene;


            if (mainScene != null) {
                Scene gameScene = mainScene.createScene();

                FadeTransition fade = new FadeTransition(Duration.seconds(1), gameScene.getRoot());
                fade.setFromValue(0);
                fade.setToValue(1);

                stage.setScene(gameScene);
                fade.play();
            }
        });

        return scene;
    }
}
