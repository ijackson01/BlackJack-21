package BlackJack.ui;

import BlackJack.model.Card;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardView extends ImageView {

    public CardView(Card card) {
        super();

        if (card != null) {
            String file = card.getImageName();
            try {
                Image image = new Image(
                        CardView.class.getResource("/Cards/" + file).toExternalForm()
                );
                setImage(image);
            } catch (Exception e) {
                System.out.println("Sorry, the image for this card could not be loaded: " + file);
            }
        }

        setFitWidth(100);
        setPreserveRatio(true);
    }

    public static CardView getBackCard() {
        try {
            Image back = new Image(
                    CardView.class.getResource("/Cards/b2fv.png").toExternalForm()
            );
            CardView view = new CardView(null);
            view.setImage(back);
            view.setFitWidth(100);
            view.setPreserveRatio(true);
            return view;

        } catch (Exception e) {
            System.out.println("Sorry, the back of the card image could not be loaded.");
            return null;
        }
    }
}
