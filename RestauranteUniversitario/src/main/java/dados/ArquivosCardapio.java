package dados;

import javafx.scene.control.Alert;
import negocio.beans.Cardapio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivosCardapio {

    public static void salvarArquivo(String nomeArquivo, Cardapio cardapio) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write("Principal: " + cardapio.getPrincipal());
            writer.newLine();
            writer.write("Vegetariano: " + cardapio.getVegetariano());
            writer.newLine();
            writer.write("Guarnicao: " + cardapio.getGuarnicao());
            writer.newLine();
            writer.write("Salada: " + cardapio.getSalada());
            writer.newLine();
            writer.write("Sobremesa: " + cardapio.getSobremesa());
            writer.newLine();
            writer.write("Suco: " + cardapio.getSuco());
            writer.newLine();
            writer.write("Id: " + cardapio.getId());
            writer.newLine();
            writer.newLine(); // Linha em branco entre as entradas

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao salvar atributos");
            alert.setHeaderText("Arquivo não pode ser salvo: " + e.getMessage());
            alert.show();
        }
    }

    public static List<Cardapio> recuperarArquivoCardapio(String nomeArquivo) {
        List<Cardapio> cardapios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            String principal = null;
            String vegetariano = null;
            String guarnicao = null;
            String salada = null;
            String sobremesa = null;
            String suco = null;
            long id = -1L;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("Principal: ")) {
                    principal = linha.substring(11);

                } else if (linha.startsWith("Vegetariano: ")) {
                    vegetariano = linha.substring(13);
                } else if (linha.startsWith("Guarnicao: ")) {
                    guarnicao = linha.substring(11);
                } else if (linha.startsWith("Salada: ")) {
                    salada = linha.substring(8);
                } else if (linha.startsWith("Sobremesa: ")) {
                    sobremesa = linha.substring(11);
                } else if (linha.startsWith("Suco: ")) {
                    suco = linha.substring(6);
                }else if (linha.startsWith("Id: ")) {
                    id = Long.parseLong(linha.substring(4));
                }

                if (principal != null && vegetariano!= null && guarnicao!= null && salada!= null && sobremesa!= null && suco!= null && id!= -1L) {
                    cardapios.add(new Cardapio(principal,vegetariano,guarnicao,salada, sobremesa, suco));
                    principal = null;
                    vegetariano = null;
                    guarnicao = null;
                    salada = null;
                    sobremesa = null;
                    suco = null;
                    id = -1;
                }
            }

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro na leitura");
            alert.setHeaderText("Arquivo não pode ser lido: " + e.getMessage());
            alert.show();
        }
        return cardapios;
    }

    public static void sobrescreverArquivoCardapio(String nomeArquivo, List<Cardapio> cardapios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Cardapio cardapio : cardapios) {
                writer.write("Principal: " + cardapio.getPrincipal());
                writer.newLine();
                writer.write("Vegetariano: " + cardapio.getVegetariano());
                writer.newLine();
                writer.write("Guarnicao: " + cardapio.getGuarnicao());
                writer.newLine();
                writer.write("Salada: " + cardapio.getSalada());
                writer.newLine();
                writer.write("Sobremesa: " + cardapio.getSobremesa());
                writer.newLine();
                writer.write("Suco: " + cardapio.getSuco());
                writer.newLine();
                writer.write("Id: " + cardapio.getId());
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
