package com.adxnew;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuController {
    @SuppressWarnings("unused")
    private Stage stage;

    public void setStage(Stage stage) {

        this.stage = stage;

    }
    
    @FXML
    public void initialize() {
        Platform.runLater(() -> {

            ImageView[] images = {
                book, book2, paint,
                cal, glass, bag,
                book1, book3, book4,
                book5, book6, book7,
                book8, gamit
            };

            for (ImageView img : images) {
                if (img != null) {
                    ImageMovement.applyRandomMovement(img);
                } else {
                    System.out.println("Warning: Found null ImageView");
                }
            }
        });
    }

    @FXML private ImageView book;
    @FXML private ImageView gamit;
    @FXML private ImageView book2;
    @FXML private ImageView paint;
    @FXML private ImageView cal;
    @FXML private ImageView glass;
    @FXML private ImageView bag;
    @FXML private ImageView book1;
    @FXML private ImageView book3;
    @FXML private ImageView book4;
    @FXML private ImageView book5;
    @FXML private ImageView book6;
    @FXML private ImageView book7;
    @FXML private ImageView book8;

    @FXML private Button langButton;
    @FXML private Button mathButton;
    @FXML private Button othersButton;
    @FXML private Button sciButton;

    @FXML
    void switchToScene(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String sceneName = sourceButton.getId().replace("Button", "Scene");
        SceneController.getInstance().switchToScene(sceneName);
    }

    @FXML
    void handleSos(ActionEvent event) {
        SceneController.getInstance().switchToScene("hotlineScene");
    }
}
