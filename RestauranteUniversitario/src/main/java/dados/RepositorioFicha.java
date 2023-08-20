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

    public void adicionarFicha(Ficha f) {
        Ficha ficha = obterFichaComCodigo(f.getCodigo());

        if (ficha != null) {
            //adicionar exceção ficha ja existe
        }
        else {
            fichas.add(f);
        }
    }

    public Ficha removerFicha(Ficha f) {
        if (f != null) {
            fichas.remove(f);
        }

        return f;
    }

    public Ficha obterFichaComCodigo(long codigo) {
        for (Ficha ficha : fichas) {
            if (ficha.getCodigo() == codigo)
                return ficha;
        }

        return null;
    }

    public List<Ficha> obterFichasComClienteDeMatricula(long matricula) {
        List<Ficha> fichasPorCliente = new ArrayList<>();

        for (Ficha ficha : fichas) {
            long matriculaDoCliente = ficha.getCliente().getMatricula();

            if (matriculaDoCliente == matricula)
                fichasPorCliente.add(ficha);
        }

        return fichasPorCliente;
    }
}
