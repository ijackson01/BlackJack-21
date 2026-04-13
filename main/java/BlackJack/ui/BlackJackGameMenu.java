package BlackJack.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.CheckMenuItem;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import javafx.application.Platform;

public class BlackJackGameMenu {

	private MenuBar menuBar;
	private MainScene mainScene;

	private Menu fileMenu;
	private MenuItem newMenuItem;
	private MenuItem resetMenuItem;
	private MenuItem exitMenuItem;

	private Menu optionsMenu;
	private MenuItem prefMenuItem;
	private MenuItem statsMenuItem;

	private Menu volumeSubMenu;
	private CheckMenuItem toggleMusicMenuItem;
	private CheckMenuItem toggleEffectsMenuItem;

	private Menu helpMenu;
	private MenuItem howToMenuItem;
	private MenuItem aboutMenuItem;


	private MenuItem creditsItem;

	public BlackJackGameMenu(MainScene mainScene) {
		this.mainScene = mainScene;

		menuBar = new MenuBar();

		fileMenu = new Menu("_File");
		newMenuItem = new MenuItem("_New...");
		resetMenuItem = new MenuItem("_Reset...");
		exitMenuItem = new MenuItem("_Exit...");

		optionsMenu = new Menu("_Settings");
		prefMenuItem = new MenuItem("_Preferences...");
		statsMenuItem = new MenuItem("_Stats...");
		volumeSubMenu = new Menu("_Volume");
		toggleMusicMenuItem = new CheckMenuItem("Music");
		toggleEffectsMenuItem = new CheckMenuItem("Effects");

		helpMenu = new Menu("_Help");
		howToMenuItem = new MenuItem("_How to play...");
		aboutMenuItem = new MenuItem("_About...");
		creditsItem = new MenuItem("_Credits...");
	}

	public void createMenuBar() {

		setMenuBarProperties();
		setNewMenuItemProperties();
		setResetMenuItemProperties();
		setExitMenuItemProperties();
		addToFileMenu();

		setPrefMenuItemProperties();
		setStatsMenuItemProperties();

		statsMenuItem.setOnAction(event -> {
			if (GameSceneHolder.mainScene != null) {
				int games = GameSceneHolder.mainScene.getUiGamesPlayed();
				int player = GameSceneHolder.mainScene.getUiPlayerScore();
				int dealer = GameSceneHolder.mainScene.getUiDealerScore();

				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Game Statistics");
				a.setHeaderText("Current Blackjack Stats");
				a.setContentText(
						"Games Played: " + games + "\n" +
								"Player Wins: " + player + "\n" +
								"Dealer Wins: " + dealer + "\n" +
								"Ties: " + (games - player - dealer)
				);
				a.getDialogPane().setPrefSize(300, 200);
				a.showAndWait();
			} else {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Game Statistics");
				a.setHeaderText("No Data");
				a.setContentText("Please start a game first.");
				a.showAndWait();
			}
		});

		setVolumeControlsProperties();
		addToOptionsMenu();


		setHowToMenuItemProperties();
		howToMenuItem.setOnAction(event -> {
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("How to Play");
			a.setHeaderText("BlackJack — Complete Guide");

			javafx.scene.control.TextArea text = new javafx.scene.control.TextArea(
					" OBJECTIVE  \n" +
							"The goal of Blackjack is to reach a total as close to 21 as possible without going over.  \n" +
							"If your hand is higher than 21, you lose immediately.\n" +
							"\n" +
							"CARD VALUES  \n" +
							"• Cards 2–10 are worth their number.  \n" +
							"• Jack, Queen, and King are worth 10.  \n" +
							"• Ace can be 1 or 11, depending on what helps your hand the most.\n" +
							"\n" +
							"BASIC GAMEPLAY  \n" +
							"You start with two cards. The dealer also receives two cards, but one of the dealer’s cards is hidden.\n" +
							"\n" +
							"PLAYER ACTIONS  \n" +
							"• Hit: Take another card if you want to increase your total.  \n" +
							"• Stay: Keep your current total and end your turn.  \n" +
							"• Split: If your first two cards have the same value, you can create two separate hands (feature coming soon).  \n" +
							"• Double Down: Double your bet and take one final card (coming soon).  \n" +
							"• Fold: End the round early (coming soon).\n" +
							"\n" +
							"DEALER RULES  \n" +
							"The dealer must keep drawing cards until the total is at least 17.  \n" +
							"If the dealer’s total goes above 21, the dealer loses.\n" +
							"\n" +
							"HOW TO WIN  \n" +
							"You win if your total is closer to 21 than the dealer’s total, without going over.  \n" +
							"If you and the dealer have the same total, the result is a tie (push).\n" +
							"\n" +
							"BASIC STRATEGY TIPS  \n" +
							"• Hit if your total is low and the dealer shows a strong card.  \n" +
							"• Stay if you have a high total or if the dealer shows a weak card.  \n" +
							"• Avoid taking unnecessary risks when you are already close to 21.\n" +
							"\n" +
							"SUMMARY  \n" +
							"Blackjack is a simple strategy game:  \n" +
							"Try not to go over 21, make smart decisions with each card, and pay attention to the dealer’s visible card.\n"
			);
			text.setWrapText(true);
			text.setEditable(false);
			a.getDialogPane().setContent(text);
			a.getDialogPane().setPrefSize(600, 500);
			a.showAndWait();
		});

		setAboutMenuItemProperties();
		aboutMenuItem.setOnAction(event -> {
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("About");
			a.setHeaderText("BlackJack — Version 1.0 Final Build");

			javafx.scene.control.TextArea text = new javafx.scene.control.TextArea(
					"Made by: Isaac Jackson & Orlando Cicchello\n\nMade by: Isaac Jackson & Orlando Cicchello\n" +
							"© 2025 Final Project — St. Clair College\n" +
							"\n" +
							"Note:\n" +
							"The Split, Fold, and Double options are currently disabled in this version.\n" +
							"These features are planned for a future update of the game."
			);
			text.setWrapText(true);
			text.setEditable(false);
			a.getDialogPane().setContent(text);
			a.getDialogPane().setPrefSize(500, 300);
			a.showAndWait();
		});




		creditsItem.setOnAction(event -> {
			CreditsScene cs = new CreditsScene(mainScene.getStage());
			javafx.scene.Scene creditsScene = cs.createScene();
			mainScene.getStage().setScene(creditsScene);
		});


		addToHelpMenu();

		addToMenuBar();
	}

	public MenuBar getMenuBar() {
		return this.menuBar;
	}


	private void setMenuBarProperties() {
		menuBar.setStyle("-fx-background-color: lightgrey; -fx-padding: 5;");
	}

	private void setNewMenuItemProperties() {
		newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
		newMenuItem.setOnAction(e -> {
			if (GameSceneHolder.mainScene != null) {
				GameSceneHolder.mainScene.startNewGame();
			}
		});
	}

	private void setResetMenuItemProperties() {
		resetMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));
		resetMenuItem.setOnAction(e -> {
			if (GameSceneHolder.mainScene != null) {
				GameSceneHolder.mainScene.resetGame();
			}
		});
	}

	private void setExitMenuItemProperties() {
		exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
		exitMenuItem.setOnAction(e -> Platform.exit());
	}

	private void setPrefMenuItemProperties() {
		prefMenuItem.setOnAction(e -> {
			BlackJackPreferences pref = new BlackJackPreferences();
			pref.show();
		});
	}

	private void setStatsMenuItemProperties() {}

	private void setVolumeControlsProperties() {
		toggleMusicMenuItem.setSelected(true);
		toggleMusicMenuItem.setOnAction(e ->
				mainScene.getSoundManager().toggleMusic(toggleMusicMenuItem.isSelected()));
		toggleEffectsMenuItem.setSelected(true);
		toggleEffectsMenuItem.setOnAction(e ->
				mainScene.getSoundManager().toggleEffects(toggleEffectsMenuItem.isSelected()));

		volumeSubMenu.getItems().addAll(toggleMusicMenuItem, toggleEffectsMenuItem);
	}

	private void setHowToMenuItemProperties() {}
	private void setAboutMenuItemProperties() {}

	private void addToHelpMenu() {
		helpMenu.getItems().addAll(howToMenuItem, aboutMenuItem, creditsItem);
	}

	private void addToOptionsMenu() {
		optionsMenu.getItems().addAll(prefMenuItem, statsMenuItem, new SeparatorMenuItem(), volumeSubMenu);
	}

	private void addToFileMenu() {
		fileMenu.getItems().addAll(newMenuItem, resetMenuItem, new SeparatorMenuItem(), exitMenuItem);
	}

	private void addToMenuBar() {
		menuBar.getMenus().addAll(fileMenu, optionsMenu, helpMenu);
	}
}
