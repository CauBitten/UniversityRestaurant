package gui.gerente;

<<<<<<< HEAD
import dados.IRepositorioUsuario;
import dados.RepositorioUsuario;
=======
>>>>>>> 73e54048ddf5343193b462e97178f3ff8bb9bc76
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
<<<<<<< HEAD
=======
import negocio.ControladorUsuario;
import negocio.Fachada;
>>>>>>> 73e54048ddf5343193b462e97178f3ff8bb9bc76
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

<<<<<<< HEAD
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerListarUsuarios implements Initializable {
=======
import java.util.List;

public class ControllerListarUsuarios {
>>>>>>> 73e54048ddf5343193b462e97178f3ff8bb9bc76

    @FXML
    private Button buttonAlterarUsuario;

    @FXML
    private Button buttonAtualizar;

    @FXML
    private Button buttonCadastrarUsuario;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
<<<<<<< HEAD
    private TableView<Usuario> tvUser;

    @FXML
    private TableColumn<Usuario, Long> cpf;

    @FXML
    private TableColumn<Usuario, String> login;

    @FXML
    private TableColumn<Usuario, String> nome;
=======
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
>>>>>>> 73e54048ddf5343193b462e97178f3ff8bb9bc76

    @FXML
    void bttnAlterarUsuarioOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.ALTERAR_USUARIO.name());
    }

    @FXML
    void bttnAtualizarOn(ActionEvent event) {
//        IRepositorioUsuario iRepositorioUsuario = RepositorioUsuario.getInstance();
//
//        ObservableList<Usuario> userList = FXCollections.observableArrayList(iRepositorioUsuario.getUsuarios());
//        tvUser.setItems(userList);
    }

    @FXML
    void bttnCadastrarUsuarioOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.CADASTRAR_USUARIO.name());
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

<<<<<<< HEAD
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        IRepositorioUsuario iRepositorioUsuario = RepositorioUsuario.getInstance();
//
//        nome.setCellValueFactory(new PropertyValueFactory<Usuario, String >("nome"));
//        login.setCellValueFactory(new PropertyValueFactory<Usuario, String >("login"));
//        cpf.setCellValueFactory(new PropertyValueFactory<Usuario, Long >("cpf"));
//
//        ObservableList<Usuario> userList = FXCollections.observableArrayList(iRepositorioUsuario.getUsuarios());
//
//        tvUser.setItems(userList);
    }
=======
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

>>>>>>> 73e54048ddf5343193b462e97178f3ff8bb9bc76
}
