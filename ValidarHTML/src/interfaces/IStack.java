package interfaces;

public interface IStack<T> {

    void push(T value);

    T pop();

    T peek();

    boolean isEmpty();

    void clear();

}
