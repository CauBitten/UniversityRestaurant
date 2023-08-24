package dados;

import negocio.beans.Cliente;
import negocio.beans.Ficha;
import negocio.beans.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioFicha {

    public void adicionarFicha(Ficha f);

    public void removerFicha(Ficha f);

    public Ficha obterFichaComCodigo(long codigo);

    public List<Ficha> obterFichasDoCliente(Usuario u);

    public List<Ficha> obterFichasDoTipo(String tipo);

    public List<Ficha> obterFichasCompradasNoIntervalo(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);

}
