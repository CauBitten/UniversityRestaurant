package dados;

import negocio.beans.Cliente;
import negocio.beans.Ficha;
import negocio.beans.RegistroCompra;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RepositorioRegistroCompra implements IRepositorioRegistroCompra {

    private List<RegistroCompra> registrosCompras;
    private static IRepositorioRegistroCompra instance;

    private RepositorioRegistroCompra() {
        registrosCompras = new ArrayList<>();
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

        this.registrosCompras.add(rc);
    }

    @Override
    public void removerRegistroCompra(RegistroCompra rc) {
        if (rc != null) {
            this.registrosCompras.remove(rc);
        }
    }

    @Override
    public List<RegistroCompra> getListaRegistroCompra() {
        return registrosCompras;
    }

    @Override
    public List<RegistroCompra> getRegistrosComprasDoCliente(Cliente c) {
        List<RegistroCompra> registroComprasPorCliente = new ArrayList<>();

        if (c != null) {
            for (RegistroCompra registro : registrosCompras) {
                long cpfCliente = registro.getUsuario().getCpf();

                if (cpfCliente == c.getCpf())
                    registroComprasPorCliente.add(registro);
            }
        }

        return registroComprasPorCliente;
    }

    @Override
    public List<RegistroCompra> getRegistrosComprasPorIntervaloDeDataHora(
            LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal)
    {
        //Atualizar
        List<RegistroCompra> registrosPorData = new ArrayList<>();

        return registrosPorData;
    }

    @Override
    public List<RegistroCompra> getRegistrosComprasComValorMaiorOuIgualQue(double valor) {
        List<RegistroCompra> registrosPorValor = new ArrayList<>();

        for (RegistroCompra registro : registrosCompras) {
            if (registro.getValorCompra() >= valor)
                registrosPorValor.add(registro);
        }

        return registrosPorValor;
    }

    @Override
    public RegistroCompra getRegistroCompraPorCodigo(long codigo) {
        for (RegistroCompra registro : registrosCompras) {
            if (registro.getCodigoCompra() == codigo)
                return registro;
        }

        return null;
    }

    @Override
    public List<RegistroCompra> getRegistrosComprasDoVendedor(String vendedor) {
        List<RegistroCompra> registrosPorVendedor = new ArrayList<>();

        for (RegistroCompra registro : registrosCompras) {
            if (registro.getVendedor().equals(vendedor))
                registrosPorVendedor.add(registro);
        }

        return registrosPorVendedor;
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
        return r.getVendedor().contains(modelo.getVendedor()) && r.getValorCompra() >= modelo.getValorCompra() &&
                r.getPagamento().equals(modelo.getPagamento()) && (r.getDataHoraCompra().isAfter(modelo.getDataHoraCompra()) ||
                r.getDataHoraCompra().isEqual(modelo.getDataHoraCompra()) || r.getCodigoCompra() >= modelo.getCodigoCompra()) ||
                contarQuantidadeDeFichasDoTipo("Janta", r) >= janta ||
                contarQuantidadeDeFichasDoTipo("Almoco", r) >= almoco;
    }

    private int contarQuantidadeDeFichasDoTipo(String tipo, RegistroCompra r) {
        int qtd = 0;

        for (Ficha ficha : r.getFichasCompradas()) {
            if (ficha.getTipo().equals(tipo))
                qtd++;
        }

        return qtd;
    }

}
