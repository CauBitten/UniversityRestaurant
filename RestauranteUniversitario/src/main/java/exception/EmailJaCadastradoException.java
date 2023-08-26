package exception;

import negocio.beans.Usuario;

public class EmailJaCadastradoException extends Exception {
    private Usuario usuario;

    public EmailJaCadastradoException(Usuario igual) {
        super("Já existe um usuário com o mesmo e-mail, de login: " + igual.getLogin());
        this.usuario = igual;
    }
}
