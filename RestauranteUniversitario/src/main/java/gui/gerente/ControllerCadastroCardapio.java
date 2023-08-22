package gui.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerCadastroCardapio {

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private TextField tfGuarnicao;

    @FXML
    private TextField tfPrincipal;

    @FXML
    private TextField tfSalada;

    @FXML
    private TextField tfSobremesa;

    @FXML
    private TextField tfSuco;

    @FXML
    private TextField tfVegetariano;

    @FXML
    void bttnCadastrarOn(ActionEvent event) {
        if (validar()) {
            System.out.println("1");
        }
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

    private void showErrorMessage(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    private void showInfoMessage(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    private boolean validar() {
        if (tfGuarnicao.getText().isBlank() || tfPrincipal.getText().isBlank() || tfSalada.getText().isBlank() ||
            tfVegetariano.getText().isBlank() || tfSobremesa.getText().isBlank() || tfSuco.getText().isBlank()) {
            showErrorMessage("Erro: campos preenchidos incorretamente" , "Informe os campos solicitados corretamente");
            return false;
        }

        return true;
    }

}
