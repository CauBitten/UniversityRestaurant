package exception;

import negocio.beans.Usuario;

public class UsuarioDesativadoException extends Exception {
    private Usuario usuario;

    public UsuarioDesativadoException(Usuario u) {
        super("O usuário de login: " + u.getLogin() + " está desativado.");
        this.usuario = u;
    }
}
