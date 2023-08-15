package dados;

import negocio.beans.Usuario;

import java.util.List;

public interface IRepositorioUsuario {

    public void cadastrarUsuario (Usuario u);

    public void removerUsuario (Usuario u);

    public List<Usuario> getListaUsuario();
}
