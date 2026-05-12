package ordenaçao.Merge_Sort;

public class Merge {
    public int[] ordenar(int[] dados, String nomeConjunto) {
        long tempoInicial = System.nanoTime();

        // Inicia a recursão
        mergeSort(dados, 0, dados.length - 1);

        long tempoFinal = System.nanoTime();
        double tempoMilissegundos = (tempoFinal - tempoInicial) / 1000000.0;

        System.out.println("Algoritmo: Merge Sort");
        System.out.println("Conjunto: " + nomeConjunto);
        System.out.printf("Tempo de execução: %.2f ms%n", tempoMilissegundos);
        System.out.println("---------------------------------------");

        return dados;
    }

    private void mergeSort(int[] arr, int esq, int dir) {
        if (esq < dir) {
            int meio = esq + (dir - esq) / 2;

            // Divide o bagulho no meio (Recursividade)
            mergeSort(arr, esq, meio);
            mergeSort(arr, meio + 1, dir);

            // Junta as partes ordenando
            intercalar(arr, esq, meio, dir);
        }
    }

    private void intercalar(int[] arr, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[esq + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[meio + 1 + j];

        int i = 0, j = 0;
        int k = esq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
