// FibonacciController.java
package com.adxnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class FibonacciController {
    @FXML private TextField inputField;
    @FXML private TextArea outputArea;
    @FXML private Label statusLabel;

    @FXML
    private void handleCalculate(ActionEvent event) {
        try {
            int n = Integer.parseInt(inputField.getText());

            if (n < 3) {
                statusLabel.setText("Please enter a number 3 or greater.");
                return;
            }

            long a = 0, b = 1, sum;
            StringBuilder result = new StringBuilder();
            result.append("First ").append(n).append(" Fibonacci numbers:\n");
            result.append(a).append("  ").append(b).append("  ");

            for (int i = 3; i <= n; i++) {
                sum = a + b;
                result.append(sum).append("  ");
                a = b;
                b = sum;
            }

            outputArea.setText(result.toString());
            statusLabel.setText("Fibonacci sequence generated successfully.");

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) {

        inputField.setText("");
        outputArea.setText("");
        statusLabel.setText("");

        SceneController.getInstance().switchToScene("mathScene");
    }
}