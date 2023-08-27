package dados;

import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;

import java.time.LocalDate;
import java.util.List;

public interface IRepositorioCardapioDoDia {

    CardapioPorEntrada obterCardapioPorDiaETipo(LocalDate data, String tipo);

    void registrarCardapioDoDia(CardapioPorEntrada ce);

    List<CardapioPorEntrada> getCardapiosPorEntrada();

    CardapioPorEntrada obterCardapioDoDia(LocalDate data);

    void alterarCardapioDoDiaETipo(LocalDate data, Cardapio c, String tipo);

}
