package dados;

import negocio.beans.RegistroCompra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RepositorioRegistroCompra implements IRepositorioRegistroCompra {

    private List<RegistroCompra> listaRegistroCompra = new ArrayList<>();

    @Override
    public void cadastrarRegistroCompra(RegistroCompra rc) {
        Random gerador = new Random();

        while(true) {

            int cont = 0;
            long aleatorio = gerador.nextLong(899999) + 100000;

            for (RegistroCompra registroCompra : listaRegistroCompra) {

                if (registroCompra.getCodigoCompra() != aleatorio) {
                    cont++;
                }

            }

            if (cont == listaRegistroCompra.size()) {
                rc.setCodigoCompra(aleatorio);
                break;
            }
        }

        this.listaRegistroCompra.add(rc);
    }

    @Override
    public void removerRegistroCompra(RegistroCompra rc) {
        this.listaRegistroCompra.remove(rc);
    }

    @Override
    public List<RegistroCompra> getListaRegistroCompra() {
        return listaRegistroCompra;
    }
}
