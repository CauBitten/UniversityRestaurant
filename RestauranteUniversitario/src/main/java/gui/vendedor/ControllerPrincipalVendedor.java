package gui.vendedor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalVendedor {

    @FXML
    void bttnRefeicoes(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.LISTAR_REFEICOES.name());
    }

    @FXML
    void bttnVender(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.VENDA.name());
    }

    @FXML
    void hlSairOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.LOGIN.name());
    }

}
