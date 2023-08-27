package dados;

import exception.ClienteNaoPossuiFichasException;
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
        if (f != null) {
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
        List<Ficha> fichasPorUsuario = new ArrayList<>();

        for (Ficha ficha : fichas) {
            Usuario usuario = ficha.getUsuario();

            if (u.equals(usuario))
                fichasPorUsuario.add(ficha);
        }

        return fichasPorUsuario;
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

    @Override
    public Ficha obterFichaDoClienteDoTipo(Usuario u, String tipo) throws ClienteNaoPossuiFichasException {
        List<Ficha> fichasPorUsuario = new ArrayList<>();

        for (Ficha ficha : fichas) {
            Usuario usuario = ficha.getUsuario();

            if (u.equals(usuario) && ficha.getTipo().equals(tipo))
                return ficha;
        }

        throw new ClienteNaoPossuiFichasException(tipo);
    }

}
