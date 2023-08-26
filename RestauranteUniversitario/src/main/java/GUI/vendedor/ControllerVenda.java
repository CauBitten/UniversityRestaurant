package GUI.vendedor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerVenda {

    @FXML
    private Button buttonVoltarPagina;
    private int contadorAlmoco = 0;
    private int contadorJantar = 0;

    @FXML
    private CheckBox cbAlmoco;

    @FXML
    private CheckBox cbJantar;

    @FXML
    private Label labelQuantidadeJantar;

    @FXML
    private Label labelQuantidadeAlmoco;

    @FXML
    void bttnDecrementarOn1(ActionEvent event) {
        if (contadorAlmoco > 0 && cbAlmoco.isSelected()) {
            contadorAlmoco--;
            atualizarLabelNum(labelQuantidadeAlmoco, contadorAlmoco);
        }
    }

    @FXML
    void bttnDecrementarOn2(ActionEvent event) {
        if (contadorJantar > 0 && cbJantar.isSelected()) {
            contadorJantar--;
            atualizarLabelNum(labelQuantidadeJantar, contadorJantar);
        }
    }

    @FXML
    void bttnIncrementarOn1(ActionEvent event) {
        if (cbAlmoco.isSelected()) {
            contadorAlmoco++;
            atualizarLabelNum(labelQuantidadeAlmoco, contadorAlmoco);
        }
    }

    @FXML
    void bttnIncrementarOn2(ActionEvent event) {
        if (cbJantar.isSelected()) {
            contadorJantar++;
            atualizarLabelNum(labelQuantidadeJantar, contadorJantar);
        }
    }

    @FXML
    void bttnEfetuarCompraOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PAGAMENTOVENDEDOR.name());
        ScreenManager.getInstance().getControllerPagamentoVendedor().inicializarValores();
        clearFields();
    }

    private void atualizarLabelNum (Label label, int contador) {
        label.setText(Integer.toString(contador));
    }

    public int getContadorAlmoco() {
        return contadorAlmoco;
    }

    public int getContadorJantar() {
        return contadorJantar;
    }

    public void clearFields(){
        contadorAlmoco = 0;
        contadorJantar = 0;
        atualizarLabelNum(labelQuantidadeAlmoco, 0);
        atualizarLabelNum(labelQuantidadeJantar, 0);
        cbAlmoco.setSelected(false);
        cbJantar.setSelected(false);
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_VENDEDOR.name());
    }

}
