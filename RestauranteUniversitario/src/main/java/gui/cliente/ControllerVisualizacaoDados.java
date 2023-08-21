package gui.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerVisualizacaoDados {

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private TableView<?> tableViewDados;

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
    }

}

