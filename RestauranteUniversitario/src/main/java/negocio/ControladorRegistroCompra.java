package negocio;

import dados.IRepositorioRegistroCompra;
import negocio.beans.RegistroCompra;

import java.util.List;

public class ControladorRegistroCompra{

    private IRepositorioRegistroCompra repositorioRegistroCompra;

    private static ControladorRegistroCompra instance;

    private ControladorRegistroCompra() {
        this.repositorioRegistroCompra = instance.repositorioRegistroCompra;
    }

    public static ControladorRegistroCompra getInstance() {
        if (instance == null) {
            instance = new ControladorRegistroCompra();
        }

        return instance;
    }

    public void cadastrarRegistroCompra(RegistroCompra rc) {
        if (rc != null) {
            repositorioRegistroCompra.cadastrarRegistroCompra(rc);
        }
    }

    public void removerRegistroCompra(RegistroCompra rc) {
        if (rc != null) {
            repositorioRegistroCompra.removerRegistroCompra(rc);
        }
    }

    public List<RegistroCompra> getListaRegistroCompra() {
        return repositorioRegistroCompra.getListaRegistroCompra();
    }
}
