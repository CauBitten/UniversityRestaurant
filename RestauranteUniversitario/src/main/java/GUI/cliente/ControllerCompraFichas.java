package GUI.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerCompraFichas {

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
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
        clearFields();
    }

    @FXML
    void bttnEfetuarCompraOn(ActionEvent event) {
        if (!cbAlmoco.isSelected()) {
            contadorAlmoco = 0;
        }
        else if (!cbJantar.isSelected()) {
            contadorJantar = 0;
        }
        else {
            if (contadorAlmoco >= 0 || contadorJantar >= 0) {
                ScreenManager.getInstance().changeScreen(TelasEnum.PAGAMENTO.name());
                ScreenManager.getInstance().getControllerPagamento().inicializarValores();
            }
            else {
                showErrorMessage("Erro: nenhuma ficha selecionada", "Você deve selecionar fichas para compra",
                        "Tente outra vez para prosseguir");
            }
        }
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

    public void clearFields() {
        contadorAlmoco = 0;
        contadorJantar = 0;
        atualizarLabelNum(labelQuantidadeAlmoco, 0);
        atualizarLabelNum(labelQuantidadeJantar, 0);
        cbAlmoco.setSelected(false);
        cbJantar.setSelected(false);
    }

    private void showErrorMessage(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

}
