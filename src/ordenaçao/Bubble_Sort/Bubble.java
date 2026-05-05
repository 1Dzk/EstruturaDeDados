package ordenaçao.Bubble_Sort;

public class Bubble {
    public int[] ordenar(int[] dados, String nomeConjunto) {
        int n = dados.length;

        // Início da medição
        long tempoInicial = System.currentTimeMillis();

        // Lógica do Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (dados[j] > dados[j + 1]) {
                    int temp = dados[j];
                    dados[j] = dados[j + 1];
                    dados[j + 1] = temp;
                }
            }
        }


        long tempoFinal = System.currentTimeMillis();
        double tempoMs = (tempoFinal - tempoInicial) / 1_000_000.0;

        System.out.printf("Conjunto: %s | Tamanho: %d | Tempo: %.4f ms%n", nomeConjunto, n, tempoMs);

        return dados;
    }
}
