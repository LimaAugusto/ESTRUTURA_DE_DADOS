package JAVA.EDL.VETOR;

public class VetorArrayTeste {

    private static int testes = 0;
    private static int aprovados = 0;

    private static void ok(boolean condicao, String nome) {
        testes++;
        if (condicao) {
            aprovados++;
            System.out.println("[OK] " + nome);
        } else {
            System.out.println("[ERRO] " + nome);
        }
    }

    private static void excecao(Runnable r, String nome) {
        testes++;
        try {
            r.run();
            System.out.println("[ERRO] " + nome + " (não lançou exceção)");
        } catch (Exception e) {
            aprovados++;
            System.out.println("[OK] " + nome);
        }
    }

    public static void main(String[] args) {

        // =============================
        // TESTE 1 – Vetor vazio
        // =============================
        VetorArray v = new VetorArray(5);

        ok(v.isEmpty(), "Vetor inicia vazio");
        ok(v.size() == 0, "Tamanho inicial = 0");

        // =============================
        // TESTE 2 – Inserções básicas
        // =============================
        v.insertAtRank(0, "A");
        v.insertAtRank(1, "B");
        v.insertAtRank(2, "C");

        ok(v.size() == 3, "Tamanho após 3 inserções");
        ok(v.elemAtRank(0).equals("A"), "Rank 0 = A");
        ok(v.elemAtRank(1).equals("B"), "Rank 1 = B");
        ok(v.elemAtRank(2).equals("C"), "Rank 2 = C");

        // =============================
        // TESTE 3 – Inserção no meio
        // =============================
        v.insertAtRank(1, "X");

        ok(v.size() == 4, "Inserção no meio aumenta tamanho");
        ok(v.elemAtRank(0).equals("A"), "A permanece");
        ok(v.elemAtRank(1).equals("X"), "X inserido");
        ok(v.elemAtRank(2).equals("B"), "B deslocado");
        ok(v.elemAtRank(3).equals("C"), "C deslocado");

        // =============================
        // TESTE 4 – Replace
        // =============================
        Object antigo = v.replaceAtRank(2, "Y");

        ok(antigo.equals("B"), "Replace retorna elemento antigo");
        ok(v.elemAtRank(2).equals("Y"), "Elemento substituído");

        // =============================
        // TESTE 5 – Remoção do meio
        // =============================
        Object removido = v.removeAtRank(1);

        ok(removido.equals("X"), "Remove retorna X");
        ok(v.size() == 3, "Tamanho reduz");
        ok(v.elemAtRank(0).equals("A"), "Rank0 = A");
        ok(v.elemAtRank(1).equals("Y"), "Rank1 = Y");
        ok(v.elemAtRank(2).equals("C"), "Rank2 = C");

        // =============================
        // TESTE 6 – Remoção do início
        // (testa inicio_vetor circular)
        // =============================
        Object primeiro = v.removeAtRank(0);

        ok(primeiro.equals("A"), "Remove primeiro");
        ok(v.size() == 2, "Tamanho = 2");
        ok(v.elemAtRank(0).equals("Y"), "Novo primeiro = Y");
        ok(v.elemAtRank(1).equals("C"), "Segundo = C");

        // =============================
        // TESTE 7 – Circularidade
        // =============================
        v.insertAtRank(0, "P");
        v.insertAtRank(0, "Q");

        ok(v.elemAtRank(0).equals("Q"), "Q no início");
        ok(v.elemAtRank(1).equals("P"), "P deslocado");
        ok(v.elemAtRank(2).equals("Y"), "Y preservado");
        ok(v.elemAtRank(3).equals("C"), "C preservado");

        // =============================
        // TESTE 8 – Exceções
        // =============================
        excecao(() -> v.elemAtRank(-1), "Rank negativo");
        excecao(() -> v.elemAtRank(10), "Rank acima do tamanho");
        excecao(() -> v.removeAtRank(10), "Remoção inválida");

        System.out.println();
        System.out.println("==================================");
        System.out.println("Resultado: " + aprovados + "/" + testes + " testes aprovados");
        System.out.println("==================================");
    }
}
