package GUI.gerente;

import javafx.beans.property.SimpleLongProperty;
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
import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;
import negocio.beans.RegistroCompra;
import view.ScreenManager;
import view.TelasEnum;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ControllerCalendario {

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private TableColumn<CardapioPorEntrada, String> tblColData;

    @FXML
    private TableColumn<CardapioPorEntrada, Long> tblColIdCardapio;

    @FXML
    private TableColumn<CardapioPorEntrada, String> tblColTipo;

    @FXML
    private TableView<CardapioPorEntrada> tvCardapiosPorDia;

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

    public void initialize() {
        tblColData.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        tblColTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tblColIdCardapio.setCellValueFactory(cellData ->
                new SimpleLongProperty(cellData.getValue().getCardapio().getId()).asObject());
    }

    public void configurarTv(List<CardapioPorEntrada> cardapios) {
        ObservableList<CardapioPorEntrada> cardapioPorEntradas = FXCollections.observableArrayList();
        cardapioPorEntradas.addAll(cardapios);
        tvCardapiosPorDia.setItems(cardapioPorEntradas);
    }

    public void atualizarApresentacao() {
        limparItens();

        configurarTv(Fachada.getInstance().getCardapiosPorEntrada());
    }

    public void limparItens() {
        for (int i = 0; i < tvCardapiosPorDia.getItems().size(); i++)
            tvCardapiosPorDia.getItems().clear();
    }


}
