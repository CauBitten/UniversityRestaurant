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
                    showInfoAlert("Acesso permitido", "Login bem-sucedido", "Bem-vindo ao RU");
                    Fachada.getInstance().setUsuarioLogado(u);
                    ScreenManager.getInstance().getControllerVisualizacaoDados().exibirDados();
                    ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
                }
                case "Vendedor" -> {
                    showInfoAlert("Acesso permitido", "Login bem-sucedido", "Bem-vindo ao RU");
                    ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_VENDEDOR.name());
                }
                case "Gerente" -> {
                    showInfoAlert("Acesso permitido", "Login bem-sucedido", "Bem-vindo ao RU");
                    Fachada.getInstance().setUsuarioLogado(u);
                    ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
                }
            }
        }
        else {
            showErrorAlert("Erro: acesso negado", "Credenciais inválidas informadas", "Atualize e tente outra vez");
        }

        clearFields();
    }

    private void clearFields() {
        loginField.setText("");
        passwordField.setText("");
    }

    private void showErrorAlert(String titulo, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfoAlert(String titulo, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private Usuario obterUsuarioDe(String login, String senha) {
        return Fachada.getInstance().validarCredenciais(login, senha);
    }
}
