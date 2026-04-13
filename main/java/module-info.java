module BlackJack {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;

    exports BlackJack;
    exports BlackJack.controller;
    exports BlackJack.logic;
    exports BlackJack.model;
    exports BlackJack.ui;

    opens BlackJack.controller to javafx.fxml;
}
