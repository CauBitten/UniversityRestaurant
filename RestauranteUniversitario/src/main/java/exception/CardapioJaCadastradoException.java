package exception;

import negocio.beans.Cardapio;

public class CardapioJaCadastradoException extends Exception {
    private Cardapio cardapioJaExistente;

    public CardapioJaCadastradoException(Cardapio JaExiste) {
        super("Já existe um cardápio igual cadastrado, seu ID é: " + JaExiste.getId());
        this.cardapioJaExistente = JaExiste;
    }

    public Cardapio getCardapioJaExistente() {
        return cardapioJaExistente;
    }
}
