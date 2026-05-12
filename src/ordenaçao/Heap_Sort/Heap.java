package ordenaçao.Heap_Sort;

public class Heap {
    public int[] ordenar(int[] dados, String nomeConjunto) {
        long tempoInicial = System.nanoTime();
        int n = dados.length;

        // Reconstrói o vetor como um Max-Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(dados, n, i);
        }

        // Extrai um por um os elementos do heap
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual para o fim
            int temp = dados[0];
            dados[0] = dados[i];
            dados[i] = temp;

            // Chama o heapify na árvore reduzida
            heapify(dados, i, 0);
        }

        long tempoFinal = System.nanoTime();
        double tempoMilissegundos = (tempoFinal - tempoInicial) / 1000000.0;

        System.out.println("Algoritmo: Heap Sort");
        System.out.println("Conjunto: " + nomeConjunto);
        System.out.printf("Tempo de execução: %.2f ms%n", tempoMilissegundos);
        System.out.println("---------------------------------------");

        return dados;
    }

    void heapify(int[] arr, int n, int i) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < n && arr[esq] > arr[maior]) maior = esq;
        if (dir < n && arr[dir] > arr[maior]) maior = dir;

        if (maior != i) {
            int troca = arr[i];
            arr[i] = arr[maior];
            arr[maior] = troca;

            // Heapify recursivo no nó afetado
            heapify(arr, n, maior);
        }
    }
}
