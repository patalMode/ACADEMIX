package com.adxnew;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    private HBox topBar; 

    @SuppressWarnings("unused")
    private ImageView createTopBarButton(String imagePath, double size, Runnable action) {
        ImageView button = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        button.setFitHeight(size);
        button.setFitWidth(size);

        button.setStyle("-fx-cursor: hand;");
        button.setOnMouseEntered(e -> button.setOpacity(0.8));
        button.setOnMouseExited(e -> button.setOpacity(1.0));

        button.setOnMouseClicked(e -> {
            button.setOpacity(0.6);
            action.run();
        });
        
        return button;
    }

    private HBox createTopBar(Stage stage) {
        topBar = new HBox(10); 
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.setStyle("-fx-background-color: transparent; -fx-padding: 5;");
        topBar.setPrefHeight(30);

        ImageView minimizeBtn = createTopBarButton(
            "/com/adxnew/resources/PNGS/minimize-icon.png",
            24,
            () -> {
                if (stage != null) stage.setIconified(true);
            }
        );

        ImageView exitBtn = createTopBarButton(
            "/com/adxnew/resources/PNGS/cross-button.png",
            24,
            () -> Platform.exit()
        );

        topBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        
        topBar.setOnMouseDragged(event -> {
            if (stage != null) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

        topBar.getChildren().addAll(minimizeBtn, exitBtn);
        return topBar;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        java.io.InputStream iconStream = getClass().getResourceAsStream("/com/adxnew/resources/icons/ACADEMIX_ICON.png");
        if (iconStream == null) {
            // fallback to .ico if png not present
            iconStream = getClass().getResourceAsStream("/com/adxnew/resources/icons/ACADEMIX_ICON.ico");
        }
        if (iconStream != null) {
            primaryStage.getIcons().add(new Image(iconStream));
        } else {
            System.err.println("Warning: application icon not found in resources/com/adxnew/resources/icons");
        }
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        VBox mainLayout = new VBox();
        mainLayout.setStyle("-fx-background-color: #525252;" +
                            "-fx-background-radius: 20;"+
                            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 0);");

        topBar = createTopBar(primaryStage);
        topBar.setViewOrder(-1.0);  
        topBar.setStyle(topBar.getStyle() + 
                        "-fx-background-color: #424242;" +
                        "-fx-padding: 5;" +
                        "-fx-background-radius: 20 20 0 0;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 0);" +
                        "-fx-z-index: 999;");    
        mainLayout.getChildren().add(topBar);

        SceneController sceneController = SceneController.getInstance();
        sceneController.setStage(primaryStage);
        sceneController.setMainLayout(mainLayout);
        sceneController.setTopBar(topBar);
        sceneController.loadScenes();
        
        Scene mainScene = new Scene(mainLayout);
        mainScene.setFill(null);
        primaryStage.setScene(mainScene);
        
        sceneController.switchToScene("opScene");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}