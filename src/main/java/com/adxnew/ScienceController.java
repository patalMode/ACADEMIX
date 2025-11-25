package com.adxnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ScienceController {
    @FXML private Button zElementButton;
    @FXML private Button fibButton;
    @FXML private Button gradeButton;
    @FXML private Button bmiButton;
    @FXML private Button backButton;

    @FXML
    private void handleZElementButton(ActionEvent event) {
        try {
            SceneController.getInstance().switchToScene("zElementScene");
        } catch (Exception e) {
            System.err.println("Failed to switch to z element scene: " + e.getMessage());
        }
    }

    @FXML
    private void handleSSButton() {
        try {
            SceneController.getInstance().switchToScene("SSScene");
        } catch (Exception e) {
            System.err.println("Failed to switch to solar system scene: " + e.getMessage());
        }
    }

    @FXML
    private void handleHealthButton() {
        try {
            SceneController.getInstance().switchToScene("healthScene");
        } catch (Exception e) {
            System.err.println("Failed to switch to health tracker scene: " + e.getMessage());
        }
    }

    @FXML
    private void handleBackButton() {
        BackButton.handleBackButton("menuScene");
    }
}