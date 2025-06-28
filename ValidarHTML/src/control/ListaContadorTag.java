package control;

import java.util.HashMap;
import java.util.Map;
import model.ContadorTag;
import model.NoLista;

public class ListaContadorTag {
    private ListaEncadeada<ContadorTag> lista = new ListaEncadeada<>();

    public void adicionarOuIncrementar(String nomeTag) {
        NoLista<ContadorTag> atual = lista.getPrimeiro();

        while (atual != null) {
            if (atual.getInfo().getNome().equalsIgnoreCase(nomeTag)) {
                atual.getInfo().incrementar();
                return;
            }
            atual = atual.getProximo();
        }

        lista.inserir(new ContadorTag(nomeTag));
    }

    public void ordenar() {
        int n = lista.obterComprimento();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ContadorTag a = lista.obterNo(i).getInfo();
                ContadorTag b = lista.obterNo(j).getInfo();

                if (a.getNome().compareToIgnoreCase(b.getNome()) > 0) {
                    // Trocar os elementos
                    lista.obterNo(i).setInfo(b);
                    lista.obterNo(j).setInfo(a);
                }
            }
        }
    }

    public Map<String, Integer> imprimir() {
        Map<String, Integer> resultTags = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
        ordenar();
        NoLista<ContadorTag> atual = lista.getPrimeiro();
        while (atual != null) {
            resultTags.put(atual.getInfo().getNome(), atual.getInfo().getContagem());
//            sb.append(atual.getInfo()).append("\n");
            atual = atual.getProximo();
        }
        
        return resultTags;
    }
}
