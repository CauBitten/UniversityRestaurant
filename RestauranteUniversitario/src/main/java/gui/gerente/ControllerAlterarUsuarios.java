package gui.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAlterarUsuarios implements Initializable {

    private Usuario usuario;

    @FXML
    private Button buttonAlterar;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private PasswordField senhaField;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfNome;

    @FXML
    void bttnAlterarOn(ActionEvent event) {

    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        usuario = null;
        ScreenManager.getInstance().getControllerListarUsuarios().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_USUARIO.name());
    }

    public void setUsuario(Usuario u) {
        if (u != null) {
            usuario = u;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (usuario != null) {
            tfLogin.setText(usuario.getLogin());
            tfNome.setText(usuario.getNome());
            tfEmail.setText(usuario.getEmail());
            senhaField.setText(usuario.getSenha());
        }
    }

}
