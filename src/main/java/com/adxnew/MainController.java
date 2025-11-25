package com.adxnew;

import javafx.application.Platform; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController {
    @SuppressWarnings("unused")
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML private ImageView book4;
    @FXML private ImageView book5;
    @FXML private ImageView book6;
    @FXML private ImageView book7;
    @FXML private ImageView book8;
    @FXML private ImageView cal;
    @FXML private Button exitButton;
    @FXML private ImageView gamit;
    @FXML private ImageView glass;
    @FXML private ImageView paint;
    @FXML private Button menuButton;
    
    @FXML
    void switchToScene(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        if (sourceButton == menuButton) {
            SceneController.getInstance().switchToScene("aboutScene");
        }
    }

    @FXML
    void exitProgram(ActionEvent event) {
        Platform.exit(); 
    }
}