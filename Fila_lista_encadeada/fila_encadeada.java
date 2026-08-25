package JAVA.EDL.Fila_lista_encadeada;

public class fila_encadeada implements ifila {
    public node first; 
    public node last;
    public int size;
    public fila_encadeada(){
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
    public void enqueue(Object o){
        node new_node = new node(o);
        if (this.first == null){
            this.first = new_node;
            this.last = new_node;
        }
        else{this.last.next = new_node;}
        this.last = new_node;
        this.size ++;
    }

    @Override
    public Object dequeue(){
        if(isEmpty() == true){ 
            throw new FIlaVaziaExececao("Fila vazia: não é possível remover!");
        }
        Object to_remove = this.first.value;
        this.first = this.first.next;
        if(this.first == null){
            this.last = null;
        }
        this.size --;
        return to_remove;
    }
    
    @Override
    public Object first(){
        if(isEmpty() == true){ 
            throw new FIlaVaziaExececao("Fila vazia: não é possível consultar!");
        }
        return this.first.value;
    }

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public boolean isEmpty(){
        boolean sim = false;
        if(this.size == 0){sim = true;}
        return sim;
    }
}
