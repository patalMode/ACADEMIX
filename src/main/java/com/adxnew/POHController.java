package com.adxnew;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

public class POHController {
    @FXML private Button earlyPeriodBtn;
    @FXML private Button spanishPeriodBtn;
    @FXML private Button nationalismPeriodBtn;
    @FXML private Button americanPeriodBtn;
    @FXML private Button japanesePeriodBtn;
    @FXML private Button republicPeriodBtn;
    
    @FXML private StackPane contentPane;
    @FXML private VBox periodContent;
    @FXML private Label periodTitle;
    @FXML private Label periodDescription;

    @FXML
    private void showPeriodContent(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        
        switch(sourceButton.getId()) {
            case "earlyPeriodBtn":
                updateContent("Early Philippines Period (22,000 BC - 1521 AD)",
                              "This era spans from the arrival of early settlers to the pre-colonial societies of the Philippines. Archaeological discoveries, such as the Tabon Man in Palawan, suggest human habitation as early as 22,000 BC. Early Filipinos lived in barangays led by datus and engaged in animism and ancestor worship. They developed advanced maritime skills, traded with China, India, and other Asian countries, and created art forms such as pottery and jewelry. The Laguna Copperplate Inscription (900 AD) evidences a sophisticated society with writing systems, commerce, and law.");
                break;
            case "spanishPeriodBtn":
                updateContent("Spanish Colonialism Period (1521-1898)",
                              "Spanish colonization began with Ferdinand Magellan's arrival in 1521, followed by Miguel López de Legazpi's expedition in 1565, establishing the first permanent settlement in Cebu. The Philippines was named in honor of King Philip II of Spain. This period introduced Christianity, feudal land systems (encomienda), and Spanish-inspired governance. Key infrastructure, such as Intramuros and baroque churches, was built. The Galleon Trade linked Manila to Acapulco, fostering economic activity. However, it also saw frequent uprisings, such as the 1744 Dagohoy Rebellion and the eventual Philippine Revolution in 1896.");
                break;
            case "nationalismPeriodBtn":
                updateContent("Period of Filipino Nationalism (1872-1913)",
                              "The seeds of Filipino nationalism emerged during the late Spanish period, fueled by injustices against Filipinos. The 1872 Cavite Mutiny and the execution of Gomburza priests ignited reformist and revolutionary movements. The Propaganda Movement led by José Rizal, Marcelo H. del Pilar, and Graciano López Jaena called for equality and representation. Rizal's novels, 'Noli Me Tangere' and 'El Filibusterismo,' exposed colonial abuses. The Katipunan, founded by Andres Bonifacio, spearheaded the Philippine Revolution (1896-1898), ultimately leading to the declaration of independence in 1898.");
                break;
            case "americanPeriodBtn":
                updateContent("American Colonialism Period (1898-1946)",
                              "The Treaty of Paris (1898) ended the Spanish-American War, transferring the Philippines to the U.S. The Philippine-American War followed, marked by Filipino resistance and heavy casualties. The Americans established a public school system, democratic governance, and infrastructure like roads and hospitals. English became the medium of instruction. Prominent leaders like Manuel L. Quezon worked toward autonomy, achieved with the 1935 Commonwealth Government. The Tydings-McDuffie Act paved the way for full independence, though World War II interrupted this progress.");
                break;
            case "japanesePeriodBtn":
                updateContent("Japanese Occupation Period (1941-1945)",
                              "World War II brought the Japanese invasion, resulting in harsh military rule. Manila was declared an open city to prevent destruction, but atrocities like the Bataan Death March occurred. Guerrilla resistance movements, such as the Hukbalahap, emerged. The Japanese tried to establish a puppet government under José P. Laurel, promoting Asian unity under their propaganda. Despite this, the Filipino spirit endured, with the eventual liberation by Allied forces in 1945, led by General Douglas MacArthur's 'I Shall Return' campaign.");
                break;
            case "republicPeriodBtn":
                updateContent("Period of the Philippine Republic (1946-present)",
                              "The Republic of the Philippines was formally established on July 4, 1946. Early independence saw efforts to recover from war devastation, followed by periods of economic growth and political challenges. Ferdinand Marcos declared martial law in 1972, leading to years of authoritarian rule and resistance. The People Power Revolution of 1986 restored democracy. Recent decades have been marked by economic globalization, technological advances, and cultural revitalization, while addressing issues like corruption, natural disasters, and regional development disparities.");
                break;
        }
    }

    private void updateContent(String title, String description) {
        periodTitle.setText(title);
        periodDescription.setText(description);
        periodContent.setVisible(true);
    }

    @FXML
    private void handleBackButton() {
        periodContent.setVisible(false);
        SceneController.getInstance().switchToScene("langScene");
    }
}