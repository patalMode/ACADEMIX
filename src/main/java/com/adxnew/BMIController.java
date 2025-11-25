package com.adxnew;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BMIController {
    @FXML private TextField heightField;
    @FXML private TextField weightField;
    @FXML private Label resultLabel;
    @FXML private Label categoryLabel;

    @FXML
    private void calculateBMI() {
        try {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double bmi = weight / (height * height);
            
            resultLabel.setText(String.format("BMI: %.2f", bmi));
            
            if (bmi < 18.5) {
                categoryLabel.setText("Underweight");
                categoryLabel.setTextFill(Color.YELLOW);
            } else if (bmi < 25) {
                categoryLabel.setText("Normal");
                categoryLabel.setTextFill(Color.GREEN);
            } else if (bmi < 30) {
                categoryLabel.setText("Overweight");
                categoryLabel.setTextFill(Color.ORANGE);
            } else {
                categoryLabel.setText("Obese");
                categoryLabel.setTextFill(Color.RED);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
            categoryLabel.setText("Please enter valid numbers");
        }
    }

    @FXML
    private void handleBackButton() {
        // Clear fields
        heightField.setText("");
        weightField.setText("");
        resultLabel.setText("");
        categoryLabel.setText("");
        // Switch scene
        SceneController.getInstance().switchToScene("mathScene");
    }
}