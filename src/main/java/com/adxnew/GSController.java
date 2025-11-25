package com.adxnew;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class GSController {
    @FXML private TextField optionField;
    @FXML private StackPane gradeSystemsPane;
    @FXML private VBox computePanel;
    @FXML private VBox convertPanel;
    @FXML private TextField subjectCountField;
    @FXML private GridPane gradesPanel;
    @FXML private Label computeResult;
    @FXML private TextField gradeField;
    @FXML private Label convertResult;
    

    @FXML
    private void showComputePanel() {
        computePanel.setVisible(true);
        convertPanel.setVisible(false);
    }

    @FXML
    private void showConvertPanel() {
        computePanel.setVisible(false);
        convertPanel.setVisible(true);
    }


    @FXML
    private void calculateGrade() {
        try {
            int count = Integer.parseInt(subjectCountField.getText());
            if (count < 5 || count > 10) {
                showAlert("Please enter between 5 and 10 subjects.");
                return;
            }

            setupGradesPanel(count);
        } catch (NumberFormatException e) {
            showAlert("Please enter a valid number.");
        }
    }

    private void setupGradesPanel(int count) {
        gradesPanel.getChildren().clear();
        for (int i = 0; i < count; i++) {
            gradesPanel.add(new Label("Subject " + (i+1) + ":"), 0, i);
            gradesPanel.add(new TextField(), 1, i);
        }
    }

    @FXML
    private void convertGrade() {
        try {
            double grade = Double.parseDouble(gradeField.getText());
            double gpa;
            
            if (grade >= 90) gpa = 4.0;
            else if (grade >= 80) gpa = 3.0;
            else if (grade >= 70) gpa = 2.0;
            else if (grade >= 60) gpa = 1.0;
            else gpa = 0.0;
            
            convertResult.setText(String.format("GPA: %.1f", gpa));
        } catch (NumberFormatException e) {
            showAlert("Please enter a valid grade.");
        }
    }

    @FXML
    private void handleBackButton() {
        try {
            if (optionField != null) optionField.setText("");
            if (subjectCountField != null) subjectCountField.setText("");
            if (gradeField != null) gradeField.setText("");

            if (computeResult != null) computeResult.setText("");
            if (convertResult != null) convertResult.setText("");

            if (gradesPanel != null) {
                try {
                    gradesPanel.getChildren().clear();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            if (computePanel != null) computePanel.setVisible(false);
            if (convertPanel != null) convertPanel.setVisible(false);

            SceneController.getInstance().switchToScene("mathScene");
            
        } catch (Exception e) {
            System.out.println("Error during back button operation: " + e.getMessage());

            SceneController.getInstance().switchToScene("mathScene");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}