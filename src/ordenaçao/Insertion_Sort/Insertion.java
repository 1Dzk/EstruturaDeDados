package ordenaçao.Insertion_Sort;

public class Insertion {
    public int[] ordenar(int[] dados, String nomeConjunto) {
        int n = dados.length;

        // 1. Início da medição (NANOTIME!)
        long tempoInicial = System.nanoTime();

        // Lógica do Insertion Sort
        for (int i = 1; i < n; i++) {
            int chave = dados[i];
            int j = i - 1;

            // Move os elementos que são maiores que a chave para uma posição à frente
            while (j >= 0 && dados[j] > chave) {
                dados[j + 1] = dados[j];
                j = j - 1;
            }
            dados[j + 1] = chave;
        }

        // 2. Fim da medição
        long tempoFinal = System.nanoTime();

        // 3. Cálculo correto em milissegundos
        double tempoMilissegundos = (tempoFinal - tempoInicial) / 1000000.0;

        System.out.println("Algoritmo: Insertion Sort");
        System.out.println("Conjunto: " + nomeConjunto);
        System.out.printf("Tempo de execução: %.2f ms%n", tempoMilissegundos);
        System.out.println("---------------------------------------");

        return dados;
    }
}
