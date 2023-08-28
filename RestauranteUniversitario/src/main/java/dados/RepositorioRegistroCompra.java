package dados;

import negocio.beans.Ficha;
import negocio.beans.RegistroCompra;
import negocio.beans.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RepositorioRegistroCompra implements IRepositorioRegistroCompra {

    private List<RegistroCompra> registrosCompras;
    private static IRepositorioRegistroCompra instance;

    private RepositorioRegistroCompra() {

        registrosCompras = new ArrayList<>();
        registrosCompras = ArquivosRegistroCompra.recuperarArquivoCardapio("registros.txt");
    }

    public static IRepositorioRegistroCompra getInstance() {
        if (instance == null) instance = new RepositorioRegistroCompra();

        return instance;
    }

    @Override
    public void cadastrarRegistroCompra(RegistroCompra rc) {
        Random gerador = new Random();

        while (true) {
            int cont = 0;
            long aleatorio = gerador.nextLong() + 100000;

            for (RegistroCompra registroCompra : registrosCompras) {
                if (registroCompra.getCodigoCompra() != aleatorio) {
                    cont++;
                }
            }

            if (cont == registrosCompras.size()) {
                rc.setCodigoCompra(aleatorio);
                break;
            }
        }
        ArquivosRegistroCompra.salvarArquivoRC("registros.txt", rc);
        this.registrosCompras.add(rc);
    }

    @Override
    public void removerRegistroCompra(RegistroCompra rc) {
        if (rc != null) {
            this.registrosCompras.remove(rc);
            ArquivosRegistroCompra.sobrescreverArquivoRC("registros.txt", registrosCompras);
        }
    }

    @Override
    public List<RegistroCompra> getListaRegistroCompra() {
        return registrosCompras;
    }

    @Override
    public List<RegistroCompra> obterRegistrosComInformacoesContidasEm(RegistroCompra modelo, int almoco, int janta) {
        List<RegistroCompra> registrosFiltrados = new ArrayList<>();

        for (RegistroCompra registroCompra : registrosCompras) {
            if (compararRegistroAoModelo(registroCompra, modelo, almoco, janta))
                registrosFiltrados.add(registroCompra);
        }

        return registrosFiltrados;
    }

    private boolean compararRegistroAoModelo(RegistroCompra r, RegistroCompra modelo, int almoco, int janta) {
        return r.getLoginVendedor().contains(modelo.getLoginVendedor()) && r.getValorCompra() >= modelo.getValorCompra() &&
                r.getPagamento().contains(modelo.getPagamento()) && (r.getDataHoraCompra().isAfter(modelo.getDataHoraCompra()) ||
                r.getDataHoraCompra().isEqual(modelo.getDataHoraCompra()))  &&
                contarQuantidadeDeFichasDoTipo("Janta", r) >= janta &&
                contarQuantidadeDeFichasDoTipo("Almoco", r) >= almoco && r.getLoginCliente().contains(modelo.getLoginCliente());
    }

    private int contarQuantidadeDeFichasDoTipo(String tipo, RegistroCompra r) {
        int qtd = 0;

        for (Ficha ficha : r.getFichasCompradas()) {
            if (ficha.getTipo().equals(tipo))
                qtd++;
        }

        return qtd;
    }

    @Override
    public List<RegistroCompra> obterRegistrosDoUsuario(Usuario u) {
        List<RegistroCompra> registrosDoCliente = new ArrayList<>();

        for (RegistroCompra registro : registrosCompras) {
            if (registro.getLoginCliente().equals(u.getLogin()))
                registrosDoCliente.add(registro);
        }

        return registrosDoCliente;
    }

}
