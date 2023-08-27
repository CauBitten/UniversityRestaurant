package GUI.vendedor;

import exception.LoginNaoExisteException;
import exception.UsuarioDesativadoException;
import exception.UsuarioNaoEClienteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.Fachada;
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
    private TextField tfLogin;

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
        if (validarCampos()) {
            try {
                ScreenManager.getInstance().getControllerPagamentoVendaACliente().setComprador(
                        Fachada.getInstance().validarUsuarioParaCompra(tfLogin.getText()));
                ScreenManager.getInstance().changeScreen(TelasEnum.PAGAMENTO_VENDA_CLIENTE.name());
            }
            catch (LoginNaoExisteException e) {
                showErrorMessage("Erro: usuário não cadastrado", "O login informado não existe",
                        "Tente novamente");
            }
            catch (UsuarioDesativadoException e) {
                showErrorMessage("Erro: usuário desativado", "O usuário informado está desativado",
                        "Contate o administrador");
            }
            catch (UsuarioNaoEClienteException e) {
                showErrorMessage("Erro: usuário não é cliente", "O usuário informado não é do tipo cliente",
                "Tente novamente.");
            }
        }
    }

    private boolean validarCampos() {
        if ((contadorAlmoco > 0 || contadorJantar > 0) && tfLogin.getText() != null)
            return true;
        else if (contadorAlmoco == 0 && contadorJantar == 0) {
            showErrorMessage("Erro: nenhuma ficha selecionada", "Você deve selecionar fichas para comprar",
                    "Tente outra vez para prosseguir");
        }
        else if (tfLogin.getText().isBlank()) {
            showErrorMessage("Erro: nenhum login digitado", "Você deve prover um login",
                    "Tente outra vez para prosseguir");
        }

        return false;
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
        clearFields();
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
        tfLogin.setText(null);
    }
}
