package GUI.gerente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ButtonType;

import negocio.Fachada;

import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerListarUsuarios implements Initializable {

    @FXML
    private Button buttonAlterarUsuario;

    @FXML
    private Button buttonCadastrarUsuario;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private Button buttonRemover;

    @FXML
    private Button buttonFiltrar;

    @FXML
    private TableColumn<Usuario, Boolean> tvColAtivo;

    @FXML
    private TableColumn<Usuario, Long> tvColCPF;

    @FXML
    private TableColumn<Usuario, String> tvColEmail;

    @FXML
    private TableColumn<Usuario, String> tvColLogin;

    @FXML
    private TableColumn<Usuario, String> tvColNome;

    @FXML
    private TableColumn<Usuario, String> tvColPerfil;

    @FXML
    private TableView<Usuario> tvUsuarios;

    @FXML
    public void bttnAlterarUsuarioOn(ActionEvent event) {
        if (tvUsuarios.getSelectionModel().getSelectedItem() != null) {
            ScreenManager.getInstance().getControllerAlterarUsuarios().setUsuario(tvUsuarios.getSelectionModel().getSelectedItem());
            ScreenManager.getInstance().getControllerAlterarUsuarios().initialize();
            ScreenManager.getInstance().changeScreen(TelasEnum.ALTERAR_USUARIO.name());
        }
        else {
            showErrorMessage("Erro: Nenhum usuário selecionado", "Selecione um usuário se quiser alterar");
        }
    }

    @FXML
    public void bttnCadastrarUsuarioOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.CADASTRAR_USUARIO.name());
    }

    @FXML
    public void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

    @FXML
    void bttnRemoverOn(ActionEvent event) {
        if (tvUsuarios.getSelectionModel().getSelectedItem() != Fachada.getInstance().getUsuarioLogado()) {
            if (getConfirmation()) {
                Fachada.getInstance().removerUsuario(tvUsuarios.getSelectionModel().getSelectedItem());
                atualizarApresentacao();
            }
        }
        else {
            showErrorMessage("Erro: permissão negada", "Você não pode remover a si mesmo.");
        }
    }

    public void bttnFiltrarOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.FILTRAR_USUARIO.name());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tvColNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tvColLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        tvColCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tvColPerfil.setCellValueFactory(new PropertyValueFactory<>("perfil"));
        tvColAtivo.setCellValueFactory(new PropertyValueFactory<>("ativado"));
        tvColEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    public void configurarTv(List<Usuario> usuarios) {
        ObservableList<Usuario> userList = FXCollections.observableArrayList();

        for (Usuario u : usuarios) {
            if(!u.getNome().equals("avulso")){
                userList.add(u);
            }
        }

        tvUsuarios.setItems(userList);
    }

    private void showErrorMessage(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    public void atualizarApresentacao() {
        limparItens();
        configurarTv(Fachada.getInstance().obterUsuarios());
    }

    public void limparItens() {
        for (int i = 0; i < tvUsuarios.getItems().size(); i++)
            tvUsuarios.getItems().clear();
    }

    private boolean getConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remover usuário");
        alert.setHeaderText("Tem certeza que gostaria de remover o usuário selecionado?");
        alert.setContentText("Aviso: esta operação não pode ser desfeita.");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.OK) {
            showInfoMessage("Usuário removido", "Usuário removido com sucesso!", "A operação foi um sucesso!");
            return true;
        }
        else if (option.get() == ButtonType.CANCEL) {
            showInfoMessage("Operação cancelada", "A operação foi cancelada", "Nada foi modificado.");
            return false;
        }

        return false;
    }

    private void showInfoMessage(String titulo, String header, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setHeaderText(mensagem);
        alert.show();
    }


}