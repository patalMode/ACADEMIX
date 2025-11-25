package com.adxnew;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.animation.ScaleTransition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class CribSheetController {
    private Map<Button, String> originalColors = new HashMap<>();
    private Map<Button, ScaleTransition> activeTransitions = new HashMap<>();
    private Map<String, Image> buttonImages = new HashMap<>();

    @FXML private Button backButton;
    @FXML private AnchorPane mainPane;

    private Stage previewStage;
    private StackPane previewContainer;
    private ImageView previewImage;

    @FXML
    private void initialize() {
        if (mainPane != null) {
            try {
                loadPreviewImages();
                setupPreviewStage();
                
                getAllButtons().forEach(button -> {
                    String color = button.getStyle().replaceAll(".*-fx-background-color: ([^;]+).*", "$1");
                    originalColors.put(button, color);
                    setupButtonHoverEffect(button);
                });
            } catch (Exception e) {
                System.err.println("Error in initialize: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    private void setupPreviewStage() {
        previewStage = new Stage(StageStyle.TRANSPARENT);
        previewStage.setAlwaysOnTop(true);
        
        previewImage = new ImageView();
        previewImage.setFitHeight(500);
        previewImage.setFitWidth(500);
        
        previewContainer = new StackPane(previewImage);
        previewContainer.setStyle("-fx-background-color: transparent;");
        
        Scene previewScene = new Scene(previewContainer);
        previewScene.setFill(null);
        previewStage.setScene(previewScene);
    }

    private void loadPreviewImages() {
        String[] topics = {
            "ALGEBRA", "POLYNOMIALS", "GEOMETRY", 
            "COMPARISON", "QUADRATIC EQUATION", "FRACTIONS", 
            "PROBABILITY", "TRIGONOMETRY", "RATIOS"
        };
        
        for (String topic : topics) {
            try {
                String fileName = topic.toLowerCase().replace(" ", "_");
                String imagePath = "/com/adxnew/resources/" + fileName + ".png";
                Image image = new Image(getClass().getResourceAsStream(imagePath));
                
                if (!image.isError()) {
                    buttonImages.put(topic, image);
                }
            } catch (Exception e) {
                System.err.println("Failed to load image for: " + topic);
            }
        }
    }

    private void updatePreviewPosition(double mouseX, double mouseY) {
        boolean isRightSide = mouseX > mainPane.getWidth() * 0.7;
        double padding = 20;

        double screenX = mainPane.localToScreen(mouseX, mouseY).getX();
        double screenY = mainPane.localToScreen(mouseX, mouseY).getY();

        double stageX;
        if (isRightSide) {
            stageX = screenX - previewImage.getFitWidth() - padding;
        } else {
            stageX = screenX + padding;
        }
        
        double stageY = screenY - (previewImage.getFitHeight() / 2);

        previewStage.setX(stageX);
        previewStage.setY(stageY);
    }

    @SuppressWarnings("unused")
    private void setupButtonHoverEffect(Button button) {
        DropShadow glow = new DropShadow();
        glow.setColor(Color.WHITE);
        glow.setRadius(20);
    
        button.setOnMouseEntered(e -> {
            if (activeTransitions.containsKey(button)) {
                activeTransitions.get(button).stop();
            }
    
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);
            scaleTransition.setToX(1.1);
            scaleTransition.setToY(1.1);
            
            button.setStyle(button.getStyle().replace(
                originalColors.get(button), "#e3fc00"
            ));
            button.setEffect(glow);
    
            String buttonText = button.getText().trim();
            Image buttonImage = buttonImages.get(buttonText);
            if (buttonImage != null) {
                previewImage.setImage(buttonImage);
                previewStage.show();
                updatePreviewPosition(e.getSceneX(), e.getSceneY());
            }
        });
    
        button.setOnMouseMoved(e -> {
            if (previewStage.isShowing()) {
                updatePreviewPosition(e.getSceneX(), e.getSceneY());
            }
        });

        button.setOnMouseMoved(e -> {
            if (previewStage.isShowing()) {
                updatePreviewPosition(e.getSceneX(), e.getSceneY());
            }
        });

        button.setOnMouseExited(e -> {
            if (activeTransitions.containsKey(button)) {
                activeTransitions.get(button).stop();
            }

            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);
            scaleTransition.setToX(1.0);
            scaleTransition.setToY(1.0);
            
            button.setStyle(button.getStyle().replace(
                "#e3fc00", originalColors.get(button)
            ));
            button.setEffect(null);
            previewStage.hide();
            
            scaleTransition.play();
            activeTransitions.put(button, scaleTransition);
        });
    }


    private List<Button> getAllButtons() {
        return mainPane.getChildren().stream()
                .filter(node -> node instanceof Button && node != backButton)
                .map(node -> (Button) node)
                .collect(Collectors.toList());
    }

    @FXML
    private void handleBackButton() {
        BackButton.handleBackButton("mathScene");
    }
}