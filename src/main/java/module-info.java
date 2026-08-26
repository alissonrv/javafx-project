module com.example.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens javafxproject to javafx.fxml;
    opens javafxproject.controller to javafx.fxml;
    exports javafxproject;
}