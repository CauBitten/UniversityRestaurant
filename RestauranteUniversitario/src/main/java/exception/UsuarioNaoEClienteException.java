package exception;

import negocio.beans.Usuario;

public class UsuarioNaoEClienteException extends Exception {
    private Usuario usuario;

    public UsuarioNaoEClienteException(Usuario u) {
        super("O usuário de login: " + u.getLogin() + " não é do tipo cliente.");
        this.usuario = u;
    }
}
