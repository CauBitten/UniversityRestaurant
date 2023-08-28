package exception;

public class SenhaInvalidaException extends Exception {

    private String senha;

    public SenhaInvalidaException(String senha) {
        super("A senha deve ter no mínimo 4 caracteres");
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
