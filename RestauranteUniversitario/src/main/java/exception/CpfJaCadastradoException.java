package exception;

import negocio.beans.Usuario;

public class CpfJaCadastradoException extends Exception {
    private Usuario usuario;

    public CpfJaCadastradoException(Usuario igual) {
        super("Já existe um usuário com o mesmo CPF, de login: " + igual.getLogin());
        this.usuario = igual;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
}
