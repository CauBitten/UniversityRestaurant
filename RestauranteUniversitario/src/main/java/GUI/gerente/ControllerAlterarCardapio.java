package GUI.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.beans.Cardapio;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerAlterarCardapio {

    Cardapio cardapio;

    @FXML
    private Button buttonAlterar;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private TextField tfGuarnicao;

    @FXML
    private TextField tfPrincipal;

    @FXML
    private TextField tfSalada;

    @FXML
    private TextField tfSobremesa;

    @FXML
    private TextField tfSuco;

    @FXML
    private TextField tfVegetariano;

    @FXML
    void bttnAlterarOn(ActionEvent event) {

    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        cardapio = null;
        ScreenManager.getInstance().getControllerListarCardapios().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_CARDAPIOS.name());
    }

    public void setCardapio(Cardapio c) {
        if (c != null) {
            this.cardapio = c;
        }
    }

    public void initialize() {
        if (cardapio != null) {
            tfGuarnicao.setText(cardapio.getGuarnicao());
            tfSuco.setText(cardapio.getSuco());
            tfPrincipal.setText(cardapio.getPrincipal());
            tfSalada.setText(cardapio.getSalada());
            tfVegetariano.setText(cardapio.getVegetariano());
        }
    }

}
