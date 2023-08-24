package GUI.login;

import negocio.Fachada;
import negocio.beans.Usuario;
import view.TelasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import view.ScreenManager;

public class ControllerLoginPage {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void hyperLinkEsqueceuSenha(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Envie um e-mail para a administração resolver seu problema: adminru@ufrpe.br");

        alert.setTitle("ESQUECEU A SENHA!");
        alert.show();
    }

    public void entrarButtonClicked(ActionEvent event) {
        Usuario u = obterUsuarioDe(loginField.getText(), passwordField.getText());

        if (u != null) {
            switch (u.getPerfil()) {
                case "Cliente" -> {
                    showAlert("Login bem-sucedido!", Alert.AlertType.INFORMATION);
                    ScreenManager.getInstance().getControllerVisualizacaoDados().exibirDados();
                    ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
                }
                case "Vendedor" -> {
                    showAlert("Login bem-sucedido!", Alert.AlertType.INFORMATION);
                    ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_VENDEDOR.name());
                }
                case "Gerente" -> {
                    showAlert("Login bem-sucedido!", Alert.AlertType.INFORMATION);
                    ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
                }
            }
        }
        else {
            showAlert("Credenciais inválidas!", Alert.AlertType.ERROR);
        }

        clearFields();
    }

    private void clearFields() {
        loginField.setText("");
        passwordField.setText("");
    }

    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Login");
        alert.setHeaderText("Erro");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Usuario obterUsuarioDe(String login, String senha) {
        return Fachada.getInstance().validarCredenciais(login, senha);
    }
}
