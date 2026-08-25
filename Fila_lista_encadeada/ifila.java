package JAVA.EDL.Fila_lista_encadeada;

public interface ifila {
    public abstract void enqueue(Object o);
    public abstract Object dequeue();
    public abstract Object first();
    public abstract int size();
    public abstract boolean isEmpty();
}