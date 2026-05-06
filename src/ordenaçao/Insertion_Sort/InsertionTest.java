package ordenaçao.Insertion_Sort;

import ordenaçao.Bubble_Sort.GeraVetorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertionTest {
    int[] v11 = new int[50];
    int[] v12 = new int[50];
    int[] v13 = new int[50];

    int[] v21 = new int[500];
    int[] v22 = new int[500];
    int[] v23 = new int[500];

    int[] v31 = new int[50000];
    int[] v32 = new int[50000];
    int[] v33 = new int[50000];

    @BeforeEach
    void gerarDados() {
        v11 = GeraVetorUtil.geraOrdenado(50);
        v12 = GeraVetorUtil.geraAleatorio(50);
        v13 = GeraVetorUtil.geraInverso(50);

        v21 = GeraVetorUtil.geraOrdenado(500);
        v22 = GeraVetorUtil.geraAleatorio(500);
        v23 = GeraVetorUtil.geraInverso(500);

        v31 = GeraVetorUtil.geraOrdenado(50000);
        v32 = GeraVetorUtil.geraAleatorio(50000);
        v33 = GeraVetorUtil.geraInverso(50000);
    }

    @Test
    void testarInsertion(){
        Insertion algoritmo = new Insertion();
        algoritmo.ordenar(v31, "v31 (Ordenado 50000)");
        algoritmo.ordenar(v32, "v32 (Aleatorio 50000)");
        algoritmo.ordenar(v33, "v33 (Invertido 50000)");
    }
}