package gui.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerCadastroUsuario {

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private MenuButton menuTipo;

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
    private TextField tfPerfil;

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
    void menuTipoOn(ActionEvent event) {

    }

    @FXML
    void rdAtivadoOn(ActionEvent event) {

    }

}
