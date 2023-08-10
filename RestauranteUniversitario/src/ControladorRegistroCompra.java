import java.util.List;

public class ControladorRegistroCompra implements IRepositorioRegistroCompra {

    private IRepositorioRegistroCompra iRepositorioRegistroCompra;

    private static ControladorRegistroCompra instance;

    ControladorRegistroCompra (IRepositorioRegistroCompra iRepositorioRegistroCompra) {
        this.iRepositorioRegistroCompra = instance.iRepositorioRegistroCompra;
    }

    public static ControladorRegistroCompra getInstance(IRepositorioRegistroCompra iRepositorioRegistroCompra) {
        if (instance == null) {
            instance = new ControladorRegistroCompra(iRepositorioRegistroCompra);
        }
        return instance;
    }

    @Override
    public void cadastrarRegistroCompra(RegistroCompra rc) {
        if (rc != null) {
            iRepositorioRegistroCompra.cadastrarRegistroCompra(rc);
        }
    }

    @Override
    public void removerRegistroCompra(RegistroCompra rc) {
        if (rc != null) {
            iRepositorioRegistroCompra.removerRegistroCompra(rc);
        }
    }

    @Override
    public List<RegistroCompra> getListaRegistroCompra() {
        return iRepositorioRegistroCompra.getListaRegistroCompra();
    }
}
