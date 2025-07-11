package model;

public class NodeList<T> {

    private T info;
    private NodeList<T> next;

    public NodeList(T info) {
        this.info = info;
        next = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodeList<T> getNext() {
        return next;
    }

    public void setNext(NodeList<T> next) {
        this.next = next;
    }
}
