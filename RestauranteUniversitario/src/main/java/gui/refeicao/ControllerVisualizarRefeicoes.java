package gui.refeicao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerVisualizarRefeicoes {

    @FXML
    private Button buttonAlterarRef;

    @FXML
    private Button buttonCadastrarRef;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    void bttnAlterarRefOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.ALTERAR_REFEICOES.name());
    }

    @FXML
    void bttnCadastrarRefOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.CADASTRAR_REFEICOES.name());
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

}
