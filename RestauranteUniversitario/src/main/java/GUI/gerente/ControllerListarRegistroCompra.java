package GUI.gerente;

import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.Fachada;
import negocio.beans.Cardapio;
import negocio.beans.RegistroCompra;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ControllerListarRegistroCompra implements Initializable {

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private TableColumn<RegistroCompra, Long> codigoColumn = new TableColumn<>("Código");

    @FXML
    private TableColumn<RegistroCompra, String> clienteColumn = new TableColumn<>("Cliente");

    @FXML
    private TableColumn<RegistroCompra, String> vendedorColumn = new TableColumn<>("Vendedor");

    @FXML
    private TableColumn<RegistroCompra, String> dataHoraColumn = new TableColumn<>("Data & Hora");

    @FXML
    private TableColumn<RegistroCompra, Double> valorColumn = new TableColumn<>("Valor");

    @FXML
    private TableColumn<RegistroCompra, Integer> almocoColumn = new TableColumn<>("Almoço");

    @FXML
    private TableColumn<RegistroCompra, Integer> jantaColumn = new TableColumn<>("Janta");

    @FXML
    private TableColumn<RegistroCompra, String> pagamentoColumn = new TableColumn<>("Pagamento");


    @FXML
    private TableView<RegistroCompra> tvRegistroCompra;

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        codigoColumn.setCellValueFactory(new PropertyValueFactory<>("codigoCompra"));

        clienteColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario().getNome()));

        vendedorColumn.setCellValueFactory(new PropertyValueFactory<>("vendedor"));

        dataHoraColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDataHoraCompra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));

        pagamentoColumn.setCellValueFactory(new PropertyValueFactory<>("pagamento"));

        valorColumn.setCellValueFactory(new PropertyValueFactory<>("valorCompra"));

        almocoColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().
            getFichasCompradas().stream().filter(ficha -> ficha.getTipo().equals("Almoco")).collect(Collectors.toList()).size()).asObject());
        jantaColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().
                getFichasCompradas().stream() .filter(ficha -> ficha.getTipo().equals("Janta")) .collect(Collectors.toList()).size()).asObject());

    }

    private void configurarTv(List<RegistroCompra> registroCompras) {
        ObservableList<RegistroCompra> registroList = FXCollections.observableArrayList();
        registroList.addAll(registroCompras);
        tvRegistroCompra.setItems(registroList);
    }

    public void atualizarApresentacao() {
        for (int i = 0; i < tvRegistroCompra.getItems().size(); i++)
            tvRegistroCompra.getItems().clear();

        configurarTv(Fachada.getInstance().getRegistrosCompra());
    }

}
