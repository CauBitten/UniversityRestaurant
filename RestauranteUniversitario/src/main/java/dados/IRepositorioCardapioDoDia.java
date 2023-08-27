package dados;

import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;

import java.time.LocalDate;

public interface IRepositorioCardapioDoDia {

    CardapioPorEntrada obterCardapioPorDiaETipo(LocalDate data, String tipo);

    void associarCardapioAoDiaeTipo(Cardapio cardapio, String tipo, String data);

}
