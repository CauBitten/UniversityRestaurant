package exception;

public class ClienteNaoPossuiFichasException extends Exception {
    private String tipo;

    public ClienteNaoPossuiFichasException(String tipo) {
        super("O cliente informado não possui fichas do tipo: " + tipo);
        this.tipo = tipo;
    }
}
