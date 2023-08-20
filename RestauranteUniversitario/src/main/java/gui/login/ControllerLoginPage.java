package gui.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.Main;
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

    private ScreenManager screenManager;

    private static ControllerLoginPage instance;

    public static ControllerLoginPage getInstance() {
        if (instance == null) instance = new ControllerLoginPage();

        return instance;
    }

    @FXML
    void btnEntrar(ActionEvent event) {

    }

    @FXML
    void hyperLinkEsqueceuSenha(ActionEvent event) {

    }

    public void entrarButtonClicked(ActionEvent event) throws IOException {
        Stage dialog = new Stage();

        dialog.setScene(ScreenManager.getInstance().getPrincipalGerenteScene());
        dialog.setResizable(false);
        dialog.setTitle("Gerente");
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

}
