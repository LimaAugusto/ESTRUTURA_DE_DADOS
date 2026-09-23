package JAVA.EDL.VETOR;

public interface iVetor {
    public abstract Object elemAtRank(Integer rank);
    public abstract Object replaceAtRank(Integer rank, Object object);
    public abstract void insertAtRank(Integer rank, Object object);
    public abstract Object removeAtRank(Integer rank);
    public abstract int size();
    public abstract boolean isEmpty();
}
