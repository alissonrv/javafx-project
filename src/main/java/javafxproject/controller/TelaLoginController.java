package javafxproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafxproject.utils.Rotinas;

import java.io.IOException;

public class TelaLoginController {
    @FXML private TextField loginTextField;
    @FXML private PasswordField senhaPasswordField;
    @FXML private Button entrarButton;

    @FXML public void autenticar(ActionEvent event) throws IOException {
        String login = loginTextField.getText().trim();
        String senha = senhaPasswordField.getText().trim();

        if(login.isBlank() || senha.isBlank()){
            Rotinas.mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Campos obrigatórios",
                    "Preencha login e senha!"
            );
            return;
        }

        if(login.equals("admin") && senha.equals("admin")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("");
            alert.setContentText("Login realizado com sucesso!");
            alert.showAndWait();

            Rotinas.mostrarTela(event, "MenuView.fxml", 1200, 680);
        }
        else{
            Rotinas.mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "",
                    "Login ou senha errados, preencha novamente."
            );
        }
    }
}
