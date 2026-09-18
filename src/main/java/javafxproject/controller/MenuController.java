package javafxproject.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafxproject.HelloApplication;
import java.io.IOException;
import java.util.Optional;

public class MenuController {
    @FXML Button buttonCadastrarLivro,buttonCadastrarUsuario, buttonSair;

    @FXML public void sair(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("Você está saindo do programa");
        alert.setContentText("Deseja realmente sair?");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){
            Platform.exit();
        }
    }

    @FXML public void exibirCadastrarLivro(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CadastrarLivroView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 656, 437);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void exibirCadastrarUsuario(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CadastroUsuarioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 656, 437);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
