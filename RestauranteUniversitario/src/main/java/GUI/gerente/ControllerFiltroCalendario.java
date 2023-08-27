package GUI.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerFiltroCalendario {

    @FXML
    private DatePicker dtpData;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfTipo;

    @FXML
    void bttnFiltrarOn(ActionEvent event) {

    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        clearFields();
        ScreenManager.getInstance().changeScreen(TelasEnum.CALENDARIO.name());
    }

    private void clearFields() {
        tfId.setText("");
        tfTipo.setText("");
    }

}
