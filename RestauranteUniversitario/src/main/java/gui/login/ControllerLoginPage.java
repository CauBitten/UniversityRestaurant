package gui.login;

import view.TelasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import view.ScreenManager;

public class ControllerLoginPage {

    @FXML
    private TextField emailField;

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
        if (validar()) {
            ScreenManager.changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
        }
        clearFields();
    }

    private boolean validar() {
        if (emailField.getText().isBlank() || passwordField.getText().isBlank()) {
            showErrorMessage("Erro: campos preenchidos incorretamente", "Informe os campos solicitados corretamente");
            return false;
        }
        return true;
    }

    private void showErrorMessage(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    private void clearFields() {
        emailField.setText("");
        passwordField.setText("");
    }

}
