package JAVA.EDL.Pilha_rubronegra;

public class PilhaVaziaExcecao extends RuntimeException {
    public PilhaVaziaExcecao(String error){
        super(error);
    }
}
