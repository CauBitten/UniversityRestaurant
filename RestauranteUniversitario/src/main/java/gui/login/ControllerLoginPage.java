package gui.login;

import view.TelasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import view.ScreenManager;

import java.io.IOException;

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
        ScreenManager.changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());

//        if () {
//
//        } else if () {
//
//        } else if () {
//
//        }
    }

}
