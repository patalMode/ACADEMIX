// CalculatorController.java
package com.adxnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML private TextField display;
    private String currentNumber = "";
    private String operator = "";
    private double result = 0;
    private boolean startNewNumber = true;

    @FXML
    private void handleNumber(ActionEvent event) {
        if (startNewNumber) {
            display.setText("");
            startNewNumber = false;
        }
        Button button = (Button) event.getSource();
        String value = button.getText();
        display.setText(display.getText() + value);
        currentNumber += value;
    }

    @FXML
    private void handleOperator(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (!currentNumber.isEmpty()) {
            if (operator.isEmpty()) {
                result = Double.parseDouble(currentNumber);
            } else {
                calculate();
            }
            operator = button.getText();
            startNewNumber = true;
            currentNumber = "";
        }
    }

    @FXML
    private void handleEqual(ActionEvent event) {
        if (!currentNumber.isEmpty() && !operator.isEmpty()) {
            calculate();
            operator = "";
            currentNumber = String.valueOf(result);
            startNewNumber = true;
        }
    }
    private void resetCalculator() {
        display.setText("");
        currentNumber = "";
        operator = "";
        result = 0;
        startNewNumber = true;
    }

    @FXML
    private void handleClear(ActionEvent event) {
        resetCalculator();
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        resetCalculator();

        SceneController.getInstance().switchToScene("mathScene");
    }

    private void calculate() {
        double secondNumber = Double.parseDouble(currentNumber);
        switch (operator) {
            case "+": result += secondNumber; break;
            case "-": result -= secondNumber; break;
            case "×": result *= secondNumber; break;
            case "÷": 
                if (secondNumber != 0) {
                    result /= secondNumber;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }
        display.setText(String.valueOf(result));
    }
}