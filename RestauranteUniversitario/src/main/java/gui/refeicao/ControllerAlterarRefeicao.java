package gui.refeicao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerAlterarRefeicao {

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.VISUALIZAR_REFEICOES.name());
    }

}
