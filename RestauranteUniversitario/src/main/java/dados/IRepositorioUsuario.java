package dados;

import negocio.beans.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface IRepositorioUsuario {

    public void cadastrarUsuario (Usuario u);

    public void removerUsuario (Usuario u);

    public List<Usuario> getUsuarios();

    public List<Usuario> getUsuariosPorNome(String nome);

    public List<Usuario> getUsuariosPorDataNascimento(LocalDate dataNascimento);

    public Usuario getUsuarioPorCPF(long cpf);

    public Usuario getUsuarioPorLogin(String login);

    public List<Usuario> getUsuariosPorAtivacao(boolean ativo);

}
