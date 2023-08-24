package GUI.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerListarRegistroCompra {

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private TableColumn<?, ?> tbColAlmoco;

    @FXML
    private TableColumn<?, ?> tblColCliente;

    @FXML
    private TableColumn<?, ?> tblColCodigo;

    @FXML
    private TableColumn<?, ?> tblColDataHora;

    @FXML
    private TableColumn<?, ?> tblColJanta;

    @FXML
    private TableColumn<?, ?> tblColPagamento;

    @FXML
    private TableColumn<?, ?> tblColValor;

    @FXML
    private TableColumn<?, ?> tblColVendedor;

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

}
