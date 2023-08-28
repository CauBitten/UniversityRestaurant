package dados;

import negocio.beans.Cardapio;
import negocio.beans.Usuario;

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

            //System.out.println("Atributos da pessoa salvos em " + nomeArquivo);
        } catch (IOException e) {
            //System.err.println("Erro ao salvar atributos: " + e.getMessage());
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
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
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

            // System.out.println("Objetos salvos em  " + nomeArquivo);
        } catch (IOException e) {
            // System.err.println("Erro ao salvar objetos: " + e.getMessage());
        }
    }
}
