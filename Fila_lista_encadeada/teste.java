package JAVA.EDL.Fila_lista_encadeada;

public class teste {
    public static void main(String[] args) {
        fila_encadeada lista = new fila_encadeada();
        lista.enqueue(5);
        lista.enqueue(6);
        lista.enqueue(7);
        System.out.println(lista.isEmpty());
        System.out.println(lista.size());
        lista.dequeue();
        System.out.print(lista.size());
    }
}

