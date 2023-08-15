package dados;

import negocio.beans.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario implements IRepositorioUsuario {

    private List<Usuario> listaUsuario = new ArrayList<>();

    @Override
    public void cadastrarUsuario (Usuario u) {
        if (!listaUsuario.contains(u)) {

            listaUsuario.add(u);
        }
    }

    @Override
    public void removerUsuario (Usuario u) {
        listaUsuario.remove(u);
    }

    @Override
    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

}
