package BlackJack;

import BlackJack.ui.StartMenu;
import BlackJack.logic.BlackJackConstants;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class BlackJackApp extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {

			StartMenu startMenu = new StartMenu(primaryStage);
			Scene startScene = startMenu.Scene();
			BlackJackConstants blackJackConstants = new BlackJackConstants();
			Image icon = new Image(getClass().getResourceAsStream("/Cards/b2fv.png"));
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(startScene);
			primaryStage.setTitle(blackJackConstants.STAGE_TITLE + blackJackConstants.SPADE +
					blackJackConstants.STAGE_SUBTITLE + blackJackConstants.CLUB);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
