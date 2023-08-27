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
                System.out.println(Fachada.getInstance().getListaEntrada());
                Usuario cliente = Fachada.getInstance().validarCredenciais(tfLogin.getText(), tfSenha.getText());
                String tipo = avaliarHorario();

                if (tipo != null) {
                    Entrada e = new Entrada(Fachada.getInstance().obterCardapioPorDiaETipo(LocalDateTime.now().toLocalDate(),
                            tipo), tipo, LocalDateTime.now(), Fachada.getInstance().obterFichaDoClienteDoTipo(cliente, tipo));
                    Fachada.getInstance().registrarEntrada(e);
                }
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
            catch (DiaNaoPossuiCardapioCadastradoException e) {
                showErrorAlert("Erro: o dia não possui cardápio cadastrado", e.getMessage(), "Tente outro dia");
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

    private String avaliarHorario() {
        if (LocalDateTime.now().getHour() > 9 && LocalDateTime.now().getHour() < 15) {
            return "Almoco";
        }
        else if (LocalDateTime.now().getHour() > 17 && LocalDateTime.now().getHour() < 23) {
            return "Janta";
        }
        else {
            showErrorAlert("Erro: acesso negado", "O restaurante está fechado no momento",
                    "Por favor, retorne outra hora");
            return null;
        }
    }

}
