package GUI.catraca;

import exception.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.beans.Entrada;
import negocio.beans.Ficha;
import negocio.beans.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ControllerCatraca {

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfSenha;

    @FXML
    void entrarButtonClicked(ActionEvent event) {
        permitirEntrada();
    }

    private boolean permitirEntrada() {
        if (!camposEstaoVazios()) {
            try {
                Usuario cliente = Fachada.getInstance().validarCredenciais(tfLogin.getText(), tfSenha.getText());
                Entrada e = new Entrada(Fachada.getInstance().obterCardapioPorDiaETipo(LocalDate.now(), "Almoco"),
                        "Almoco", LocalDateTime.now(), Fachada.getInstance().obterFichaDoClienteDoTipo(cliente, "Almoco"));
                Fachada.getInstance().registrarEntrada(e);
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
            catch (EntradaJaRealizadaNesteTurnoException e) {
                showErrorAlert("Erro: usuário informado já entrou neste turno", e.getMessage(), "Tente mais tarde");
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
