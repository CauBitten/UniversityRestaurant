package gui.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import negocio.beans.Cliente;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCadastroUsuario implements Initializable {

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private ChoiceBox<String> choiceBoxTipo;

    @FXML
    private RadioButton rdAtivado;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSenha;

    @FXML
    void bttnCadastrarOn(ActionEvent event) {

    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.LISTAR_USUARIO.name());
    }

    @FXML
    void rdAtivadoOn(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxTipo.getItems().addAll("Gerente", "Vendedor", "Cliente");
    }
}
