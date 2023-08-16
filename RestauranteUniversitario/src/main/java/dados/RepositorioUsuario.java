package dados;

import negocio.beans.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario implements IRepositorioUsuario {

    private List<Usuario> usuarios;

    @Override
    public void cadastrarUsuario(Usuario u) {
        if (!usuarios.contains(u)) {
            usuarios.add(u);
        }
    }

    @Override
    public void removerUsuario(Usuario u) {
        usuarios.remove(u);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioPorCPF(long cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf() == cpf) {
                return usuario;
            }
        }

        return null;
    }

    public ArrayList<Usuario> getUsuariosPorNome(String nome) {
        ArrayList<Usuario> usuariosList = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().contains(nome)) {
                usuariosList.add(usuario);
            }
        }

        return usuariosList;
    }

    public ArrayList<Usuario> getUsuariosPorDataNascimento(LocalDate dataNascimento) {
        ArrayList<Usuario> usuariosList = new ArrayList<>();

        return usuariosList;
    }
}
