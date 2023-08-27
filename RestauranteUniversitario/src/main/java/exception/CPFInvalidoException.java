package exception;

public class CPFInvalidoException extends Exception {
    private Long cpf;

    public CPFInvalidoException(Long cpf) {
        super("O CPF informado é inválido, pois deve possuir 11 caracteres.");
        this.cpf = cpf;
    }

    public Long getCpf() {
        return cpf;
    }
}
