package dados;

import negocio.beans.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario implements IRepositorioUsuario {

    private List<Usuario> usuarios;
    private static IRepositorioUsuario instance;

    private RepositorioUsuario() {
        usuarios = new ArrayList<Usuario>();
    }

    public static IRepositorioUsuario getInstance() {
        if (instance == null) {
            instance = new RepositorioUsuario();
        }

        return instance;
    }

    @Override
    public void cadastrarUsuario(Usuario u) {
        if (u != null) {
            if (getUsuarioPorCPF(u.getCpf()) == null) {
                usuarios.add(u);
            }
        }
    }

    @Override
    public void removerUsuario(Usuario u) {
        if (u != null) {
            if (getUsuarioPorCPF(u.getCpf()) != null) {
                usuarios.remove(u);
            }
        }
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public Usuario getUsuarioPorCPF(long cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf() == cpf) {
                return usuario;
            }
        }

        return null;
    }

    @Override
    public List<Usuario> getUsuariosPorNome(String nome) {
        if (nome != null) {
            List<Usuario> usuariosList = new ArrayList<>();

            for (Usuario usuario : usuarios) {
                if (usuario.getNome().contains(nome)) {
                    usuariosList.add(usuario);
                }
            }

            return usuariosList;
        }

        return null;
    }

    @Override
    public List<Usuario> getUsuariosPorDataNascimento(LocalDate dataNascimento) {
        List<Usuario> usuariosList = new ArrayList<>();

        return usuariosList;
    }

    @Override
    public Usuario getUsuarioPorLogin(String login) {
        if (login != null) {
            for (Usuario usuario : usuarios) {
                if (login.equals(usuario.getLogin())) {
                    return usuario;
                }
            }
        }

        return null;
    }

    @Override
    public List<Usuario> getUsuariosPorAtivacao(boolean ativo) {
        List<Usuario> listaUsuarios = new ArrayList<>();

        if (ativo) {
            for (Usuario usuario : usuarios) {
                if (usuario.isAtivado()) {
                    listaUsuarios.add(usuario);
                }
            }
        }
        else {
            for (Usuario usuario : usuarios) {
                if (!usuario.isAtivado()) {
                    listaUsuarios.add(usuario);
                }
            }
        }

        return listaUsuarios;
    }
}
