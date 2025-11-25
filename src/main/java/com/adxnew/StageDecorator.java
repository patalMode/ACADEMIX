package com.adxnew;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StageDecorator {
    private double xOffset = 0;
    private double yOffset = 0;

    private HBox createCustomTitleBar(Stage stage) {
        HBox titleBar = new HBox();
        titleBar.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-padding: 10px;"
        );
        titleBar.setAlignment(Pos.CENTER_RIGHT);

        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button minimizeButton = createTitleBarButton("minimize-icon.png", () -> stage.setIconified(true));

        Button exitButton = createTitleBarButton("close-icon.png", () -> stage.close());

        titleBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        
        titleBar.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
            
        titleBar.getChildren().addAll(spacer, minimizeButton, exitButton);
            
        return titleBar;
    }
        
    @SuppressWarnings("unused")
    private Button createTitleBarButton(String iconPath, Runnable action) {
        Button button = new Button();
        button.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-padding: 5px;" +
            "-fx-background-radius: 5px;"
        );
            
        try {
            String iconFile = iconPath.contains("minimize") ? "minimize-icon.png" : "cross-button.png";
            Image icon = new Image(getClass().getResourceAsStream("/com/adxnew/resources/PNGS/" + iconFile));
            ImageView iconView = new ImageView(icon);
            iconView.setFitWidth(20);
            iconView.setFitHeight(20);
            button.setGraphic(iconView);
        } catch (Exception e) {
            if (iconPath.contains("minimize")) {
                button.setText("−");
                button.setStyle(button.getStyle() + "-fx-font-size: 16px;");
            } else {
                button.setText("×");
                button.setStyle(button.getStyle() + "-fx-font-size: 18px;");
            }
        }
        
        button.setOnAction(e -> action.run());
            
        return button;
    }

    public void decorateStage(Stage stage, Scene scene) {

        HBox titleBar = createCustomTitleBar(stage);
        VBox root = new VBox();
        root.getChildren().addAll(titleBar, scene.getRoot());
        

        Scene decoratedScene = new Scene(root);
        decoratedScene.setFill(null);
        root.setStyle(
            "-fx-background-color: #525252;" +
            "-fx-background-radius: 20;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 0);"
        );
        
        stage.setScene(decoratedScene);
    }
}