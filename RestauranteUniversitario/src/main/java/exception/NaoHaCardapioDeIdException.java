package exception;

public class NaoHaCardapioDeIdException extends Exception {
    private long id;

    public NaoHaCardapioDeIdException(long id) {
        super("Não há cardápio com o id: " + id + " cadastrado");
        this.id = id;
    }
}
