package exception;

public class LoginInvalidoException extends Exception {

    private String login;

    public LoginInvalidoException(String login) {
        super("O Login informado é inválido pois deve possuir, no mínimo, 4 caracteres e no máximo 20.");
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
