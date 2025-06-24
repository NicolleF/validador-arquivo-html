package control.interfaces;

public interface IPilha<T> {

	void push(T valor);

	T pop();

	T peek();

	boolean estaVazia();

	void liberar();

}
