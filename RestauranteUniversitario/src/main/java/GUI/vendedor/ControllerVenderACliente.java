package GUI.vendedor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerVenderACliente implements Initializable {

    private int contadorAlmoco = 0;
    private int contadorJantar = 0;

    @FXML
    private CheckBox cbAlmoco;

    @FXML
    private CheckBox cbJantar;

    @FXML
    private Label labelQuantidadeAlmoco;

    @FXML
    private Label labelQuantidadeJantar;

    @FXML
    private TextField tfCPF;

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
    void bttnEfetuarCompraOn(ActionEvent event) {
        if ( (contadorAlmoco > 0 || contadorJantar > 0) && tfCPF.getText() != null) {
            ScreenManager.getInstance().changeScreen(TelasEnum.PAGAMENTO_VENDA_CLIENTE.name());
            ScreenManager.getInstance().getControllerPagamentoVendaACliente().inicializarValores();
        }
        else if (contadorAlmoco == 0 && contadorJantar == 0){
            showErrorMessage("Erro: nenhuma ficha selecionada", "Você deve selecionar fichas para compra",
                    "Tente outra vez para prosseguir");
        } else if (tfCPF.getText() == null) {
            showErrorMessage("Erro: nenhum cpf digitado", "Você deve prover um cpf",
                    "Tente outra vez para prosseguir");
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
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_VENDEDOR.name());
    }

    private void atualizarLabelNum (Label label, int contador) {
        label.setText(Integer.toString(contador));
    }

    public void clearFields(){
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

    public int getContadorAlmoco() {
        return contadorAlmoco;
    }

    public int getContadorJantar() {
        return contadorJantar;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tfCPF.setText(null);
    }
}
