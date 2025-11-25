package com.adxnew;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.Random;
import javafx.application.Platform;

public class ImageMovement {
    private static final Random random = new Random();
    private static final double MIN_DURATION = 3.0;
    private static final double MAX_DURATION = 5.0;
    private static final double MIN_TRANSLATE = -20.0;
    private static final double MAX_TRANSLATE = 20.0;

    public static void applyRandomMovement(ImageView imageView) {
        if (imageView == null) return;

        Platform.runLater(() -> {
            try {
                TranslateTransition translateX = new TranslateTransition(
                    Duration.seconds(randomDuration()), imageView);
                translateX.setByX(randomTranslation());
                translateX.setCycleCount(TranslateTransition.INDEFINITE);
                translateX.setAutoReverse(true);

                TranslateTransition translateY = new TranslateTransition(
                    Duration.seconds(randomDuration()), imageView);
                translateY.setByY(randomTranslation());
                translateY.setCycleCount(TranslateTransition.INDEFINITE);
                translateY.setAutoReverse(true);

                translateX.play();
                translateY.play();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });
    }

    private static double randomDuration() {
        return MIN_DURATION + (MAX_DURATION - MIN_DURATION) * random.nextDouble();
    }

    private static double randomTranslation() {
        return MIN_TRANSLATE + (MAX_TRANSLATE - MIN_TRANSLATE) * random.nextDouble();
    }
}