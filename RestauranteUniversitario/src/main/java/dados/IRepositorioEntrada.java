package dados;

import negocio.beans.Cardapio;
import negocio.beans.Entrada;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioEntrada {
    public void adicionarEntrada(Entrada e);
    public List<Entrada> obterEntradasDosDias(LocalDateTime dataInicio, LocalDateTime dataFim);
    public List<Entrada> obterEntradasPorClienteComMatricula(long matricula);
    public List<Entrada> obterEntradasPorTipo(String tipo);
    public Entrada obterEntradaComFichaDeID(long id);
    public List<Entrada> obterEntradasComCardapioDeID(long id);
    public void associarCardapioAoDiaeTipo(Cardapio cardapio, String tipo, String data );
    public Cardapio obterCardapioPorDiaeTipo(String data, String tipo);
}
