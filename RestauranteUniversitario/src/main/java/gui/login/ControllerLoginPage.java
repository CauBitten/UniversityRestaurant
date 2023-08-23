package gui.login;

import dados.IRepositorioUsuario;
import dados.RepositorioUsuario;
import negocio.Fachada;
import negocio.beans.Usuario;
import view.TelasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import view.ScreenManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerLoginPage {

    @FXML
    private TextField emailField;

    @FXML
    private Button entrarButton;

    @FXML
    private Hyperlink hlEsqueceuSenha;

    @FXML
    private PasswordField passwordField;

    @FXML
    void hyperLinkEsqueceuSenha(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Envie um e-mail para a administração resolver seu problema: adminru@ufrpe.br");

        alert.setTitle("ESQUECEU A SENHA!");
        alert.show();
    }

    public void entrarButtonClicked(ActionEvent event) throws IOException {
        String email = emailField.getText();
        String password = passwordField.getText();
        if (Fachada.getInstance().controladorUsuario.permicaoLogin(email, password)) {
            showAlert("Login bem-sucedido!", Alert.AlertType.INFORMATION);
            ScreenManager.changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
        } else {
            showAlert("Credenciais inválidas!", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Login");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
     }

 }

