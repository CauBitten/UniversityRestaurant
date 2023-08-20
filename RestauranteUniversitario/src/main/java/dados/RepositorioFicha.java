package dados;

import negocio.beans.Ficha;

import java.util.ArrayList;
import java.util.List;

public class RepositorioFicha implements IRepositorioFicha {
    private List<Ficha> fichas;
    private static IRepositorioFicha instance;

    private RepositorioFicha() {
        fichas = new ArrayList<>();
    }

    public static IRepositorioFicha getInstance() {
        if (instance == null) {
            instance = new RepositorioFicha();
        }

        return instance;
    }
}
