package gui.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.ScreenManager;

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
    void btnEntrar(ActionEvent event) {

    }

    @FXML
    void hyperLinkEsqueceuSenha(ActionEvent event) {

    }

    public void entrarButtonClicked(ActionEvent event) {
        Stage dialog = new Stage();

        dialog.setScene(ScreenManager.getInstance().getPrincipalGerenteScene());
        dialog.setResizable(false);
        dialog.setTitle("Gerente");
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

}
