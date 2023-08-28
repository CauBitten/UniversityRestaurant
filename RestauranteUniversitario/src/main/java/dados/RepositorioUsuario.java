package dados;

import exception.*;
import negocio.beans.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario implements IRepositorioUsuario {

    private List<Usuario> usuarios;
    private static IRepositorioUsuario instance;

    public RepositorioUsuario() {
        Usuario admin = new Usuario("123","admin","admin@","admin", 123L, true, "Gerente");
        Usuario avulso = new Usuario("123","cliente","cliente@","avulso", 0L, true, "Cliente");
        Usuario online = new Usuario("123", "online", "online@", "online", 1L, true, "Vendedor");
        usuarios = new ArrayList<>();
        usuarios = ArquivosUsuarios.recuperarAtributosDeArquivo("usuarios.txt");
        usuarios.add(admin);
        usuarios.add(avulso);
        usuarios.add(online);

    }

    public static IRepositorioUsuario getInstance() {
        if (instance == null) {
            instance = new RepositorioUsuario();
        }

        return instance;
    }

    @Override
    public void cadastrarUsuario(Usuario u) throws CpfJaCadastradoException, LoginJaCadastradoException,
            EmailJaCadastradoException, CPFInvalidoException {
        if (u != null) {
            if (getUsuarioPorCPF(u.getCpf()) != null) {
                throw new CpfJaCadastradoException(getUsuarioPorCPF(u.getCpf()));
            }

            if (Long.toString(u.getCpf()).length() != 11) {
                throw new CPFInvalidoException(u.getCpf());
            }

            if (getUsuarioPorLogin(u.getLogin()) != null) {
                throw new LoginJaCadastradoException(getUsuarioPorLogin(u.getLogin()));
            }

            if (getUsuarioPorEmail(u.getEmail()) != null) {
                throw new EmailJaCadastradoException(getUsuarioPorEmail(u.getEmail()));
            }
            ArquivosUsuarios.salvarAtributosEmArquivo("usuarios.txt", u);
            usuarios.add(u);
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

    private Usuario getUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email))
                return usuario;
        }

        return null;
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
    public void alterarUsuario(Usuario user, Usuario editado) throws LoginJaCadastradoException, CpfJaCadastradoException,
            EmailJaCadastradoException, CPFInvalidoException {
        if (getUsuarioPorLogin(editado.getLogin()) != null &&
                getUsuarioPorLogin(editado.getLogin()) != user) {
            throw new LoginJaCadastradoException(getUsuarioPorLogin(editado.getLogin()));
        }
        else if (getUsuarioPorCPF(editado.getCpf()) != null &&
            getUsuarioPorCPF(editado.getCpf()) != user) {
            throw new CpfJaCadastradoException(getUsuarioPorCPF(editado.getCpf()));
        }
        else if (getUsuarioPorEmail(editado.getEmail()) != null
                && getUsuarioPorEmail(editado.getEmail()) != user) {
            throw new EmailJaCadastradoException(getUsuarioPorEmail(editado.getEmail()));
        }
        else if (Long.toString(editado.getCpf()).length() != 11) {
            throw new CPFInvalidoException(editado.getCpf());
        }
        else {
            for (Usuario usuario : usuarios) {
                if (user.getLogin().equals(usuario.getLogin())) {
                    usuario.setNome(editado.getNome());
                    usuario.setAtivado(editado.isAtivado());
                    usuario.setPerfil(editado.getPerfil());
                    usuario.setLogin(editado.getLogin());
                    usuario.setEmail(editado.getEmail());
                    usuario.setCpf(editado.getCpf());
                    usuario.setSenha(editado.getSenha());
                }
            }
        }
    }

    public Usuario obterUsuarioDeCredenciais(String login, String senha) throws SenhaIncorretaException,
            LoginNaoExisteException, UsuarioDesativadoException {
        for (Usuario usuario : usuarios) {
            if (login.equals(usuario.getLogin())) {
                if (!usuario.isAtivado()) {
                    throw new UsuarioDesativadoException(usuario);
                }

                if (senha.equals(usuario.getSenha()))
                    return usuario;
                else
                    throw new SenhaIncorretaException(senha);
            }
        }

        throw new LoginNaoExisteException(login);
    }

    @Override
    public List<Usuario> obterUsuariosComInformacoesContidasEm(Usuario modelo) {
        List<Usuario> usuariosFiltrados = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (compararUsuarioAoModelo(usuario, modelo))
                usuariosFiltrados.add(usuario);
        }

        return usuariosFiltrados;
    }

    @Override
    public Usuario validarUsuarioParaCompra(String login) throws UsuarioDesativadoException,
            UsuarioNaoEClienteException, LoginNaoExisteException {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                if (!usuario.isAtivado())
                    throw new UsuarioDesativadoException(usuario);

                if (!usuario.getPerfil().equals("Cliente"))
                    throw new UsuarioNaoEClienteException(usuario);

                return usuario;
            }
        }

        throw new LoginNaoExisteException(login);
    }

    private boolean compararUsuarioAoModelo(Usuario u, Usuario modelo) {
        return u.getNome().contains(modelo.getNome()) && u.getPerfil().contains(modelo.getPerfil())
                && u.getLogin().contains(modelo.getLogin()) && u.getEmail().contains(modelo.getEmail()) &&
                u.isAtivado() == modelo.isAtivado();
    }
}
