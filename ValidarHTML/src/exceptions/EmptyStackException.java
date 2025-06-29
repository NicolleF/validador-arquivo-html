package exceptions;

public class EmptyStackException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmptyStackException() {
        super("Pilha vazia!");
    }

}
