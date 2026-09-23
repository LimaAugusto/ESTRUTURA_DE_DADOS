package JAVA.EDL.VETOR;

public class VetorArray {
    private Object[] array;
    private int capacidade;
    private int tamanho;
    private int inicio_vetor;

    public VetorArray(int capacidade){
        this.array = new Object[capacidade];
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.inicio_vetor = 0;
    }

    public Integer indiceFisico(Integer rank){
        int indice = (this.inicio_vetor + rank) % this.capacidade;
        if (indice < 0){ indice += this.capacidade; }
        return indice;
    }

    public Object elemAtRank(Integer rank){
        if (rank < 0 || rank >= size()){
            throw new VetorExcecoes("Rank fora do limiteee!");
        }
        int indice = indiceFisico(rank);
        return this.array[indice];
    }

    public Object replaceAtRank(Integer rank, Object object){
        if (rank < 0 || rank >= size()){
            throw new VetorExcecoes("Rank fora do limiteee!");
        }
        int indice = indiceFisico(rank);
        Object remover = this.array[indice];
        this.array[indice] = object;
        return remover;
    }

    public void insertAtRank(Integer rank, Object object){
        if (rank == 0){
            this.inicio_vetor = (this.inicio_vetor - 1 + this.capacidade) % this.capacidade;
            this.array[this.inicio_vetor] = object;
            this.tamanho++;

        }

        else if (rank >= 0 && rank <= size()){
            int indice_rank = indiceFisico(rank);
            for(int i = this.tamanho; i >= rank; i--){
                indice_rank = indiceFisico(i);
                int indice_vetor = indiceFisico(i-1);
                this.array[indice_rank] = this.array[indice_vetor];
            }
            this.array[indice_rank] = object;
            this.tamanho++;
        }

        else { throw new VetorExcecoes("Rank fora do limiteee!"); }
    }

    public Object removeAtRank(Integer rank){
        if (rank < 0 || rank >= size()){
            throw new VetorExcecoes("Rank fora do limiteee!");
        }

        if (rank == 0){
            Object remover = this.array[this.inicio_vetor];
            this.array[this.inicio_vetor] = null;
            this.inicio_vetor = (this.inicio_vetor + 1) % this.capacidade;
            this.tamanho--;
            return remover;
        }

        int indice_rank = indiceFisico(rank);
        Object remover = this.array[indice_rank];

        for(int i = rank; i < this.tamanho - 1; i++){
            indice_rank = indiceFisico(i);
            int indice_vetor = indiceFisico(i+1);
            this.array[indice_rank] = this.array[indice_vetor];
        }

        int ultimo = indiceFisico(tamanho - 1);
        this.array[ultimo] = null;
        this.tamanho--;
        return remover;
    }

    public int size(){
        return this.tamanho;
    }

    public boolean isEmpty(){
        return this.tamanho == 0;
    }
}
