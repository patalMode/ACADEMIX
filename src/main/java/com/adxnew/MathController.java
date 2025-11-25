package com.adxnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MathController {
    @FXML private Button calcButton;
    @FXML private Button fibButton;
    @FXML private Button gradeButton;
    @FXML private Button bmiButton;
    @FXML private Button backButton;
    

    @FXML
    private void handleCalcButton(ActionEvent event) {
        try {
            SceneController.getInstance().switchToScene("calculatorScene");
        } catch (Exception e) {
            System.err.println("Failed to switch to calculator scene: " + e.getMessage());
        }
    }

    @FXML
    private void handleFibButton() {
        try {
            SceneController.getInstance().switchToScene("fibonacciScene");
        } catch (Exception e) {
            System.err.println("Failed to switch to fibonacci scene: " + e.getMessage());
        }
    }

    @FXML
    private void handleGradeButton() {
        try {
            SceneController.getInstance().switchToScene("GSScene");
        } catch (Exception e) {
            System.err.println("Failed to switch to grade scene: " + e.getMessage());
        }
    }

    @FXML
    private void handleBmiButton() {
        try {
            SceneController.getInstance().switchToScene("bmiScene");
        } catch (Exception e) {
            System.err.println("Failed to switch to grade scene: " + e.getMessage());
        }
    }
    @FXML
    private void handleCribButton() {
        try {
            SceneController.getInstance().switchToScene("cribScene");
        } catch (Exception e) {
            System.err.println("Failed to switch to crib scene: " + e.getMessage());
        }
    }
    

    @FXML
    private void handleBackButton() {
        BackButton.handleBackButton("menuScene");
    }
}