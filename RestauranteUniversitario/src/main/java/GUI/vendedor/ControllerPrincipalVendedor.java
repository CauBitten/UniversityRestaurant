package GUI.vendedor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalVendedor {

    @FXML
    void bttnRefeicoes(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_REFEICOES.name());
    }

    @FXML
    void bttnVender(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.VENDA.name());
    }

    @FXML
    void hlSairOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.LOGIN.name());
    }

}
