package dados;

import exception.CardapioJaCadastradoException;
import exception.NaoHaCardapioDeIdException;
import negocio.beans.Cardapio;

import java.util.List;

public interface IRepositorioCardapio {

    void cadastrarCardapio(Cardapio c) throws CardapioJaCadastradoException;

    Cardapio encontrarCardapioPorID(long id) throws NaoHaCardapioDeIdException;

    void removerCardapio(Cardapio c);

    List<Cardapio> getCardapios();

    void alterarCardapio(Cardapio c, Cardapio editado) throws CardapioJaCadastradoException;

    List<Cardapio> obterCardapiosComOsPratosIguaisA(Cardapio modelo);

}
