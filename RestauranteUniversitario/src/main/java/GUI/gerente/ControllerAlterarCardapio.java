package GUI.gerente;

import exception.CardapioJaCadastradoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.beans.Cardapio;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerAlterarCardapio {

    private Cardapio cardapio;

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
        if (compararCardapioAosCampos()) {
            showErrorMessage("Erro: nada foi modificado", "Altere os campos se quiser alterar o cardápio");
        }
        else {
            try {
                Cardapio editado = new Cardapio(tfPrincipal.getText(), tfVegetariano.getText(),
                        tfGuarnicao.getText(), tfSalada.getText(), tfSobremesa.getText(), tfSuco.getText());
                Fachada.getInstance().alterarCardapio(cardapio, editado);
                showInfoMessage("Alteração bem-sucedida", "Sucesso!", "Alteração realizada com sucesso");
            }
            catch (CardapioJaCadastradoException e) {
                showErrorMessage("Erro: Cardápio já existe", e.getMessage());
            }

            clearFields();
        }
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
            tfSobremesa.setText(cardapio.getSobremesa());
        }
    }

    private boolean validar() {
        if (tfGuarnicao.getText().isBlank() || tfPrincipal.getText().isBlank() || tfSalada.getText().isBlank() ||
                tfVegetariano.getText().isBlank() || tfSobremesa.getText().isBlank() || tfSuco.getText().isBlank()) {
            showErrorMessage("Erro: campos preenchidos incorretamente" , "Informe os campos solicitados corretamente");
            return false;
        }

        return true;
    }

    private void showErrorMessage(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    private boolean compararCardapioAosCampos() {
        return (tfSobremesa.getText().equals(cardapio.getSobremesa()) && tfVegetariano.getText().equals(cardapio.getVegetariano()) &&
                tfSalada.getText().equals(cardapio.getSalada()) && tfSuco.getText().equals(cardapio.getSuco()) &&
                tfPrincipal.getText().equals(cardapio.getPrincipal()) && tfGuarnicao.getText().equals(cardapio.getGuarnicao()));
    }

    private void showInfoMessage(String titulo, String header, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    private void clearFields() {
        tfSuco.setText("");
        tfPrincipal.setText("");
        tfGuarnicao.setText("");
        tfSalada.setText("");
        tfSobremesa.setText("");
        tfVegetariano.setText("");
    }

}
