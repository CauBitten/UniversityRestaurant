package GUI.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.Fachada;
import view.ScreenManager;
import view.TelasEnum;
import negocio.beans.Cardapio;

import java.util.ArrayList;
import java.util.List;

public class ControllerFiltrarCardapio {

    @FXML
    private Button buttonFiltrar;

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
    void bttnFiltrarOn(ActionEvent event) {
        List<Cardapio> cardapios = filtrar();
        ScreenManager.getInstance().getControllerListarCardapios().limparItens();

        if (cardapios.isEmpty())
            showErrorMessage("Erro: nada encontrado", "Não foram encontrados cardápios", "Tente outro filtro.");
        else
            ScreenManager.getInstance().getControllerListarCardapios().configurarTv(cardapios);

        clearFields();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_CARDAPIOS.name());
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        clearFields();
        ScreenManager.getInstance().getControllerListarCardapios().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_CARDAPIOS.name());
    }

    private List<Cardapio> filtrar() {
        List<Cardapio> cardapiosFiltrados = new ArrayList<>();

        if (tfGuarnicao.getText().isBlank() && tfPrincipal.getText().isBlank() && tfSalada.getText().isBlank() &&
        tfSuco.getText().isBlank() && tfVegetariano.getText().isBlank() && tfSobremesa.getText().isBlank()) {
            cardapiosFiltrados = Fachada.getInstance().obterCardapios();
        }
        else {
            Cardapio c = new Cardapio(tfPrincipal.getText(), tfVegetariano.getText(), tfGuarnicao.getText(),
                    tfSalada.getText(), tfSobremesa.getText(), tfSuco.getText());

            cardapiosFiltrados.addAll(Fachada.getInstance().obterCardapiosComPratosIguaisA(c));
        }

        return cardapiosFiltrados;
    }

    private void showErrorMessage(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

    private void clearFields() {
        tfSobremesa.setText("");
        tfSuco.setText("");
        tfVegetariano.setText("");
        tfSalada.setText("");
        tfPrincipal.setText("");
        tfGuarnicao.setText("");
    }

}
