package javafxproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafxproject.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroUsuarioController implements Initializable {
    @FXML private TextField nomeTextField, emailTextField, cpfTextField, cursoTextField, turmaTextField, cargoTextField;
//    @FXML private Button cadastrarButton, voltarButton;
    @FXML private RadioButton alunoRadioButton, funcionarioRadioButton;
    @FXML private ToggleGroup tipoUsuarioToggleGroup;
    @FXML private Label cursoLabel, turmaLabel, cargoLabel;


    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle("");
        alert.setHeaderText(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @FXML public void cadastrar() {
        String nome =  nomeTextField.getText().trim();   //se colocar o mesmo nome usar o this
        String email =  emailTextField.getText().trim();


        if(nome.isBlank() || email.isBlank() || cpfTextField.getText().isBlank()){   //isEmpty() = A string tem zero caracteres (""), isBlank()=A string tem zero caracteres ou só espaços em branco ("", " ", "\t", etc)
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Erro ao cadastra dados!",
                    "Preencha todos os campos!"
            );
            return;
        }
        try{
            int cpf =  Integer.parseInt(cpfTextField.getText().trim());

            mostrarAlerta(
                    Alert.AlertType.INFORMATION,
                    "",
                    "Usuário cadastrado com sucesso!"
            );

        }catch (NumberFormatException e){
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Erro ao cadastrar Usuário",
                    "Digite apenas números no campo CPF!"
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

    public void tipoUsuario(){
        boolean isAluno = alunoRadioButton.isSelected();
        boolean isFuncionario = funcionarioRadioButton.isSelected();

        mostrarCamposAluno(isAluno);
        mostrarCamposFuncionario(isFuncionario);
    }

    private void mostrarCamposAluno(boolean mostrar){
        cursoLabel.setVisible(mostrar);
        cursoLabel.setManaged(mostrar);
        cursoTextField.setVisible(mostrar);
        cursoTextField.setManaged(mostrar);

        turmaLabel.setVisible(mostrar);
        turmaLabel.setManaged(mostrar);
        turmaTextField.setVisible(mostrar);
        turmaTextField.setManaged(mostrar);
    }

    private void mostrarCamposFuncionario(boolean mostrar){
        cargoLabel.setVisible(mostrar);
        cargoLabel.setManaged(mostrar);

        cargoTextField.setVisible(mostrar);
        cargoTextField.setManaged(mostrar);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mostrarCamposAluno(false);
        mostrarCamposFuncionario(false);
    }
}
