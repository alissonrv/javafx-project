package javafxproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxproject.HelloApplication;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastrarLivroController implements Initializable {
    @FXML private Button buttonCadastrar;
    @FXML private TextField  tituloTextField, autorTextField, anoTextField;

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle("");
        alert.setHeaderText(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @FXML public void cadastrar() {
        String titulo =  tituloTextField.getText().trim();   //se colocar o mesmo nome usar o this
        String autor =  autorTextField.getText().trim();

        if(titulo.isBlank() || autor.isBlank() || anoTextField.getText().isBlank()){   //isEmpty() = A string tem zero caracteres (""), isBlank()=A string tem zero caracteres ou só espaços em branco ("", " ", "\t", etc)
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Erro ao cadastra dados!",
                    "Preencha todos os campos!"
            );
            return;
        }
        try{
            int ano =  Integer.parseInt(anoTextField.getText().trim());

            mostrarAlerta(
                    Alert.AlertType.INFORMATION,
                    "",
                    "Livro cadastrado com sucesso!"
            );

        }catch (NumberFormatException e){
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Erro ao cadastrar Livro",
                    "Digite apenas números no campo ano!"
            );

            return;
        }

//        Livro livro = new Livro(titulo, autor, ano);
    }

    @FXML public void voltarMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MenuView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 680);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Restricoes.setTextFieldInteger(anoTextField);
        Restricoes.setTextFieldMaxLength(anoTextField, 4);
        Restricoes.setTextFieldDouble(anoTextField);
    }
}