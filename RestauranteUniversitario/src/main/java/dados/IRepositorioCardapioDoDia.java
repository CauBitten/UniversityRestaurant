package dados;

import negocio.beans.Cardapio;

public interface IRepositorioCardapioDoDia {

    Cardapio obterCardapioPorDiaETipo(String data, String tipo);

    void associarCardapioAoDiaeTipo(Cardapio cardapio, String tipo, String data);

}
