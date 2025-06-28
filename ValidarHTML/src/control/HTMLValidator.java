package control;

import control.exceptions.ArquivoMalFormatadoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

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
                        leitor.close();
                        throw new ArquivoMalFormatadoException("Erro na linha " + linhaAtual + ": Tag final inesperada: " + tagCompleta);
                    }
                    String topo = pilha.pop();
                    if (!topo.equalsIgnoreCase(nomeTag)) {
                        leitor.close();
                        throw new ArquivoMalFormatadoException("Erro na linha " + linhaAtual + ": Esperava </" + topo + ">, mas encontrou " + tagCompleta);
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
            StringBuilder sb = new StringBuilder("Erro: Faltam as seguintes tags de fechamento:");
            while (!pilha.estaVazia()) {
                sb.append("</" + pilha.pop() + ">");
            }
            throw new ArquivoMalFormatadoException(sb.toString());
        }

        return true;
    }

    public Map<String, Integer> imprimirContador() {
        return contador.imprimir();
    }
}
