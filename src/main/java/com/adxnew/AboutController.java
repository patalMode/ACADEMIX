package com.adxnew;

import javafx.fxml.FXML;

public class AboutController {    
    @FXML
    private void handleBackButton() {
        SceneController.getInstance().switchToScene("menuScene");
    }
}