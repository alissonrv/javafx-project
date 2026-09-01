package javafxproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxproject.HelloApplication;
import java.io.IOException;

public class CadastrarLivroController {

    @FXML public void voltarMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MenuView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 680);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}