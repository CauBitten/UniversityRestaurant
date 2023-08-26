package exception;

public class LoginNaoExisteException extends Exception {
    private String login;

    public LoginNaoExisteException(String login) {
        super("O usuário com login informado não existe.");
        this.login = login;
    }
}
