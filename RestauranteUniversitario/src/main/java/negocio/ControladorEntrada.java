package negocio;

import dados.IRepositorioEntrada;
import dados.RepositorioEntrada;

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
}
