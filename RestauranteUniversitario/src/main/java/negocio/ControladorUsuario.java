package negocio;

import dados.IRepositorioUsuario;
import negocio.beans.Usuario;

import java.time.LocalDate;
import java.util.List;

public class ControladorUsuario {

    private IRepositorioUsuario repositorioUsuarios;
    private static ControladorUsuario instance;

    private ControladorUsuario() {
        this.repositorioUsuarios = getInstance().repositorioUsuarios;
    }

    public static ControladorUsuario getInstance() {
        if (instance == null) {
            instance = new ControladorUsuario();
        }

        return instance;
    }

    public void cadastrarUsuario(Usuario u) {
        if (u != null) {
            repositorioUsuarios.cadastrarUsuario(u);
        }
    }

    public void removerUsuario(long cpf) {
        Usuario u = repositorioUsuarios.getUsuarioPorCPF(cpf);

        if (u != null) {
            repositorioUsuarios.removerUsuario(u);
        }
    }

    public List<Usuario> listarUsuarios() {
        return repositorioUsuarios.getUsuarios();
    }

    public Usuario getUsuarioPorCPF(long cpf) {
        return repositorioUsuarios.getUsuarioPorCPF(cpf);
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
}
