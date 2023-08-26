package dados;

import negocio.beans.Cardapio;
import negocio.beans.Entrada;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioEntrada {
    void adicionarEntrada(Entrada e);

}
