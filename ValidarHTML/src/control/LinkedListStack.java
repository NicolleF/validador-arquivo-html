package control;


import exceptions.EmptyStackException;
import model.NodeList;
import interfaces.IStack;

public class LinkedListStack<T> implements IStack<T> {

    private NodeList<T> top;
    
    public LinkedListStack() {
    	top = null;
    }

    @Override
    public void push(T valor) {
        NodeList<T> newNode = new NodeList<>(valor);
        newNode.setNext(top);
        top = newNode;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = top.getInfo();
        top = top.getNext();
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getInfo();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void clear() {
        top = null;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        NoLista<T> atual = topo;
//        while (atual != null) {
//            sb.append(atual.getInfo());
//            if (atual.getProximo() != null) {
//                sb.append(",");
//            }
//            atual = atual.getProximo();
//        }
//        return sb.toString();
//    }
}