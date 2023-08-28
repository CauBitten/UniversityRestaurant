package dados;

import javafx.scene.control.Alert;
import negocio.ControladorFicha;
import negocio.beans.Cardapio;
import negocio.beans.Ficha;
import negocio.beans.RegistroCompra;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArquivosRegistroCompra {

    public static void salvarArquivoRC(String nomeArquivo, RegistroCompra rc) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write("Codigo compra: " + rc.getCodigoCompra());
            writer.newLine();
            writer.write("Login Cliente: " + rc.getLoginCliente());
            writer.newLine();
            writer.write("Login Vendedor: " + rc.getLoginVendedor());
            writer.newLine();
            writer.write("Data e hora: " + rc.getDataHora());
            writer.newLine();
            writer.write("Pagamento: " + rc.getPagamento());
            writer.newLine();
            writer.write("Valor da compra: " + rc.getValorCompra());
            writer.newLine();
            ArquivosFichas.sobrescreverArquivoFichas(rc.getCodigoCompra() + ".txt", rc.getFichasCompradas());

            writer.newLine(); // Linha em branco entre as entradas

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao salvar atributos");
            alert.setHeaderText("Arquivo não pode ser salvo: " + e.getMessage());
            alert.show();
        }
    }

    public static List<RegistroCompra> recuperarArquivoCardapio(String nomeArquivo) {
        ControladorFicha cf = ControladorFicha.getInstance();
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        List<RegistroCompra> registros = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            long codigocompra = -1L;
            String logincliente = null;
            String loginVendedor = null;
            String pagamento = null;
            LocalDateTime dataHoraCompra = null;
            double valorCompra = -1;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("Codigo compra: ")) {
                    codigocompra = Long.parseLong( linha.substring(15));
                } else if (linha.startsWith("Login Cliente: ")) {
                    logincliente = linha.substring(15);
                } else if (linha.startsWith("Login Vendedor: ")) {
                    loginVendedor = linha.substring(16);
                } else if (linha.startsWith("Pagamento: ")) {
                    pagamento = linha.substring(11);
                } else if (linha.startsWith("Data e hora: ")) {
                    dataHoraCompra = LocalDateTime.parse(linha.substring(13), formatoDataHora);
                } else if (linha.startsWith("Valor da compra: ")) {
                    valorCompra = Double.parseDouble(linha.substring(17));
                }

                if (codigocompra != -1L && logincliente!= null && loginVendedor!= null && pagamento!= null && dataHoraCompra!= null && valorCompra!= -1) {

                    RegistroCompra rc = new RegistroCompra(ArquivosFichas.recuperarArquivoFichas(codigocompra+".txt"), logincliente, loginVendedor, pagamento, dataHoraCompra);
                    rc.setValorCompra(valorCompra);
                    registros.add(rc);
                     codigocompra = -1L;
                     logincliente = null;
                     loginVendedor = null;
                     pagamento = null;
                     dataHoraCompra = null;
                     valorCompra = -1;
                }
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro na leitura");
            alert.setHeaderText("Arquivo não pode ser lido: " + e.getMessage());
            alert.show();
        }
        return registros;
    }

    public static void sobrescreverArquivoRC(String nomeArquivo, List<RegistroCompra> registro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (RegistroCompra rc : registro) {
                writer.write("Codigo compra: " + rc.getCodigoCompra());
                writer.newLine();
                writer.write("Login Cliente: " + rc.getLoginCliente());
                writer.newLine();
                writer.write("Login Vendedor: " + rc.getLoginVendedor());
                writer.newLine();
                writer.write("Data e hora: " + rc.getDataHora());
                writer.newLine();
                writer.write("Pagamento: " + rc.getPagamento());
                writer.newLine();
                writer.write("Valor da compra: " + rc.getValorCompra());
                writer.newLine();
                ArquivosFichas.sobrescreverArquivoFichas(rc.getCodigoCompra() + ".txt", rc.getFichasCompradas());
                writer.newLine(); // Linha em branco entre as entradas

            }

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao salvar");
            alert.setHeaderText("Arquivo não foi salvo: " + e.getMessage());
            alert.show();
        }
    }
}
