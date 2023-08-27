package dados;

import exception.*;
import negocio.beans.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface IRepositorioUsuario {

    void cadastrarUsuario(Usuario u) throws CpfJaCadastradoException, LoginJaCadastradoException,
            EmailJaCadastradoException, CPFInvalidoException;

    void removerUsuario(Usuario u);

    List<Usuario> getUsuarios();

    Usuario getUsuarioPorCPF(long cpf);

    Usuario getUsuarioPorLogin(String login);

    Usuario obterUsuarioDeCredenciais(String login, String senha) throws SenhaIncorretaException,
            LoginNaoExisteException, UsuarioDesativadoException;

    void alterarUsuario(Usuario user, Usuario editado) throws LoginJaCadastradoException, CpfJaCadastradoException,
            EmailJaCadastradoException, CPFInvalidoException;

    List<Usuario> obterUsuariosComInformacoesContidasEm(Usuario modelo);

    Usuario validarUsuarioParaCompra(String login) throws UsuarioDesativadoException,
            UsuarioNaoEClienteException, LoginNaoExisteException;

}
