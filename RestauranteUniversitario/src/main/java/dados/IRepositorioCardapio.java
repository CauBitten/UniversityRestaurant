package dados;

import negocio.beans.Cardapio;

import java.util.List;

public interface IRepositorioCardapio {

    public void cadastrarCardapio(Cardapio c);

    public Cardapio encontrarCardapioPorID(long id);

    public void removerCardapio(Cardapio c);

    public List<Cardapio> getCardapios();

    public void alterarCardapio(Cardapio c, Cardapio editado);

}
