package dados;

import negocio.ControladorUsuario;
import negocio.beans.Cardapio;
import negocio.beans.Ficha;
import negocio.beans.RegistroCompra;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArquivosFichas {

    public static void salvarArquivo(String nomeArquivo, Ficha ficha) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write("Codigo: " + ficha.getCodigo());
            writer.newLine();
            writer.write("Valor: " + ficha.getValor());
            writer.newLine();
            writer.write("Tipo: " + ficha.getTipo());
            writer.newLine();
            writer.write("Data e hora: " + ficha.getData());
            writer.newLine();
            writer.write("CPF do usuario: " + ficha.getUsuario().getCpf());
            writer.newLine();
            writer.newLine(); // Linha em branco entre as entradas

            //System.out.println("Atributos da pessoa salvos em " + nomeArquivo);
        } catch (IOException e) {
            //System.err.println("Erro ao salvar atributos: " + e.getMessage());
        }
    }

    public static List<Ficha> recuperarArquivoFichas(String nomeArquivo) {
        ControladorUsuario cu = ControladorUsuario.getInstance();
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        List<Ficha> fichas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            long codigo = -1;
            double valor = -1;
            String tipo = null;
            LocalDateTime dataCompra = null;
            long cpfUsuario = -1L;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("Codigo: ")) {
                    codigo = Long.parseLong( linha.substring(8));
                } else if (linha.startsWith("Valor: ")) {
                    valor = Double.parseDouble(linha.substring(7));
                } else if (linha.startsWith("Tipo: ")) {
                    tipo = linha.substring(6);
                } else if (linha.startsWith("Data e hora: ")) {
                    dataCompra = LocalDateTime.parse(linha.substring(13), formatoDataHora);
                } else if (linha.startsWith("CPF do usuario: ")) {
                    cpfUsuario = Long.parseLong(linha.substring(16));
                }

                if (codigo != -1L && valor!= -1 && tipo!= null && dataCompra!= null && cpfUsuario!= -1) {
                    Ficha f = new Ficha(tipo, cu.getUsuarioPorCPF(cpfUsuario));
                    f.setCodigo(codigo);
                    f.setValor(valor);
                    f.setDataCompra(dataCompra);
                    fichas.add(f);
                    codigo = -1;
                    valor = -1;
                    tipo = null;
                    dataCompra = null;
                    cpfUsuario = -1L;
                }
            }
        } catch (IOException e) {
            //System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return fichas;
    }
    public static void sobrescreverArquivoFichas(String nomeArquivo, List<Ficha> fichas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Ficha ficha : fichas) {
                writer.write("Codigo: " + ficha.getCodigo());
                writer.newLine();
                writer.write("Valor: " + ficha.getValor());
                writer.newLine();
                writer.write("Tipo: " + ficha.getTipo());
                writer.newLine();
                writer.write("Data e hora: " + ficha.getData());
                writer.newLine();
                writer.write("CPF do usuario: " + ficha.getUsuario().getCpf());
                writer.newLine();
                writer.newLine(); // Linha em branco entre as entradas

            }

            // System.out.println("Objetos salvos em  " + nomeArquivo);
        } catch (IOException e) {
            // System.err.println("Erro ao salvar objetos: " + e.getMessage());
        }
    }
}
