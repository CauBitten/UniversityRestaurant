package gui.gerente;

import dados.IRepositorioUsuario;
import dados.RepositorioUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerListarUsuarios implements Initializable {

    @FXML
    private Button buttonAlterarUsuario;

    @FXML
    private Button buttonAtualizar;

    @FXML
    private Button buttonCadastrarUsuario;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private TableView<Usuario> tvUser;

    @FXML
    private TableColumn<Usuario, Long> cpf;

    @FXML
    private TableColumn<Usuario, String> login;

    @FXML
    private TableColumn<Usuario, String> nome;

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
}
