package GUI.gerente;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.Fachada;
import negocio.beans.Entrada;
import view.ScreenManager;
import view.TelasEnum;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ControllerListarEntradas {

    @FXML
    private TableView<Entrada> tvEntrada;

    @FXML
    private TableColumn<Entrada, String> tblColCliente;

    @FXML
    private TableColumn<Entrada, String> tblColDataHora;

    @FXML
    private TableColumn<Entrada, Long> tblColIdCardapio;

    @FXML
    private TableColumn<Entrada, Long> tblColIdFicha;

    @FXML
    private TableColumn<Entrada, String> tblColTipo;

    @FXML
    void bttnFiltrarOn(ActionEvent event) {

    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

    public void initialize() {
        tblColTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tblColCliente.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFicha().getUsuario().getLogin()));
        tblColDataHora.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));
        tblColIdCardapio.setCellValueFactory(cellData ->
                new SimpleLongProperty(cellData.getValue().getCardapio().getCardapio().getId()).asObject());
        tblColIdFicha.setCellValueFactory(cellData ->
                new SimpleLongProperty(cellData.getValue().getFicha().getCodigo()).asObject());
    }

    public void atualizarApresentacao() {
        for (int i = 0; i < tvEntrada.getItems().size(); i++)
            tvEntrada.getItems().clear();

        configurarTv(Fachada.getInstance().getListaEntrada());
    }

    public void configurarTv(List<Entrada> entradas) {
        ObservableList<Entrada> entradasList = FXCollections.observableArrayList();
        entradasList.addAll(entradas);
        tvEntrada.setItems(entradasList);
    }

}
