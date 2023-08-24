package dados;

import negocio.beans.Cliente;
import negocio.beans.Ficha;
import negocio.beans.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioFicha implements IRepositorioFicha {
    private List<Ficha> fichas;
    private static IRepositorioFicha instance;

    private RepositorioFicha() {
        fichas = new ArrayList<>();
    }

    public static IRepositorioFicha getInstance() {
        if (instance == null) instance = new RepositorioFicha();

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

    public void removerFicha(Ficha f) {
        if (f != null) {
            fichas.remove(f);
        }
    }

    public Ficha obterFichaComCodigo(long codigo) {
        for (Ficha ficha : fichas) {
            if (ficha.getCodigo() == codigo)
                return ficha;
        }

        return null;
    }

    public List<Ficha> obterFichasDoCliente(Usuario u) {
        List<Ficha> fichasPorCliente = new ArrayList<>();

        for (Ficha ficha : fichas) {
            Cliente cliente = ficha.getCliente();

            if (u.equals(cliente))
                fichasPorCliente.add(ficha);
        }

        return fichasPorCliente;
    }

    public List<Ficha> obterFichasDoTipo(String tipo) {
        List<Ficha> fichasPorTipo = new ArrayList<>();

        for (Ficha ficha : fichas) {
            if (tipo.equals(ficha.getTipo()))
                fichasPorTipo.add(ficha);
        }

        return fichasPorTipo;
    }

    public List<Ficha> obterFichasCompradasNoIntervalo(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        //implementar
        List<Ficha> fichasDoIntervalo = new ArrayList<>();

        return fichasDoIntervalo;
    }
}
