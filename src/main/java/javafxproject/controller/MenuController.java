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
import javafxproject.utils.Rotinas;

import java.io.IOException;
import java.util.Optional;

public class MenuController {
    @FXML Button buttonCadastrarLivro,buttonCadastrarUsuario, buttonSair, loginButton;

    @FXML public void sair(){
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("");
//        alert.setHeaderText("Você está saindo do programa");
//        alert.setContentText("Deseja realmente sair?");

        Optional<ButtonType> resultado = Rotinas.mostrarAlerta(
                Alert.AlertType.CONFIRMATION,
                "Você está saindo do programa",
                "Deseja realmente sair?"
        );

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){
            Platform.exit();
        }
    }

    @FXML public void exibirCadastrarLivro(ActionEvent event){
        Rotinas.mostrarTela(event, "CadastrarLivroView.fxml", 656, 437);
    }

    @FXML public void exibirCadastrarUsuario(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CadastroUsuarioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 656, 437);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void exibirTelaLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TelaLoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 656, 437);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
