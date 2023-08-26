package exception;

import negocio.beans.Usuario;

public class LoginJaCadastradoException extends Exception {
    private Usuario usuario;

    public LoginJaCadastradoException(Usuario igual) {
        super("Já existe um usuário com o mesmo login: " + igual.getLogin());
        this.usuario = igual;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
}
