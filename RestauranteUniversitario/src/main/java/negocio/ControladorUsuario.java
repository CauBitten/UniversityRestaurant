package negocio;

import dados.IRepositorioUsuario;
import dados.RepositorioUsuario;
import exception.*;
import negocio.beans.Usuario;

import java.time.LocalDate;
import java.util.List;

public class ControladorUsuario {

    private IRepositorioUsuario repositorioUsuarios;
    private static ControladorUsuario instance;

    private ControladorUsuario() {
        this.repositorioUsuarios = RepositorioUsuario.getInstance();
    }

    public static ControladorUsuario getInstance() {
        if (instance == null) {
            instance = new ControladorUsuario();
        }

        return instance;
    }

    public void cadastrarUsuario(Usuario u) throws CpfJaCadastradoException, LoginJaCadastradoException,
            EmailJaCadastradoException {
        if (u != null) {
            repositorioUsuarios.cadastrarUsuario(u);
        }
    }

    public void removerUsuario(Usuario u) {
        if (u != null) {
            long cpf = u.getCpf();

            if (repositorioUsuarios.getUsuarioPorCPF(cpf) != null) {
                this.repositorioUsuarios.removerUsuario(u);
            }
        }
    }

    public List<Usuario> listarUsuarios() {
        return repositorioUsuarios.getUsuarios();
    }

    public Usuario getUsuarioPorCPF(long cpf) {
        if (cpf >= 0) {
            return repositorioUsuarios.getUsuarioPorCPF(cpf);
        }

        return null;
    }

    public Usuario getUsuarioPorLogin(String login) {
        return repositorioUsuarios.getUsuarioPorLogin(login);
    }

    public Usuario getUsuarioDeCredenciais(String login, String senha) throws SenhaIncorretaException,
            LoginNaoExisteException, UsuarioDesativadoException {
        if (login != null && senha != null)
            return this.repositorioUsuarios.obterUsuarioDeCredenciais(login, senha);
        else
            return null;
    }

    public void alterarUsuario(Usuario user, Usuario editado) throws LoginJaCadastradoException, CpfJaCadastradoException,
            EmailJaCadastradoException {
        this.repositorioUsuarios.alterarUsuario(user, editado);
    }
    public Usuario getAvulso(){
        return getUsuarioPorCPF(000L);
    }

    public List<Usuario> obterUsuariosComInformacoesContidasEm(Usuario modelo) {
        return this.repositorioUsuarios.obterUsuariosComInformacoesContidasEm(modelo);
    }

}
