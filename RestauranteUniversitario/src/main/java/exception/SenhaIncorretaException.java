package exception;

public class SenhaIncorretaException extends Exception {
    private String senha;

    public SenhaIncorretaException(String senha) {
        super("Senha informada para o usuário está incorreta.");
        this.senha = senha;
    }
}
