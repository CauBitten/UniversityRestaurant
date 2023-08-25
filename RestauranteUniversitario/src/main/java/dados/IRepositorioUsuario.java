package dados;

import negocio.beans.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface IRepositorioUsuario {

    void cadastrarUsuario(Usuario u);

    void removerUsuario(Usuario u);

    List<Usuario> getUsuarios();

    List<Usuario> getUsuariosPorNome(String nome);

    List<Usuario> getUsuariosPorDataNascimento(LocalDate dataNascimento);

    Usuario getUsuarioPorCPF(long cpf);

    Usuario getUsuarioPorLogin(String login);

    List<Usuario> getUsuariosPorAtivacao(boolean ativo);

    Usuario obterUsuarioDeCredenciais(String login, String senha);

    List<Usuario> getUsuariosComPerfil(String perfil);

    void alterarUsuario(Usuario user, Usuario editado);

    public Usuario getUsuarioPorEmail(String email);

}
