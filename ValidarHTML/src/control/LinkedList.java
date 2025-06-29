package control;

import model.NodeList;

public class LinkedList<T> {

    private NodeList<T> first;

    public LinkedList() {
        first = null;
    }

    public NodeList<T> getFirst() {
        return first;
    }

    public void insert(T value) {
        NodeList<T> node = new NodeList<>(value);

        node.setNext(first);
        this.first = node;
    }

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
}
