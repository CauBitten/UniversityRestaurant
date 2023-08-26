package dados;

import exception.CardapioJaCadastradoException;
import negocio.beans.Cardapio;

import java.util.List;

public interface IRepositorioCardapio {

    void cadastrarCardapio(Cardapio c) throws CardapioJaCadastradoException;

    Cardapio encontrarCardapioPorID(long id);

    void removerCardapio(Cardapio c);

    List<Cardapio> getCardapios();

    void alterarCardapio(Cardapio c, Cardapio editado) throws CardapioJaCadastradoException;

    List<Cardapio> obterCardapiosComOsPratosIguaisA(Cardapio modelo);

}
