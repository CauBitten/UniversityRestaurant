package GUI.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import negocio.Fachada;
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

import java.util.ArrayList;
import java.util.List;

public class ControllerFiltrarUsuarios {

    @FXML
    private CheckBox checkBoxAtivo;

    @FXML
    private ChoiceBox<String> choiceBoxTipo;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfNome;

    @FXML
    void bttnFiltrarOn(ActionEvent event) {
        ScreenManager.getInstance().getControllerListarUsuarios().limparItens();
        List<Usuario> usuarios = filtrar();

        if (usuarios.isEmpty())
            showErrorMessage("Erro: nenhum usuário encontrado", "A busca não retornou resultados",
                    "Tente novamente");
        else
            ScreenManager.getInstance().getControllerListarUsuarios().configurarTv(usuarios);

        clearFields();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_USUARIO.name());
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        clearFields();
        ScreenManager.getInstance().getControllerListarUsuarios().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_USUARIO.name());
    }

    private List<Usuario> filtrar() {
        List<Usuario> usuarios = new ArrayList<>();

        if (tfLogin.getText().isBlank() && tfEmail.getText().isBlank() && tfNome.getText().isBlank() &&
                choiceBoxTipo.getValue() == null && tfCPF.getText().isBlank() && !checkBoxAtivo.isSelected()) {
            usuarios = Fachada.getInstance().obterUsuarios();
        }
        else {
            Usuario modelo;

            try {
                if (choiceBoxTipo.getValue() == null) {
                    modelo = new Usuario("", tfLogin.getText(), tfEmail.getText(), tfNome.getText(),
                            Long.parseLong(tfCPF.getText()), checkBoxAtivo.isSelected(), "");
                }
                else {
                    modelo = new Usuario("", tfLogin.getText(), tfEmail.getText(), tfNome.getText(),
                            Long.parseLong(tfCPF.getText()), checkBoxAtivo.isSelected(), choiceBoxTipo.getValue());
                }

                usuarios.addAll(Fachada.getInstance().obterUsuariosComInformacoesContidasEm(modelo));
            }
            catch (NumberFormatException e) {
                showErrorMessage("Erro: CPF Inválido", "O CPF deve ser numérico", "Corrija e tente novamente");
            }
        }

        return usuarios;
    }

    public void initialize() {
        choiceBoxTipo.getItems().addAll("Gerente", "Vendedor", "Cliente");
    }

    private void showErrorMessage(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

    private void clearFields() {
        tfNome.setText("");
        tfEmail.setText("");
        tfLogin.setText("");
        tfCPF.setText("0");
        choiceBoxTipo.setValue(null);
        checkBoxAtivo.setSelected(false);
    }

}
