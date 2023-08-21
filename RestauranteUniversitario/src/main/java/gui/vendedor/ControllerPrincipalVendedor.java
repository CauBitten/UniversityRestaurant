package gui.vendedor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalVendedor {

    @FXML
    private Button refeicoesButton;

    @FXML
    private Button venderButton;

    @FXML
    void bttnRefeicoes(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.LISTAR_REFEICOES.name());
    }

    @FXML
    void bttnVender(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.VENDA.name());
    }

}
