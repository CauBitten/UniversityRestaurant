package dados;

import negocio.beans.Entrada;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEntrada implements IRepositorioEntrada {
    private List<Entrada> entradas;
    private static IRepositorioEntrada instance;

    private RepositorioEntrada() {
        entradas = new ArrayList<>();
    }

    public static IRepositorioEntrada getInstance() {
        if (instance == null) {
            instance = new RepositorioEntrada();
        }

        return instance;
    }
}
