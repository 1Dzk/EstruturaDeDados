package ordenaçao.Selection_Sort;

public class Selection {
    public int[] ordenar(int[] dados, String nomeConjunto) {
        int n = dados.length;


        long tempoInicial = System.nanoTime();


        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;


            for (int j = i + 1; j < n; j++) {
                if (dados[j] < dados[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }


            int temp = dados[indiceMinimo];
            dados[indiceMinimo] = dados[i];
            dados[i] = temp;
        }


        long tempoFinal = System.nanoTime();
        double tempoMilissegundos = (tempoFinal - tempoInicial) / 1000000.0;

        System.out.println("Algoritmo: Selection Sort");
        System.out.println("Conjunto: " + nomeConjunto);
        System.out.printf("Tempo de execução: %.2f ms%n", tempoMilissegundos);
        System.out.println("---------------------------------------");

        return dados;
    }
}
