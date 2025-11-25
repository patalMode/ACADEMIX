package com.adxnew;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;
import java.io.IOException;
import java.net.URL;

public class SceneController {
    private static SceneController instance;
    private Stage stage;
    private VBox mainLayout;
    private HBox topBar;
    private HashMap<String, Scene> scenes = new HashMap<>();

    private SceneController() {}

    public static SceneController getInstance() {
        if (instance == null) {
            instance = new SceneController();
        }
        return instance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setTopBar(HBox topBar) {
        this.topBar = topBar;
    }

    public void setMainLayout(VBox mainLayout) {
        this.mainLayout = mainLayout;
    }



    public void loadScenes() {
        String[] sceneNames = {
            "opScene", "menuScene", "mathScene", 
            "sciScene", "langScene","calculatorScene", "fibonacciScene",
            "GSScene","bmiScene", "zElementScene", 
            "healthScene", "POHScene", "hotlineScene", "aboutScene",
            "vocabScene", "SSScene", "cribScene"
        };
    
        for (String sceneName : sceneNames) {
            try {
                String fxmlPath = "/com/adxnew/" + sceneName + ".fxml";
                System.out.println("Loading FXML: " + fxmlPath);
                
                URL resource = getClass().getResource(fxmlPath);
                if (resource == null) {
                    throw new IOException("Resource not found: " + fxmlPath);
                }
                
                FXMLLoader loader = new FXMLLoader(resource);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                scene.setFill(null);
                scenes.put(sceneName, scene);
                System.out.println("Successfully loaded: " + sceneName);
            } catch (IOException e) {
                System.err.println("Failed to load scene: " + sceneName);
                e.printStackTrace();
            }
        }
    }
    

    public void switchToScene(String sceneName) {
        Scene scene = scenes.get(sceneName);
        if (scene != null && mainLayout != null) {
            if ("zElementScene".equals(sceneName) || "SSScene".equals(sceneName)) {
                stage.setWidth(1250);
                stage.setHeight(800);
            } else {
                stage.setWidth(800);
                stage.setHeight(750);
            }
            stage.centerOnScreen();

            if (topBar != null) {
                topBar.setVisible(!"opScene".equals(sceneName));
            }

            if (mainLayout.getChildren().size() > 1) {
                mainLayout.getChildren().remove(1);
            }

            if ("cribScene".equals(sceneName)) {
                stage.setWidth(815);
                stage.setHeight(650);
                mainLayout.setStyle("-fx-background-color: #f8d463;" +
                                  "-fx-background-radius: 20;");
                if (topBar != null) {
                    topBar.setStyle("-fx-background-color: #f8d463;" +
                                   "-fx-padding: 5;" +
                                   "-fx-background-radius: 20 20 0 0;" +
                                   "-fx-z-index: 999;");
                }
            } else {
                mainLayout.setStyle("-fx-background-color: #525252;" +
                                  "-fx-background-radius: 20;" +
                                  "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 0);");
                if (topBar != null) {
                    topBar.setStyle("-fx-background-color: #424242;" +
                                   "-fx-padding: 5;" +
                                   "-fx-background-radius: 20 20 0 0;" +
                                   "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 0);" +
                                   "-fx-z-index: 999;");
                }
            }
    
            VBox.setVgrow(scene.getRoot(), null);
            mainLayout.getChildren().add(scene.getRoot());
        } else {
            System.err.println("Scene or stage not found: " + sceneName);
        }
    }
}