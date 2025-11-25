package com.adxnew;

public class BackButton {
    public static void handleBackButton(String previousScene) {
        SceneController.getInstance().switchToScene(previousScene);
    }
}