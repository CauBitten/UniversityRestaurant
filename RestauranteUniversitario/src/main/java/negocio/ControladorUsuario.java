package negocio;

import dados.IRepositorioUsuario;
import negocio.beans.Usuario;

import java.util.List;

public class ControladorUsuario implements IRepositorioUsuario {

    private IRepositorioUsuario iRepositorioUsuario;

    private static ControladorUsuario instance;

    ControladorUsuario (IRepositorioUsuario iRepositorioUsuario) {
        this.iRepositorioUsuario = iRepositorioUsuario;
    }

    public static ControladorUsuario getInstance(IRepositorioUsuario iRepositorioUsuario) {
        if (instance == null) {
            instance = new ControladorUsuario(iRepositorioUsuario);
        }
        return instance;
    }

    @Override
    public void cadastrarUsuario(Usuario u) {
        if (u != null) {
            iRepositorioUsuario.cadastrarUsuario(u);
        }
    }

    @Override
    public void removerUsuario(Usuario u) {
        if (u != null) {
            iRepositorioUsuario.removerUsuario(u);
        }
    }

    @Override
    public List<Usuario> getListaUsuario() {
        return iRepositorioUsuario.getListaUsuario();
    }
}
