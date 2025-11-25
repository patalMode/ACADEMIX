// SSController.java
package com.adxnew;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SSController {
    @FXML private Button backButton;
    @FXML private AnchorPane mainPane;
    @FXML private ImageView sunImage;
    @FXML private ImageView mercuryImage;
    @FXML private ImageView venusImage;
    @FXML private ImageView earthImage;
    @FXML private ImageView marsImage;
    @FXML private ImageView jupiterImage;
    @FXML private ImageView saturnImage;
    @FXML private ImageView uranusImage;
    @FXML private ImageView neptuneImage;

    private Label descriptionLabel;

    @FXML
    private void initialize() {
        setupDescriptionLabel();
        setupPlanetHoverEffects();
    }

    private void setupDescriptionLabel() {
        descriptionLabel = new Label();
        descriptionLabel.setTextFill(Color.WHITE);
        descriptionLabel.setFont(Font.font("Calibri", 14));
        descriptionLabel.setStyle("-fx-background-color: rgba(0,0,0,0.7); -fx-padding: 5px;");
        descriptionLabel.setWrapText(true); 
        descriptionLabel.setPrefWidth(300); 
        descriptionLabel.setLineSpacing(5); 
        descriptionLabel.setVisible(false);
        mainPane.getChildren().add(descriptionLabel);
    }

    private void setupPlanetHoverEffects() {
        setupPlanetHover(sunImage, "The Sun: Our star, a massive ball of hydrogen and helium fusion, generating immense energy through nuclear reactions. It's 109 times wider than Earth and provides heat and light for our entire solar system.", false);
        setupPlanetHover(mercuryImage, "Mercury: The smallest planet, closest to the Sun. Its surface is heavily cratered, experiences extreme temperature variations from -180°C to 430°C, and has no atmosphere. A Mercury year is just 88 Earth days long.", false);
        setupPlanetHover(venusImage, "Venus: Often called Earth's 'sister planet' due to similar size, but with a toxic atmosphere of carbon dioxide and sulfuric acid clouds. It's the hottest planet, with surface temperatures reaching 462°C, hotter than Mercury despite being further from the Sun.", false);
        setupPlanetHover(earthImage, "Earth: Our home planet, the only known world supporting complex life. Covered 71% by liquid water, with a protective atmosphere, diverse ecosystems, and unique features like plate tectonics. It's the only planet not named after a Greek or Roman deity.", false);
        setupPlanetHover(marsImage, "Mars: The 'Red Planet' with rusty iron-rich surface. Home to the largest volcano (Olympus Mons) and canyon (Valles Marineris) in the solar system. NASA rovers have explored its surface, searching for signs of past or present microbial life.", false);
        setupPlanetHover(jupiterImage, "Jupiter: The largest planet, a gas giant with a Great Red Spot storm larger than Earth. It has 79 known moons, including Europa, which might harbor a subsurface ocean. Its massive magnetic field is 14 times stronger than Earth's.", false);
        setupPlanetHover(saturnImage, "Saturn: Famous for its spectacular ring system composed of ice, rock, and dust particles. It's the least dense planet in our solar system - so light it would float in water. Saturn has 82 known moons, including Titan, with its own atmosphere.", false);
        setupPlanetHover(uranusImage, "Uranus: A unique ice giant that rotates on its side, causing extreme seasonal variations. Its blue-green color comes from methane in its atmosphere. It was the first planet discovered using a telescope, by William Herschel in 1781.", true);
        setupPlanetHover(neptuneImage, "Neptune: The windiest planet, with surface winds reaching up to 2,100 km/h - the fastest in the solar system. It has a dynamic atmosphere with massive storm systems and was the first planet located through mathematical calculations rather than direct observation.", true);
    }

    @SuppressWarnings("unused")
    private void setupPlanetHover(ImageView planetImage, String description, boolean showLeft) {
        planetImage.setOnMouseEntered(e -> {
            planetImage.setScaleX(1.2);
            planetImage.setScaleY(1.2);
            descriptionLabel.setText(description);
            descriptionLabel.setVisible(true);
            double xOffset = showLeft ? -descriptionLabel.getWidth() - 10 : 10;
            descriptionLabel.setLayoutX(e.getSceneX() + xOffset);
            descriptionLabel.setLayoutY(e.getSceneY() + 10);
        });
    
        planetImage.setOnMouseMoved(e -> {
            double xOffset = showLeft ? -descriptionLabel.getWidth() - 10 : 10;
            descriptionLabel.setLayoutX(e.getSceneX() + xOffset);
            descriptionLabel.setLayoutY(e.getSceneY() + 10);
        });
    
        planetImage.setOnMouseExited(e -> {
            planetImage.setScaleX(1.0);
            planetImage.setScaleY(1.0);
            descriptionLabel.setVisible(false);
        });
    }

    @FXML
    private void handleBackButton() {
        SceneController.getInstance().switchToScene("sciScene");
    }
}