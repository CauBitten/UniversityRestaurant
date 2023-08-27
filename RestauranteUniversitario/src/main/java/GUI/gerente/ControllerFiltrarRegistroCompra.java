package GUI.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.LocalDateStringConverter;
import negocio.Fachada;
import negocio.beans.RegistroCompra;
import view.ScreenManager;
import view.TelasEnum;

import java.time.LocalDate;
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
        List<RegistroCompra> registroCompras = filtrar();
        ScreenManager.getInstance().getControllerListarRegistroCompra().limparItens();
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
        cbPagamento.getItems().addAll("Pix", "Cartão", "Boleto");
        dtpData.setValue(LocalDate.of(2023, 01, 01));
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        clearFields();
        ScreenManager.getInstance().getControllerListarRegistroCompra().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_REGISTRO_COMPRA.name());
    }

    private void clearFields() {
        tfAlmoco.setText("0");
        tfCodigo.setText("");
        tfCliente.setText("");
        tfValor.setText("");
        cbPagamento.setValue("");
        tfVendedor.setText("");
        tfJanta.setText("0");

        dtpData.setValue(LocalDate.of(2023, 01, 01));
    }

    private List<RegistroCompra> filtrar() {
        List<RegistroCompra> registrosFiltrados = new ArrayList<>();

        if (validarCampos()) {
            registrosFiltrados = Fachada.getInstance().getRegistrosCompra();
        }
        else {
            try {
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
            catch (NumberFormatException e) {
                showErrorMessage("Erro: quantidade de fichas inválida",
                        "A quantidade de fichas deve ser numérica", "Corrija e tente outra vez");
            }
            catch (NullPointerException e) {
                showErrorMessage("Erro: data inválida",
                        "Você deve selecionar uma data", "Tente novamente");
            }
        }

        return registrosFiltrados;
    }

    private void showErrorMessage(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean validarCampos() {
        return tfAlmoco.getText().isBlank() && tfJanta.getText().isBlank() && tfVendedor.getText().isBlank() &&
                cbPagamento.getValue().isBlank() && tfCliente.getText().isBlank() && tfCodigo.getText().isBlank() &&
                dtpData.getValue() == null && tfJanta.getText().equals("0") && tfAlmoco.getText().equals("0");
    }

}
