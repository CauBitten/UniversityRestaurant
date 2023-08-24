package negocio;

import dados.IRepositorioEntrada;
import dados.RepositorioEntrada;
import negocio.beans.Cardapio;

public class ControladorEntrada {
    private IRepositorioEntrada repositorioEntrada;
    private static ControladorEntrada instance;

    private ControladorEntrada() {
        this.repositorioEntrada = RepositorioEntrada.getInstance();
    }

    public static ControladorEntrada getInstance() {
        if (instance == null) {
            instance = new ControladorEntrada();
        }
        return instance;
    }
    public void cadastrarCardapioAEntrada(Cardapio cardapio, String tipo, String data){
        repositorioEntrada.associarCardapioAoDiaeTipo(cardapio, tipo, data);
    }
    public Cardapio obterCardapioDaEntrada(String data, String tipo){
        return repositorioEntrada.obterCardapioPorDiaeTipo(data, tipo);
    }
}
