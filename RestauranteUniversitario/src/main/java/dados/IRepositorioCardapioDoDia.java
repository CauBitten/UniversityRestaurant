package dados;

import exception.DiaNaoPossuiCardapioCadastradoException;
import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;

import java.time.LocalDate;
import java.util.List;

public interface IRepositorioCardapioDoDia {

    CardapioPorEntrada obterCardapioPorDiaETipo(LocalDate data, String tipo)
            throws DiaNaoPossuiCardapioCadastradoException;

    void registrarCardapioDoDia(CardapioPorEntrada ce);

    List<CardapioPorEntrada> obterCardapiosComInformacoesContidasEm(CardapioPorEntrada modelo);

    List<CardapioPorEntrada> getCardapiosPorEntrada();

    void alterarCardapioDoDiaETipo(LocalDate data, Cardapio c, String tipo);

    boolean haDiaAssociadoAoCardapio(Cardapio c);

}
