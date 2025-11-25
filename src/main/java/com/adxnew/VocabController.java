package com.adxnew;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class VocabController {
    @FXML private Button prevButton;
    @FXML private Button nextButton;
    @FXML private Button addButton;
    @FXML private Button deleteButton;
    @FXML private Button backButton;
    
    @FXML private Label cardNumber;
    @FXML private Label frontLabel;
    @FXML private Label backLabel;
    @FXML private VBox cardFront;
    @FXML private VBox cardBack;
    @FXML private StackPane cardContainer;
    
    private boolean isFlipped = false;
    private RotateTransition rotator;
    private List<Flashcard> flashcards;
    private int currentCardIndex = 0;

    private class Flashcard {
        String front;
        String back;
        
        public Flashcard(String front, String back) {
            this.front = front;
            this.back = back;
        }
    }

    @FXML
    private void initialize() {
        setupCards();
        setupCardFlip();
        setupButtons();
        updateCard();
    }

    @SuppressWarnings("unused")
    private void setupButtons() {
        Arrays.asList(prevButton, nextButton, deleteButton, backButton).forEach(button -> {
            button.getStyleClass().add("menu-button");
            button.setStyle("-fx-background-color: #85ccc7;");
        });
        
        nextButton.setOnAction(e -> nextCard());
        prevButton.setOnAction(e -> previousCard());
        deleteButton.setOnAction(e -> handleDeleteCard());
        addButton.setOnAction(e -> handleAddCard());
    }
    
    private void setupCardFlip() {
        rotator = new RotateTransition(Duration.millis(600), cardContainer);
        rotator.setAxis(Rotate.Y_AXIS);
        rotator.setCycleCount(1);

        backLabel.setRotate(180);
        backLabel.setScaleY(-1);
        
        cardContainer.setOnMouseClicked(e -> {
            if (e.getTarget() == cardContainer || 
                e.getTarget() == cardFront || 
                e.getTarget() == cardBack || 
                e.getTarget() == frontLabel ||
                e.getTarget() == backLabel) {
                flipCard();
            }
        });
    }

    private void setupCards() {
        // TO ADD NEW CARDS: Add new Flashcard entries here
        flashcards = new ArrayList<>(Arrays.asList(
            new Flashcard("Consider", "deem to be"),
            new Flashcard("Minute", "infinite"),
            new Flashcard("Accord", "concurrence of opinion"),
            new Flashcard("Evident", "clearly revealed to the mind or the senses or judgment"),
            new Flashcard("Practice", "a customary way of operation or behavior"),
            new Flashcard("Intend", "have in mind as a purpose"),
            new Flashcard("Concern", "something that interests you because it is important"),
            new Flashcard("Commit", "perform an act, usually with a negative connotation"),
            new Flashcard("Issue", "some situation or event that is thought about"),
            new Flashcard("Approach", "move towards"),
            new Flashcard("Establish", "set up or found"),
            new Flashcard("Utter", "without qualification"),
            new Flashcard("Conduct", "direct the course of; manage or control"),
            new Flashcard("Engage", "consume all of one's attention or time"),
            new Flashcard("Obtain", "come into possession of"),
            new Flashcard("Scarce", "deficient in quantity or number compared with the demand"),
            new Flashcard("Policy", "a plan of action adopted by an individual or social group"),
            new Flashcard("Straight", "successive, without a break"),
            new Flashcard("Stock", "capital raised by a corporation through the issue of shares"),
            new Flashcard("Apparent", "clearly revealed to the mind or the senses or judgment"),
            new Flashcard("Property", "a basic or essential attribute shared by members of a class"),
            new Flashcard("Fancy", "imagine; conceive of; see in one's mind"),
            new Flashcard("Concept", "an abstract or general idea inferred from specific instances"),
            new Flashcard("Court", "an assembly to conduct judicial business"),
            new Flashcard("Appoint", "assign a duty, responsibility, or obligation to"),
            new Flashcard("Passage", "a section of text, particularly a section of medium length"),
            new Flashcard("Vain", "unproductive of success"),
            new Flashcard("Instance", "an occurrence of something"),
            new Flashcard("Coast", "the shore of a sea or ocean"),
            new Flashcard("Project", "a planned undertaking"),
            new Flashcard("Commission", "a special group delegated to consider some matter"),
            new Flashcard("Constant", "a quantity that does not vary"),
            new Flashcard("Circumstances", "one's overall condition in life"),
            new Flashcard("Constitute", "compose or represent"),
            new Flashcard("Level", "a relative position or degree of value in a graded group"),
            new Flashcard("Affect", "have an influence upon"),
            new Flashcard("Institute", "set up or lay the groundwork for"),
            new Flashcard("Render", "give an interpretation of"),
            new Flashcard("Appeal", "be attractive to"),
            new Flashcard("Generate", "bring into existence"),
            new Flashcard("Theory", "a well-substantiated explanation of some aspect of the world"),
            new Flashcard("Range", "a variety of different things or activities"),
            new Flashcard("Campaign", "a race between candidates for elective office"),
            new Flashcard("League", "an association of sports teams that organizes matches"),
            new Flashcard("Labor", "any piece of work that is undertaken or attempted"),
            new Flashcard("Confer", "have a meeting in order to talk something over"),
            new Flashcard("Grant", "allow to have"),
            new Flashcard("Dwell", "think moodily or anxiously about something"),
            new Flashcard("Entertain", "provide amusement for"),
            new Flashcard("Contract", "a binding agreement that is enforceable by law"),
            new Flashcard("Earnest", "characterized by a firm, sincere belief in one's opinions"),
            new Flashcard("Yield", "give or supply"),
            new Flashcard("Wander", "move or cause to move in a sinuous or circular course"),
            new Flashcard("Insist", "be emphatic or resolute and refuse to budge"),
            new Flashcard("Knight", "a person of noble birth trained to arms and chivalry"),
            new Flashcard("Convince", "make realize the truth or validity of something"),
            new Flashcard("Inspire", "serve as the inciting cause of"),
            new Flashcard("Convention", "a large formal assembly"),
            new Flashcard("Skill", "an ability that has been acquired by training"),
            new Flashcard("Harry", "annoy continually or chronically"),
            new Flashcard("Financial", "involving fiscal matters"),
            new Flashcard("Reflect", "show an image of"),
            new Flashcard("Novel", "an extended fictional work in prose"),
            new Flashcard("Furnish", "provide with objects or articles that make a room usable"),
            new Flashcard("Compel", "force somebody to do something"),
            new Flashcard("Venture", "proceed somewhere despite the risk of possible dangers"),
            new Flashcard("Territory", "the geographical area under the jurisdiction of a state"),
            new Flashcard("Temper", "a characteristic state of feeling"),
            new Flashcard("Bent", "fixed in your purpose"),
            new Flashcard("Intimate", "marked by close acquaintance, association, or familiarity"),
            new Flashcard("Undertake", "enter upon an activity or enterprise"),
            new Flashcard("Majority", "more than half of the votes in an election"),
            new Flashcard("Assert", "declare or affirm solemnly and formally as true"),
            new Flashcard("Crew", "the people who work on a vehicle"),
            new Flashcard("Chamber", "a natural or artificial enclosed space"),
            new Flashcard("Humble", "marked by meekness or modesty; not arrogant or prideful"),
            new Flashcard("Scheme", "an elaborate and systematic plan of action"),
            new Flashcard("Keen", "demonstrating ability to recognize or draw fine distinctions"),
            new Flashcard("Liberal", "having political views favoring reform and progress"),
            new Flashcard("Despair", "a state in which all hope is lost or absent"),
            new Flashcard("Tide", "the periodic rise and fall of the sea level"),
            new Flashcard("Attitude", "a complex mental state involving beliefs and feelings"),
            new Flashcard("Justify", "show to be reasonable or provide adequate ground for"),
            new Flashcard("Flag", "a rectangular piece of cloth of distinctive design"),
            new Flashcard("Merit", "any admirable or beneficial attribute"),
            new Flashcard("Manifest", "reveal its presence or make an appearance"),
            new Flashcard("Notion", "a general inclusive concept"),
            new Flashcard("Scale", "relative magnitude"),
            new Flashcard("Formal", "characteristic of or befitting a person in authority"),
            new Flashcard("Resource", "a new or reserve supply that can be drawn upon when needed"),
            new Flashcard("Persist", "continue to exist"),
            new Flashcard("Contempt", "lack of respect accompanied by a feeling of intense dislike"),
            new Flashcard("Tour", "a route all the way around a particular place or area"),
            new Flashcard("Plead", "enter a defendant's answer"),
            new Flashcard("Weigh", "be oppressive or burdensome"),
            new Flashcard("Mode", "how something is done or how it happens"),
            new Flashcard("Distinction", "a discrimination between things as different"),
            new Flashcard("Inclined", "at an angle to the horizontal or vertical position"),
            new Flashcard("Attribute", "a quality belonging to or characteristic of an entity"),
            new Flashcard("Exert", "make a great effort at a mental or physical task")
        ));
    }

    @SuppressWarnings("unused")
    private void flipCard() {
        isFlipped = !isFlipped;
        
        rotator.setFromAngle(isFlipped ? 0 : 180);
        rotator.setToAngle(isFlipped ? 180 : 360);
        
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.millis(300), e -> {
                cardFront.setVisible(!isFlipped);
                cardBack.setVisible(isFlipped);
            })
        );
        
        rotator.setOnFinished(e -> {
            if (!isFlipped) {
                cardContainer.setRotate(0);
            }
        });
        
        timeline.play();
        rotator.play();
    }

    private void updateCard() {
        Flashcard current = flashcards.get(currentCardIndex);
        frontLabel.setText(current.front);
        backLabel.setText(current.back);
        cardNumber.setText(String.format("Card %d/%d", currentCardIndex + 1, flashcards.size()));
    }

    private void nextCard() {
        if (currentCardIndex < flashcards.size() - 1) {
            currentCardIndex++;
            if (isFlipped) {
                isFlipped = false;
                cardContainer.setRotate(0);
                cardFront.setVisible(true);
                cardBack.setVisible(false);
            }
            updateCard();
        }
    }
    
    private void previousCard() {
        if (currentCardIndex > 0) {
            currentCardIndex--;
            if (isFlipped) {
                isFlipped = false;
                cardContainer.setRotate(0);
                cardFront.setVisible(true);
                cardBack.setVisible(false);
            }
            updateCard();
        }
    }


    private void handleDeleteCard() {
        if (flashcards.isEmpty()) {
            return;
        }

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Delete Card");
        confirmation.setHeaderText("Delete Current Card");
        confirmation.setContentText("Are you sure you want to delete this card?");

        DialogPane dialogPane = confirmation.getDialogPane();
        dialogPane.setStyle("-fx-background-color: white;");
        dialogPane.getStyleClass().add("custom-alert");
        dialogPane.getButtonTypes().forEach(buttonType -> {
            Button button = (Button) dialogPane.lookupButton(buttonType);
            button.getStyleClass().add("menu-button");
            button.setStyle("-fx-background-color: #85ccc7;");
        });
        
        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            deleteCurrentCard();
        }
    }
    
    private void deleteCurrentCard() {
        if (!flashcards.isEmpty()) {
            flashcards.remove(currentCardIndex);
            
            if (flashcards.isEmpty()) {
                frontLabel.setText("No cards available");
                backLabel.setText("");
                cardNumber.setText("Card 0/0");
                currentCardIndex = 0;
            } else {
                if (currentCardIndex >= flashcards.size()) {
                    currentCardIndex = flashcards.size() - 1;
                }
                if (isFlipped) {
                    isFlipped = false;
                    cardContainer.setRotate(0);
                    cardFront.setVisible(true);
                    cardBack.setVisible(false);
                    backLabel.setScaleX(-1);
                }
                updateCard();
            }
        }
    }
    @SuppressWarnings("unused")
    private void handleAddCard() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add New Flashcard");
        dialog.setHeaderText("Enter a new word and its definition");

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #525252;");
        dialogPane.getStyleClass().add("custom-alert");

        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialogPane.getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        dialogPane.lookupButton(addButtonType).getStyleClass().add("menu-button");
        dialogPane.lookupButton(addButtonType).setStyle("-fx-background-color: #85ccc7;");
        dialogPane.lookupButton(ButtonType.CANCEL).getStyleClass().add("menu-button");
        dialogPane.lookupButton(ButtonType.CANCEL).setStyle("-fx-background-color: #85ccc7;");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        
        TextField wordField = new TextField();
        wordField.setPromptText("Enter word");
        TextField definitionField = new TextField();
        definitionField.setPromptText("Enter definition (max 10 words)");
        
        grid.add(new Label("Word:"), 0, 0);
        grid.add(wordField, 1, 0);
        grid.add(new Label("Definition:"), 0, 1);
        grid.add(definitionField, 1, 1);

        grid.getChildren().filtered(node -> node instanceof Label)
            .forEach(node -> ((Label)node).setStyle("-fx-text-fill: white;"));
        
        dialog.getDialogPane().setContent(grid);

        Node addButton = dialog.getDialogPane().lookupButton(addButtonType);
        addButton.setDisable(true);
        
        wordField.textProperty().addListener((observable, oldValue, newValue) -> {
            addButton.setDisable(newValue.trim().isEmpty());
        });
        
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                String definition = definitionField.getText().trim();
                if (definition.split("\\s+").length > 10) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Definition too long");
                    alert.setContentText("Definition must be 10 words or less");
                    alert.getDialogPane().setStyle("-fx-background-color: #525252;");
                    alert.showAndWait();
                    return null;
                }
                return new Pair<>(wordField.getText(), definition);
            }
            return null;
        });
        
        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(pair -> {
            flashcards.add(new Flashcard(pair.getKey(), pair.getValue()));
            currentCardIndex = flashcards.size() - 1;
            updateCard();
        });
    }
    @FXML
    private void handleBackButton() {
        BackButton.handleBackButton("langScene");
    }
}