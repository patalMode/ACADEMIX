package com.adxnew;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;

public class HealthController {
    @FXML private TextField exerField;
    @FXML private TextField sleepField;
    @FXML private TextField calorieField;
    
    @FXML private Label exerFeedback;
    @FXML private Label sleepFeedback;
    @FXML private Label calorieFeedback;
    
    @FXML private Button submitButton;
    @FXML private Button submitAgainButton;
    
    @FXML
    private void handleSubmit() {
        try {
            int exerciseDuration = Integer.parseInt(exerField.getText());
            double sleepHours = Double.parseDouble(sleepField.getText());
            int calorieIntake = Integer.parseInt(calorieField.getText());

            if (exerciseDuration < 30) {
                exerFeedback.setText("Consider increasing your exercise duration for better health.");
                exerFeedback.setTextFill(Color.web("#d13242"));
            } else {
                exerFeedback.setText("Great job on your exercise duration!");
                exerFeedback.setTextFill(Color.web("#41fa44"));
            }

            if (sleepHours < 7) {
                sleepFeedback.setText("Getting more sleep can improve your overall health.");
                sleepFeedback.setTextFill(Color.web("#d13242")); 
            } else {
                sleepFeedback.setText("You're getting a decent amount of sleep!");
                sleepFeedback.setTextFill(Color.web("#41fa44")); 
            }

            if (calorieIntake > 2500) {
                calorieFeedback.setText("Watch your calorie intake for better health.");
                calorieFeedback.setTextFill(Color.web("#d13242")); 
            } else {
                calorieFeedback.setText("You're doing well with your calorie intake!");
                calorieFeedback.setTextFill(Color.web("#41fa44")); 
            }

            submitButton.setVisible(false);
            submitAgainButton.setVisible(true);

        } catch (NumberFormatException ex) {
            showAlert("Please enter valid numbers for all fields.");
            resetForm();
        }
    }

    @FXML
    private void resetForm() {
        exerField.clear();
        sleepField.clear();
        calorieField.clear();
        
        exerFeedback.setText("");
        sleepFeedback.setText("");
        calorieFeedback.setText("");
        
        submitAgainButton.setVisible(false);
        submitButton.setVisible(true);
    }

    @FXML
    private void handleBackButton() {
        resetForm();
        
        SceneController.getInstance().switchToScene("sciScene");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}