package ordenaçao.Quick_Sort;

import ordenaçao.Bubble_Sort.GeraVetorUtil;
import ordenaçao.Merge_Sort.Merge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickTest {

    Quick algoritmo = new Quick();


    int[] v21 = new int[500];
    int[] v22 = new int[500];
    int[] v23 = new int[500];

    int[] v31 = new int[50000];
    int[] v32 = new int[50000];
    int[] v33 = new int[50000];

    @BeforeEach
    void gerarDados() {
        algoritmo = new Quick();

        v21 = GeraVetorUtil.geraOrdenado(500);
        v22 = GeraVetorUtil.geraAleatorio(500);
        v23 = GeraVetorUtil.geraInverso(500);

        v31 = GeraVetorUtil.geraOrdenado(50000);
        v32 = GeraVetorUtil.geraAleatorio(50000);
        v33 = GeraVetorUtil.geraInverso(50000);
    }

    @Test
    void testQuickAleatorio() { // Tempo de execução: 5,41 ms
        int[] resultado = algoritmo.ordenar(v32, "v32 (Aleatório)");
        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1]);
        }
    }

    @Test
    void testQuickInverso() { // Tempo de execução: 7,30 ms
        int[] resultado = algoritmo.ordenar(v32, "v32 (Inverso)");
        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1]);
        }
    }

    @Test
    void testQuickAleatorioV22(){ // Tempo de execução: 0,15 ms
        int [] resultado = algoritmo.ordenar(v22,"v22 (Aleatorio)");
        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1]);
        }
    }

    @Test
    void testQuickInversoV22(){ // Tempo de execução: 0,57 ms
        int[] resultado = algoritmo.ordenar(v22,"v22 (Inverso)");
        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1]);
        }
    }
}