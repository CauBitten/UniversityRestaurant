package GUI.gerente;

import exception.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import negocio.Fachada;
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;


import static java.lang.Long.parseLong;

public class ControllerAlterarUsuarios {

    private Usuario usuario;

    @FXML
    private CheckBox checkBoxAtivo;

    @FXML
    private ChoiceBox<String> choiceBoxTipo;

    @FXML
    private PasswordField senhaField;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfNome;

    @FXML
    void bttnAlterarOn(ActionEvent event) {
        if (!verificarCampos()) {
            if (compararUsuarioAosCampos()) {
                showErrorMessage("Erro: usuário não modificado", "Usuário não modificado",
                        "Altere os campos para poder modificar");
            }
            else {
                try {
                    Usuario editado = new Usuario(senhaField.getText(), tfLogin.getText(), tfEmail.getText(), tfNome.getText(),
                            parseLong(tfCPF.getText()), checkBoxAtivo.isSelected(), choiceBoxTipo.getValue());

                    Fachada.getInstance().alterarUsuario(usuario, editado);
                    showInfoMessage("Alteração bem-sucedida", "Sucesso!", "Alteração realizada com sucesso");
                }
                catch (CpfJaCadastradoException e) {
                    showErrorMessage("Erro: CPF já cadastrado", e.getMessage(), "Tente novamente");
                }
                catch (LoginJaCadastradoException e) {
                    showErrorMessage("Erro: Login já cadastrado", e.getMessage(), "Tente novamente");
                }
                catch (EmailJaCadastradoException e) {
                    showErrorMessage("Erro: E-mail já cadastrado", e.getMessage(), "Tente novamente");
                }
                catch (CPFInvalidoException e) {
                    showErrorMessage("Erro: CPF inválido", e.getMessage(), "Corrija e tente novamente");
                }
                catch (LoginInvalidoException e) {
                    showErrorMessage("Erro: Login inválido", e.getMessage(), "Corrija e tente novamente");
                }
                catch (SenhaInvalidaException e) {
                    showErrorMessage("Erro: Senha inválida", e.getMessage(), "Corrija e tente novamente");
                }

                ScreenManager.getInstance().getControllerListarUsuarios().atualizarApresentacao();
                ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_USUARIO.name());
            }
        }
        else {
            showErrorMessage("Erro: campos vazios", "Os campos não podem ser vazios",
                    "Por favor, altere e tente outra vez");
        }
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        usuario = null;
        ScreenManager.getInstance().getControllerListarUsuarios().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_USUARIO.name());
    }

    public void initialize() {
        if (usuario != null) {
            tfLogin.setText(usuario.getLogin());
            tfNome.setText(usuario.getNome());
            tfEmail.setText(usuario.getEmail());
            tfCPF.setText(Long.toString(usuario.getCpf()));
            senhaField.setText(usuario.getSenha());
            choiceBoxTipo.setValue(usuario.getPerfil());
            checkBoxAtivo.setSelected(usuario.isAtivado());
        }

        if (choiceBoxTipo.getItems().isEmpty()) {
            choiceBoxTipo.getItems().addAll("Gerente", "Vendedor", "Cliente");
        }
    }

    public void setUsuario(Usuario u) {
        if (u != null) {
            usuario = u;
        }
    }

    private void showErrorMessage(String titulo, String header, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(mensagem);
        alert.show();
    }

    private void showInfoMessage(String titulo, String header, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    private boolean verificarCampos() {
        return tfNome.getText().isBlank() || tfEmail.getText().isBlank() || tfLogin.getText().isBlank() ||
                senhaField.getText().isBlank() || choiceBoxTipo.getValue() == null || tfCPF.getText().isBlank();
    }

    private boolean compararUsuarioAosCampos() {
        return tfNome.getText().equals(usuario.getNome()) && tfEmail.getText().equals(usuario.getEmail()) &&
                tfLogin.getText().equals(usuario.getLogin()) && senhaField.getText().equals(usuario.getSenha())
                && (checkBoxAtivo.isSelected() == usuario.isAtivado()) && choiceBoxTipo.getValue().equals(usuario.getPerfil()) &&
                (parseLong(tfCPF.getText()) == usuario.getCpf());
    }

}
