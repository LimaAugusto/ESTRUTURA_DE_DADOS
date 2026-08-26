package JAVA.EDL.Pilha_lista_encadeada;

public class pilha_encadeada implements ipilha {
    public node first;
    public node last;
    public int size;
    public pilha_encadeada(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    private class node{
        Object value;
        node next;

        public node(Object value){
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public int size(){
        return this.size;
    }
    
    @Override
    public boolean isEmpty(){
        boolean sim = false;
        if (size() == 0){
            sim = true;
        }
        return sim;
    }

    @Override
    public Object top(){
        if(isEmpty() == true){ throw new PilhaVaziaExcecao("Pilha vazia!"); }
        return this.first.value;
    }
    
    @Override
    public void push(Object o){
        node new_node = new node(o);
        if(isEmpty() == true){
            this.last = new_node;
        }

        new_node.next = this.first;
        this.first = new_node;
        this.size++;
    }

    @Override
    public Object pop(){
        if(isEmpty() == true){ throw new PilhaVaziaExcecao("Pilha vazia: não há elementos para remover!"); }
        Object to_remove = this.first.value;
        if(this.first == this.last){
            this.first = null;
            this.last = null;
        }

        else{ this.first = this.first.next; }
        size--;
        return to_remove;
    }
}
