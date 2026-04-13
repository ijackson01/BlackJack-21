package BlackJack.sound;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

public class SoundManager {

    private MediaPlayer backgroundPlayer;
    private boolean effectsEnabled = true;
    private boolean musicEnabled = true;
    private final List<MediaPlayer> activeEffects = new ArrayList<>();

    public void playCustom(String file) {
        try {
            stopBackground();

            backgroundPlayer = new MediaPlayer(
                    new Media(getClass().getResource("/sounds/" + file).toString())
            );

            backgroundPlayer.setCycleCount(MediaPlayer.INDEFINITE);

            if (musicEnabled) {
                backgroundPlayer.play();
            }

        } catch (Exception e) {
            System.out.println("Error loading background: " + file);
        }
    }

    public void playBackground() {
        if (backgroundPlayer != null && musicEnabled) {
            backgroundPlayer.play();
        }
    }

    public void stopBackground() {
        if (backgroundPlayer != null) {
            backgroundPlayer.stop();
            backgroundPlayer.dispose();
            backgroundPlayer = null;
        }
    }

    public void fadeOutMusic() {
        if (backgroundPlayer == null) return;

        Timeline fade = new Timeline(
                new KeyFrame(Duration.millis(0),  e -> backgroundPlayer.setVolume(1.0)),
                new KeyFrame(Duration.millis(300), e -> backgroundPlayer.setVolume(0.6)),
                new KeyFrame(Duration.millis(600), e -> backgroundPlayer.setVolume(0.3)),
                new KeyFrame(Duration.millis(900), e -> backgroundPlayer.setVolume(0.1)),
                new KeyFrame(Duration.millis(1100), e -> {
                    backgroundPlayer.stop();
                    backgroundPlayer.setVolume(1.0);
                })
        );
        fade.play();
    }

    public void toggleEffects(boolean enabled) {
        effectsEnabled = enabled;
    }

    public void toggleMusic(boolean enabled) {
        musicEnabled = enabled;

        if (!enabled) stopBackground();
        else playBackground();
    }

    public void playEffect(String name) {
        if (!effectsEnabled) return;

        try {
            MediaPlayer mp = new MediaPlayer(
                    new Media(getClass().getResource("/sounds/" + name).toString())
            );

            activeEffects.add(mp);

            mp.setOnEndOfMedia(() -> {
                mp.dispose();
                activeEffects.remove(mp);
            });

            mp.play();

        } catch (Exception e) {
            System.out.println("Error playing effect: " + name);
        }
    }

    public void playDeal()  { playEffect("card_deal.wav"); }
    public void playHit()   { playEffect("hit.wav"); }
    public void playStay()  { playEffect("stay.wav"); }
    public void playShuffle(){ playEffect("shuffle.wav"); }
    public void playWin()   { playEffect("win.wav"); }
    public void playLose()  { playEffect("lose.wav"); }
    public void playTie()   { playEffect("tie.wav"); }
    public void playButton(){ playEffect("button_click.wav"); }
}
