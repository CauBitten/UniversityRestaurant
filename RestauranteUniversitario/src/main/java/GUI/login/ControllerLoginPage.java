package GUI.login;

import negocio.Fachada;
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
        String login = loginField.getText();
        String password = passwordField.getText();

        int tipoDeEntrada = Fachada.getInstance().controladorUsuario.permicaoLogin(login, password);

        if (tipoDeEntrada == 1) {
            showInfoMessage("Bem-Vindo!", "Login bem-sucedido", "Seja bem-vindo ao RU");
            ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
        }
        else if(tipoDeEntrada == 2){
            showInfoMessage("Bem-Vindo!", "Login bem-sucedido", "Seja bem-vindo ao RU");
            ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_VENDEDOR.name());
        }
        else if(tipoDeEntrada == 3){
            showInfoMessage("Bem-Vindo!", "Login bem-sucedido", "Seja bem-vindo ao RU");
            ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
        }
        else {
            showErrorAlert("Erro: acesso negado", "Credenciais inválidas", "Corrija as informações" +
                    " e tente novamente");
        }
        clearFields();
    }

    private void clearFields() {
        loginField.setText("");
        passwordField.setText("");
    }

    private void showErrorAlert(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    private void showInfoMessage(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

}
