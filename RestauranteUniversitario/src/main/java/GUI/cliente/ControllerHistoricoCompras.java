package GUI.cliente;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.Fachada;
import negocio.beans.RegistroCompra;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerHistoricoCompras {

    @FXML
    private Button buttonFiltrar;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private TableColumn<RegistroCompra, Integer> almocoColumn;

    @FXML
    private TableColumn<RegistroCompra, Long> codigoColumn;

    @FXML
    private TableColumn<RegistroCompra, String> dataHoraColumn;

    @FXML
    private TableColumn<RegistroCompra, Integer> jantaColumn;

    @FXML
    private TableColumn<RegistroCompra, String> pagamentoColumn;

    @FXML
    private TableColumn<RegistroCompra, Double> valorColumn;

    @FXML
    private TableColumn<RegistroCompra, String> vendedorColumn;

    @FXML
    private TableView<RegistroCompra> tvRegistroCompra;


    @FXML
    void bttnFiltrarOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.FILTRO_HISTORICO.name());
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
    }

    public void initialize() {
        codigoColumn.setCellValueFactory(new PropertyValueFactory<>("codigoCompra"));

        vendedorColumn.setCellValueFactory(new PropertyValueFactory<>("loginVendedor"));

        dataHoraColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDataHoraCompra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));

        pagamentoColumn.setCellValueFactory(new PropertyValueFactory<>("pagamento"));

        valorColumn.setCellValueFactory(new PropertyValueFactory<>("valorCompra"));

        almocoColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().
                getFichasCompradas().stream().filter(ficha -> ficha.getTipo().equals("Almoco")).toList().size()).asObject());
        jantaColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().
                getFichasCompradas().stream().filter(ficha -> ficha.getTipo().equals("Janta")).toList().size()).asObject());

    }
    public void configurarTv(List<RegistroCompra> registroCompras) {
        ObservableList<RegistroCompra> registros = FXCollections.observableArrayList();
        registros.addAll(registroCompras);
        tvRegistroCompra.setItems(registros);
    }

    public void atualizarApresentacao() {
        limparItens();
        configurarTv(Fachada.getInstance().obterRegistrosDoUsuario(Fachada.getInstance().getUsuarioLogado()));
    }

    public void limparItens() {
        for (int i = 0; i < tvRegistroCompra.getItems().size(); i++)
            tvRegistroCompra.getItems().clear();
    }

}
