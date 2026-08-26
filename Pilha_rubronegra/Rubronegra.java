package JAVA.EDL.Pilha_rubronegra;

public class Rubronegra {
    // ATRIBUTOS PRIVADOS DE CAPACITY = CAPACIDADE DO ARRAY INTEIRO
    // t_v E t_p SÃO OS TAMANHOS DE CADA PILHA, VERMELHA --> COMEÇO; PRETA --> FIM
    private int capacity, t_v, t_p;
    private Object[] a;

    // CONSTRUTOR DA PILHA RUBRONEGRA, ONDE t_v É -1, INDICANDO QUE ESTÁ VAZIO
    // t_p É A CAPACIDADE DO ARRAY - 1(ÚLTIMO ELEMENTO DO ARRAY), POR ÚLTIMO INSTANCIA O ARRAY COM A CAPACIDADE PASSADA
    public Rubronegra(int capacity){
        this.capacity = capacity;
        this.t_v = -1;
        this.t_p = capacity;
        this.a = new Object[capacity];
    }

    //OPERAÇÕES PILHA_VERMELHA
    public int t_v(){
        return this.t_v + 1; 
    }
    public boolean isEmpty_v(){
        return this.t_v == -1;
    }
    public Object top_v(){
        if(isEmpty_v()){
            throw new PilhaVaziaExcecao("Pilha Vazia!");
        }
        return this.a[this.t_v];
    }
    public void push_v(Object o){
        if ((this.t_v + 1) == this.t_p) {
            int novaCapacidade = this.capacity * 2;
            Object b[] = new Object[novaCapacidade];

            for (int i = 0; i <= t_v; i++) {
                b[i] = a[i];
            }   
            for (int i = t_p; i < capacity; i++) {
                b[i + capacity] = a[i];
            }
    
            this.t_p = this.t_p + capacity; 
            this.capacity = novaCapacidade;
            this.a = b;
        }
        a[++t_v] = o;
    }

    public Object pop_v(){
        if (isEmpty_v()) {
            throw new PilhaVaziaExcecao("Pilha Vazia!");
        }
        Object r = a[this.t_v];
        a[this.t_v] = null; 
        this.t_v--;
 
        int itensVermelha = this.t_v + 1;
        int itensPreta = this.capacity - this.t_p;
        int totalElementos = itensVermelha + itensPreta;
    
        if (totalElementos <= (this.capacity / 3)) {
            int novaCapacidade = this.capacity / 2;
            Object b[] = new Object[novaCapacidade];
            for (int i = 0; i <= t_v; i++) {
                b[i] = a[i];
            }
            
            int metade = novaCapacidade; 
            for (int i = t_p; i < capacity; i++) {
                b[i - metade] = a[i];
            } 
            this.t_p = this.t_p - metade;
            this.capacity = novaCapacidade;
            this.a = b;
        }
        return r;
    }

    //OPERAÇÕES PILHA_PRETA
    public int t_p(){
        return this.capacity - this.t_p;
    }

    public boolean isEmpty_p(){
        return this.t_p == this.capacity;
    }

    public Object top_p(){
        if (isEmpty_p()) {
            throw new PilhaVaziaExcecao("Pilha Vazia!");
        }
        return this.a[this.t_p];
    }

    public void push_p(Object o){
        if ((this.t_v + 1) == this.t_p) {
            int novaCapacidade = this.capacity * 2;
            Object b[] = new Object[novaCapacidade];

            for (int i = 0; i <= t_v; i++) {
                b[i] = a[i];
            }   
            for (int i = t_p; i < capacity; i++) {
                b[i + capacity] = a[i];
            }
    
            this.t_p = this.t_p + capacity; 
            this.capacity = novaCapacidade;
            this.a = b;
        }
        a[--t_p] = o;
    }

    public Object pop_p(){
        if (isEmpty_p()) {
            throw new PilhaVaziaExcecao("Pilha Vazia!");
        }
        Object r = a[this.t_p];
        a[this.t_p] = null; 
        this.t_p++;
 
        int itensVermelha = this.t_v + 1;
        int itensPreta = this.capacity - this.t_p;
        int totalElementos = itensVermelha + itensPreta;
    
        if (totalElementos <= (this.capacity / 3)) {
            int novaCapacidade = this.capacity / 2;
            Object b[] = new Object[novaCapacidade];
            for (int i = 0; i <= t_v; i++) {
                b[i] = a[i];
            }
            
            int metade = novaCapacidade; 
            for (int i = t_p; i < capacity; i++) {
                b[i - metade] = a[i];
            } 
            this.t_p = this.t_p - metade;
            this.capacity = novaCapacidade;
            this.a = b;
        }
        return r;
    }
}