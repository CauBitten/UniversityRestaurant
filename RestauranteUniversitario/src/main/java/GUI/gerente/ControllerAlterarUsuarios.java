package GUI.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import negocio.Fachada;
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAlterarUsuarios implements Initializable {

    private Usuario usuario;

    @FXML
    private CheckBox checkBoxAtivo;

    @FXML
    private ChoiceBox<String> choiceBoxTipo;

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
        //falta alterar o cpf
        if (compararUsuarioAosCampos()) {
            showErrorMessage("Erro: usuário não modificado", "Usuário não modificado",
                    "Altere os campos para poder modificar");
        }
        else {
            Usuario editado = new Usuario(senhaField.getText(), tfLogin.getText(), tfEmail.getText(), tfNome.getText(),
                    usuario.getCpf(), usuario.isAtivado(), usuario.getPerfil());
            Fachada.getInstance().alterarUsuario(usuario, editado);
            showInfoMessage("Alteração bem-sucedida", "Sucesso!", "Alteração realizada com sucesso");
            ScreenManager.getInstance().getControllerListarUsuarios().atualizarApresentacao();
            ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_USUARIO.name());
        }
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        usuario = null;
        ScreenManager.getInstance().getControllerListarUsuarios().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_USUARIO.name());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxTipo.getItems().addAll("Gerente", "Vendedor", "Cliente");
    }

    public void setUsuario(Usuario u) {
        if (u != null) {
            usuario = u;
        }
    }

    public void initialize() {
        if (usuario != null) {
            tfLogin.setText(usuario.getLogin());
            tfNome.setText(usuario.getNome());
            tfEmail.setText(usuario.getEmail());
            senhaField.setText(usuario.getSenha());
        }
    }
    private void showErrorMessage(String titulo, String header, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    private void showInfoMessage(String titulo, String header, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    private boolean verificarCampos() {
        return tfNome.getText().isBlank() || tfEmail.getText().isBlank() || tfLogin.getText().isBlank() ||
                senhaField.getText().isBlank();
    }

    private boolean compararUsuarioAosCampos() {
        //implementar os que faltam, precisa adicionar o resto na tela e ajustar o cpf
        return tfNome.getText().equals(usuario.getNome()) && tfEmail.getText().equals(usuario.getEmail()) &&
                tfLogin.getText().equals(usuario.getLogin()) && senhaField.getText().equals(usuario.getSenha());
    }

}
