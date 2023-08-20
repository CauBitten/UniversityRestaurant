package dados;

import negocio.beans.Cardapio;

public interface IRepositorioCardapio {

    public void cadastrarCardapio(Cardapio c);

    public Cardapio encontrarCardapioPorID(long id);

    public void removerCardapio(Cardapio c);
}
