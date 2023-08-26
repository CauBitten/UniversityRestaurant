package GUI.gerente;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.beans.Entrada;
import view.ScreenManager;
import view.TelasEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ControllerListarEntradas {

    @FXML
    private Button bttnFiltrar;

    @FXML
    private Button buttonVoltarPagina;

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

    }

}
