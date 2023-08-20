package negocio;

import dados.IRepositorioFicha;

public class ControladorFicha {
    private IRepositorioFicha repositorioFicha;
    private static ControladorFicha instance;

    private ControladorFicha() {
        this.repositorioFicha = instance.repositorioFicha;
    }

    public static ControladorFicha getInstance() {
        if (instance == null) {
            instance = new ControladorFicha();
        }

        return instance;
    }
}
