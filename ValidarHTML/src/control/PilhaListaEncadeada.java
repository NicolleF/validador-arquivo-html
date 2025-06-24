package control;


import control.exceptions.PilhaVaziaException;
import control.interfaces.IPilha;
import model.NoLista;

public class PilhaListaEncadeada<T> implements IPilha<T> {

    private NoLista<T> topo;
    
    

    public PilhaListaEncadeada() {
    	topo = null;
	}

	@Override
    public void push(T valor) {
        NoLista<T> novoNo = new NoLista<>(valor);
        novoNo.setProximo(topo);
        topo = novoNo;
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        T valor = topo.getInfo();
        topo = topo.getProximo();
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return topo.getInfo();
    }

    @Override
    public boolean estaVazia() {
        return topo == null;
    }

    @Override
    public void liberar() {
        topo = null;
    }

    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> atual = topo;
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(",");
            }
            atual = atual.getProximo();
        }
        return sb.toString();
    }
}