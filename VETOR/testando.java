package JAVA.EDL.VETOR;

public class testando {
    public static void main(String[] args) {
        VetorArray array = new VetorArray(10);
        array.insertAtRank(1, 4);
        System.out.print("\n" + array.elemAtRank(1));
        array.insertAtRank(1, 5);
        System.out.print("\n" + array.elemAtRank(1));
        /* PROBLEMA: Inserir está fazendo o mesmo que inserir no rank */

        array.insertAtRank(2, 6);
        System.out.println("\n" + array.elemAtRank(2));
        /* TESTE: Colocar um elemento no rank 2 */

        System.out.print(array.isEmpty());
        /* TESTE: Verificar se o isEmpty funciona */

        array.replaceAtRank(2, 7);
        System.out.print("\n" + array.elemAtRank(2));
        /* TESTE: Trocar um elemento no rank 2 */

        System.out.print("\n" + array.removeAtRank(2));
    }
}
