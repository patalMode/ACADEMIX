package com.adxnew;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

public class HotlineController {
    @FXML private Button fireButton;
    @FXML private Button medicButton;
    @FXML private Button disasterButton;
    @FXML private Button policeButton;
    
    @FXML private StackPane cardStack;
    @FXML private VBox firePanel;
    @FXML private VBox medicPanel;
    @FXML private VBox disasterPanel;
    @FXML private VBox policePanel;

    @FXML
    private void showPanel(ActionEvent event) {
        firePanel.setVisible(false);
        medicPanel.setVisible(false);
        disasterPanel.setVisible(false);
        policePanel.setVisible(false);

        Button sourceButton = (Button) event.getSource();
        switch(sourceButton.getId()) {
            case "fireButton":
                firePanel.setVisible(true);
                break;
            case "medicButton":
                medicPanel.setVisible(true);
                break;
            case "disasterButton":
                disasterPanel.setVisible(true);
                break;
            case "policeButton":
                policePanel.setVisible(true);
                break;
        }
    }

    @FXML
    private void handleBackButton() {
        firePanel.setVisible(false);
        medicPanel.setVisible(false);
        disasterPanel.setVisible(false);
        policePanel.setVisible(false);
        
        SceneController.getInstance().switchToScene("menuScene");
    }
}