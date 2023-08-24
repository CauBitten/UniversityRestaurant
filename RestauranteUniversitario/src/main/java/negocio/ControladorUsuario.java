package negocio;

import dados.IRepositorioUsuario;
import dados.RepositorioUsuario;
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

    public void cadastrarUsuario(Usuario u) {
        if (u != null) {
            if (repositorioUsuarios.getUsuarioPorCPF(u.getCpf()) != null) {
                //trhow exceção cpf cadastrado
            }
            else if (repositorioUsuarios.getUsuarioPorLogin(u.getLogin()) != null) {
                //threow exceção login cadastrado
            }
            else {
                repositorioUsuarios.cadastrarUsuario(u);
            }
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

    public List<Usuario> listarUsuariosPorDataNascimento(LocalDate dataNascimento) {
        return repositorioUsuarios.getUsuariosPorDataNascimento(dataNascimento);
    }

    public List<Usuario> listarUsuariosAtivos(boolean ativo) {
        return repositorioUsuarios.getUsuariosPorAtivacao(ativo);
    }

    public List<Usuario> listarUsuariosPorNome(String nome) {
        return repositorioUsuarios.getUsuariosPorNome(nome);
    }

    public Usuario getUsuarioPorLogin(String login) {
        return repositorioUsuarios.getUsuarioPorLogin(login);
    }

    public Usuario getUsuarioDeCredenciais(String login, String senha) {
        if (login != null && senha != null)
            return this.repositorioUsuarios.obterUsuarioDeCredenciais(login, senha);
        else
            return null;
    }

    public void alterarUsuario(Usuario user, Usuario editado) {
        this.repositorioUsuarios.alterarUsuario(user, editado);
    }
}
