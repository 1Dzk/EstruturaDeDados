package ordenaçao.Quick_Sort;

public class Quick {
    public int[] ordenar(int[] dados, String nomeConjunto) {
        long tempoInicial = System.nanoTime();

        quickSort(dados, 0, dados.length - 1);

        long tempoFinal = System.nanoTime();
        double tempoMilissegundos = (tempoFinal - tempoInicial) / 1000000.0;

        System.out.println("Algoritmo: Quick Sort");
        System.out.println("Conjunto: " + nomeConjunto);
        System.out.printf("Tempo de execução: %.2f ms%n", tempoMilissegundos);
        System.out.println("---------------------------------------");

        return dados;
    }

    private void quickSort(int[] arr, int baixo, int alto) {
        if (baixo < alto) {
            // Particionamento: coloca o pivô no lugar certo
            int indicePivo = particionar(arr, baixo, alto);

            // Ordena as duas metades
            quickSort(arr, baixo, indicePivo - 1);
            quickSort(arr, indicePivo + 1, alto);
        }
    }

    private int particionar(int[] arr, int baixo, int alto) {
        // Usando o último elemento como pivô
        int pivo = arr[alto];
        int i = (baixo - 1);

        for (int j = baixo; j < alto; j++) {
            if (arr[j] <= pivo) {
                i++;
                // Troca arr[i] e arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Troca arr[i+1] e o pivô (arr[alto])
        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        return i + 1;
    }
}
