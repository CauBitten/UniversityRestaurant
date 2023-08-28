package dados;

import javafx.scene.control.Alert;
import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArquivosCardapioDoDia {

    public static void salvarArquivo (String nomeArquivo, CardapioPorEntrada cardapioPorEntrada) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write("Data: " + cardapioPorEntrada.getData());
            writer.newLine();
            writer.write("Cardapio: " + cardapioPorEntrada.getCardapio());
            writer.newLine();
            writer.write("Tipo: " + cardapioPorEntrada.getTipo());
            writer.newLine();
            writer.newLine(); // Linha em branco entre as entradas

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao salvar atributos");
            alert.setHeaderText("Arquivo não pode ser salvo: " + e.getMessage());
            alert.show();
        }
    }

//    public static List<CardapioPorEntrada> recuperarArquivoCardapio(String nomeArquivo) {
//        List<CardapioPorEntrada> cardapiosPorEntrada = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
//            String linha;
//            LocalDate linha1;
//            Cardapio linha2;
//            LocalDate data = null;
//            Cardapio cardapio = null;
//            String tipo = null;
//
//            while ((linha = reader.readLine()) != null) {
//                if (linha.startsWith("Data: ")) {
//                    data = linha1.toString().substring(6);
//
//                } else if (linha.startsWith("Cardapio: ")) {
//                    cardapio = linha2.toString().substring(10);
//
//                } else if (linha.startsWith("Tipo: ")) {
//                    tipo = linha.substring(6);
//                }
//
//                if (data != null && cardapio!= null && tipo!= null) {
//                    cardapiosPorEntrada.add(new CardapioPorEntrada(data,cardapio,tipo));
//                    data = null;
//                    cardapio = null;
//                    tipo = null;
//                }
//            }
//
//        } catch (IOException e) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Erro na leitura");
//            alert.setHeaderText("Arquivo não pode ser lido: " + e.getMessage());
//            alert.show();
//        }
//        return cardapiosPorEntrada;
//    }

    public static void sobrescreverArquivoCardapio(String nomeArquivo, List<CardapioPorEntrada> cardapioPorEntradas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (CardapioPorEntrada cardapio : cardapioPorEntradas) {
                writer.write("Data: " + cardapio.getData());
                writer.newLine();
                writer.write("Cardapio: " + cardapio.getCardapio().getId());
                writer.newLine();
                writer.write("Tipo: " + cardapio.getTipo());
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao salvar");
            alert.setHeaderText("Arquivo não foi salvo: " + e.getMessage());
            alert.show();
        }
    }
}
