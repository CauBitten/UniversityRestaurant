package GUI.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import negocio.Fachada;
import negocio.beans.RegistroCompra;
import view.ScreenManager;
import view.TelasEnum;

import java.util.ArrayList;
import java.util.List;

public class ControllerFiltrarRegistroCompra {

    @FXML
    private Button buttonFiltrar;

    @FXML
    private DatePicker dtpData;

    @FXML
    private TextField tfAlmoco;

    @FXML
    private TextField tfCliente;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfJanta;

    @FXML
    private TextField tfValor;

    @FXML
    private TextField tfVendedor;

    @FXML
    private ChoiceBox<String> cbPagamento;

    @FXML
    void bttnFiltrarOn(ActionEvent event) {
        ScreenManager.getInstance().getControllerListarRegistroCompra().atualizarApresentacao();
        List<RegistroCompra> registroCompras = filtrar();
        System.out.println(registroCompras);

        if (registroCompras.isEmpty())
            showErrorMessage("Erro: nada encontrado", "A busca não retornou resultados",
                    "Tente novamente com outros filtros.");
        else
            ScreenManager.getInstance().getControllerListarRegistroCompra().configurarTv(registroCompras);

        clearFields();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_REGISTRO_COMPRA.name());
    }

    public void initialize() {
        if (cbPagamento.getItems().isEmpty())
            cbPagamento.getItems().addAll("Pix", "Cartão", "Boleto");
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().getControllerListarRegistroCompra().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_REGISTRO_COMPRA.name());
    }

    private void clearFields() {
        tfAlmoco.setText("");
        tfCodigo.setText("");
        tfCliente.setText("");
        tfValor.setText("");
        cbPagamento.setValue("");
        tfVendedor.setText("");
        tfJanta.setText("");

        dtpData.getEditor().clear();
    }

    private List<RegistroCompra> filtrar() {
        List<RegistroCompra> registrosFiltrados = new ArrayList<>();

        if (tfAlmoco.getText().isBlank() && tfJanta.getText().isBlank() && tfVendedor.getText().isBlank() &&
            cbPagamento.getValue().isBlank() && tfCliente.getText().isBlank() && tfCodigo.getText().isBlank() &&
            dtpData.getValue() == null) {
            registrosFiltrados = Fachada.getInstance().getRegistrosCompra();
        }
        else {
            RegistroCompra modelo;

            if (cbPagamento.getValue() == null) {
                modelo = new RegistroCompra(new ArrayList<>(0), tfCliente.getText(),
                        tfVendedor.getText(), "", dtpData.getValue().atStartOfDay());
            }
            else {
                modelo = new RegistroCompra(new ArrayList<>(0), tfCliente.getText(),
                        tfVendedor.getText(), cbPagamento.getValue(), dtpData.getValue().atStartOfDay());
            }

            registrosFiltrados.addAll(Fachada.getInstance().obterRegistrosContidosEm(modelo,
                    Integer.parseInt(tfAlmoco.getText()), Integer.parseInt(tfJanta.getText())));
        }

        return registrosFiltrados;
    }

    private void showErrorMessage(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

}
