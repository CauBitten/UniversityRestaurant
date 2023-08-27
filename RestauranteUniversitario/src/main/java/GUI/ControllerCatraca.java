package GUI;

import exception.ClienteNaoPossuiFichasException;
import exception.LoginNaoExisteException;
import exception.SenhaIncorretaException;
import exception.UsuarioDesativadoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.beans.Ficha;

public class ControllerCatraca {

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfSenha;

    @FXML
    void entrarButtonClicked(ActionEvent event) {

    }

    private boolean permitirEntrada() {
        if (!camposEstaoVazios()) {
            try {
                Ficha f = Fachada.getInstance().obterFichaDoClienteDoTipo(
                        Fachada.getInstance().validarCredenciais(tfLogin.getText(), tfSenha.getText()), "Almoco");
            }
            catch (LoginNaoExisteException e) {
                showErrorAlert("Erro: não há usuário com este login", e.getMessage(), "Tente novamente");
            }
            catch (SenhaIncorretaException e) {
                showErrorAlert("Erro: senha incorreta", e.getMessage(), "Tente novamente");
            }
            catch (UsuarioDesativadoException e) {
                showErrorAlert("Erro: usuário desativado", e.getMessage(), "Tente novamente");
            }
            catch (ClienteNaoPossuiFichasException e) {
                showErrorAlert("Erro: usuário informado não possui fichas para este horário.",
                        e.getMessage(), "Compre fichas e tente outra vez");
            }
        }
        else {
            showErrorAlert("Erro: informações inválidas", "Preencha os campos para entrar", "Tente novamente");
        }

        return false;
    }

    private boolean camposEstaoVazios() {
        return tfLogin.getText().isBlank() && tfSenha.getText().isBlank();
    }
    private void showErrorAlert(String titulo, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
