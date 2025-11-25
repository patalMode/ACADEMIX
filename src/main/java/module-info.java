module com.adxnew {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive javafx.media;
    
    exports com.adxnew;
    opens com.adxnew to javafx.fxml;
}