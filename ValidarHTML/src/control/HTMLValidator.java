package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HTMLValidator {
    private static final String[] SINGLETONS = {
        "meta", "base", "br", "col", "command", "embed", "hr", "img", "input",
        "link", "param", "source", "!doctype"
    };

    private PilhaListaEncadeada<String> pilha = new PilhaListaEncadeada<>();
    private ListaContadorTag contador = new ListaContadorTag();

    private boolean ehSingleton(String tag) {
        for (String t : SINGLETONS) {
            if (t.equalsIgnoreCase(tag)) return true;
        }
        return false;
    }

    private String extrairNomeTag(String tag) {
        tag = tag.replaceAll("<|>|/", "").trim();
        String[] partes = tag.split("\\s+");
        return partes[0].toLowerCase();
    }

    public boolean validarArquivo(File arquivo) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;
        int linhaAtual = 0;

        while ((linha = leitor.readLine()) != null) {
            linhaAtual++;
            linha = linha.trim();
            if (linha.isEmpty()) continue;

            int inicio = 0;
            while ((inicio = linha.indexOf("<", inicio)) != -1) {
                int fim = linha.indexOf(">", inicio);
                if (fim == -1) break;

                String tagCompleta = linha.substring(inicio, fim + 1);
                String nomeTag = extrairNomeTag(tagCompleta);
                boolean ehFechamento = tagCompleta.startsWith("</");

                if (ehSingleton(nomeTag)) {
                    contador.adicionarOuIncrementar(nomeTag);
                } else if (ehFechamento) {
                    if (pilha.estaVazia()) {
                        System.out.println("Erro na linha " + linhaAtual + ": Tag final inesperada: " + tagCompleta);
                        leitor.close();
                        return false;
                    }
                    String topo = pilha.pop();
                    if (!topo.equalsIgnoreCase(nomeTag)) {
                        System.out.println("Erro na linha " + linhaAtual + ": Esperava </" + topo + ">, mas encontrou " + tagCompleta);
                        leitor.close();
                        return false;
                    }
                } else {
                    pilha.push(nomeTag);
                    contador.adicionarOuIncrementar(nomeTag);
                }

                inicio = fim + 1;
            }
        }

        leitor.close();

        if (!pilha.estaVazia()) {
            System.out.println("Erro: Faltam as seguintes tags de fechamento:");
            while (!pilha.estaVazia()) {
                System.out.println("</" + pilha.pop() + ">");
            }
            return false;
        }

        return true;
    }

    public void imprimirContador() {
        contador.imprimir();
    }
}
