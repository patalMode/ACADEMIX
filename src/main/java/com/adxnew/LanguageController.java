package com.adxnew;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LanguageController {
    @FXML private Button calcButton;
    @FXML private Button fibButton;
    @FXML private Button gradeButton;
    @FXML private Button bmiButton;
    @FXML private Button backButton;

    @FXML
    private void handlePOHButton() {
        try {
            SceneController.getInstance().switchToScene("POHScene");
        } catch (Exception e) {
            System.err.println("Failed to switch to POH scene: " + e.getMessage());
        }
    }

    @FXML
    private void handleFibButton() {
        try {
            SceneController.getInstance().switchToScene("vocabScene");
        } catch (Exception e) {
            System.err.println("Failed to switch to vocabulary scene: " + e.getMessage());
        }
    }

    @FXML
    private void handleBackButton() {
        BackButton.handleBackButton("menuScene");
    }
}