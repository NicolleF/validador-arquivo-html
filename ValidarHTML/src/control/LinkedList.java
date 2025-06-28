
package control;

import model.NodeList;


public class LinkedList<T> {
    private NodeList<T> first;

    public LinkedList() {
        first = null;
    }

    public NodeList getFirst() {
        return first;
    }
    
    public void insert(T value) {
        NodeList<T> node = new NodeList<>(value);
        
        node.setNext(first);
        this.first = node;
    }
    
//    public boolean estaVazia() {
//        return primeiro == null;
//    }
    
//    public NoLista<T> buscar(T info) {
//        NoLista<T> current = primeiro;
//        
//        while (current != null) {
//            if (current.getInfo().equals(info)) {
//                return current;
//            }
//            
//            current = current.getProximo();
//        }
//        
//        return null;
//    }
    
//    public void retirar(T value) {
//        NoLista<T> last = null;
//        NoLista<T> current = primeiro;
//        
//        while (current != null && !current.getInfo().equals(value)) {
//            last = current;
//            current = current.getProximo();
//        }
//        
//        if (current != null) {
//            if (last == null) {
//                primeiro = current.getProximo();
//            } else {
//                last.setProximo(current.getProximo());
//            }
//        }
//    }
    
    public int getLength() {
        int count = 0;
        NodeList<T> current = first;
        
        while (current != null) {
            count++;
            current = current.getNext();
        }
        
        return count;
    }
    
    public NodeList<T> getNode(int index) {
        if (index < 0 || index >= getLength()) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        
        int count = 0;
        NodeList<T> current = first;
        
        while (count < index) {
            count++;
            current = current.getNext();
        }
        
        return current;
    }
    
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        NoLista<T> current = primeiro;
//        
//        while (current != null) {
//            sb.append(current.getInfo())
//                .append(" -> ");
//            
//            current = current.getProximo();
//        }
//        
//        sb.append("null");
//        
//        return sb.toString();
//    }
}
