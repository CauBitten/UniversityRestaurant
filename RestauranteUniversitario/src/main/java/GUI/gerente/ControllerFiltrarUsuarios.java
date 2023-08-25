package GUI.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerFiltrarUsuarios {

    @FXML
    private Button buttonFiltrar;

    @FXML
    private CheckBox checkBoxAtivo;

    @FXML
    private ChoiceBox<String> choiceBoxTipo;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfNome;

    @FXML
    void bttnFiltrarOn(ActionEvent event) {
        ScreenManager.getInstance().getControllerListarUsuarios().configurarTv(filtrar());
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_USUARIO.name());
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().getControllerListarUsuarios().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_USUARIO.name());
    }

    List<Usuario> filtrar() {
        List<Usuario> usuarios = new ArrayList<>();

        if (!tfNome.getText().isBlank()) {
            usuarios.addAll(Fachada.getInstance().getUsuariosComNome(tfNome.getText()));
        }

        //encontra um igual, tratar se for nulo
        if (!tfEmail.getText().isBlank()) {
            usuarios.add(Fachada.getInstance().getUsuarioComEmail(tfEmail.getText()));
        }

        if (!tfLogin.getText().isBlank()) {
            usuarios.add(Fachada.getInstance().getUsuarioComLogin(tfLogin.getText()));
        }

        if (choiceBoxTipo.getValue() != null) {
            usuarios.addAll(Fachada.getInstance().getUsuariosPorPerfil(choiceBoxTipo.getValue()));
        }

        return usuarios;
    }

    public void initialize() {
        choiceBoxTipo.getItems().addAll("Gerente", "Vendedor", "Cliente");
    }

}
