package gui.gerente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.ControladorUsuario;
import negocio.Fachada;
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

import java.util.List;

public class ControllerListarUsuarios {

    @FXML
    private Button buttonAlterarUsuario;

    @FXML
    private Button buttonCadastrarUsuario;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private TableColumn<Usuario, Boolean> tblColAtivo;

    @FXML
    private TableColumn<Usuario, Long> tblColCPF;

    @FXML
    private TableColumn<Usuario, String> tblColLogin;

    @FXML
    private TableColumn<Usuario, String> tblColNome;

    @FXML
    private TableColumn<Usuario, String> tblColPerfil;

    @FXML
    private TableView<Usuario> tblUsuarios;

    @FXML
    void bttnAlterarUsuarioOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.ALTERAR_USUARIO.name());
    }

    @FXML
    void bttnCadastrarUsuarioOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.CADASTRAR_USUARIO.name());
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

    public void configurarListaDeUsuarios(List<Usuario> usuarios) {
        ObservableList<Usuario> lista = FXCollections.observableArrayList();

        lista.addAll(usuarios);
        tblUsuarios.setItems(lista);
    }

    @FXML
    public void listarUsuarios() {
        configurarListaDeUsuarios(ControladorUsuario.getInstance().listarUsuarios());
    }

    private void initialize() {
        tblColNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblColCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tblColLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        tblColAtivo.setCellValueFactory(new PropertyValueFactory<>("ativado"));
        tblColPerfil.setCellValueFactory(new PropertyValueFactory<>("perfil"));
    }

}
