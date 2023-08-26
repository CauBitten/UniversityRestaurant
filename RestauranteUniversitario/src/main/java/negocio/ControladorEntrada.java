package negocio;

import dados.IRepositorioEntrada;
import dados.RepositorioEntrada;
import negocio.beans.Cardapio;
import negocio.beans.Entrada;

import java.util.List;

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

    public void adicionarEntrada(Entrada e) {
        repositorioEntrada.adicionarEntrada(e);
    }

    public List<Entrada> getListaEntrada() {
        return repositorioEntrada.getListaEntrada();
    }
}
