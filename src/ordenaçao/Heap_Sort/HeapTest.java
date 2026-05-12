package ordenaçao.Heap_Sort;

import ordenaçao.Bubble_Sort.GeraVetorUtil;
import ordenaçao.Quick_Sort.Quick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    Heap algoritmo;

    int[] v21 = new int[500];
    int[] v22 = new int[500];
    int[] v23 = new int[500];

    int[] v31 = new int[50000];
    int[] v32 = new int[50000];
    int[] v33 = new int[50000];

    @BeforeEach
    void gerarDados() {
        algoritmo = new Heap();

        v21 = GeraVetorUtil.geraOrdenado(500);
        v22 = GeraVetorUtil.geraAleatorio(500);
        v23 = GeraVetorUtil.geraInverso(500);

        v31 = GeraVetorUtil.geraOrdenado(50000);
        v32 = GeraVetorUtil.geraAleatorio(50000);
        v33 = GeraVetorUtil.geraInverso(50000);
    }

    @Test
    void testHeapOrdenado() {
        int[] resultado = algoritmo.ordenar(v31.clone(), "v31 (Heap Ordenado)");


        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1], "Erro na posição " + i);
        }
    }

    @Test
    void testHeapAleatorio() {
        int[] resultado = algoritmo.ordenar(v32.clone(), "v32 (Heap Aleatório)");


        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1], "Erro na posição " + i);
        }
    }

    @Test
    void testHeapInverso() {
        int[] resultado = algoritmo.ordenar(v33.clone(), "v33 (Heap Inverso)");


        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1], "Erro na posição " + i);
        }
    }

    @Test
    void testHeapOrdenadoV21() {
        int[] resultado = algoritmo.ordenar(v21.clone(), "v21 (Heap Ordenado)");


        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1], "Erro na posição " + i);
        }
    }

    @Test
    void testHeapAleatorioV22() {
        int[] resultado = algoritmo.ordenar(v22.clone(), "v22 (Heap Aleatorio)");


        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1], "Erro na posição " + i);
        }
    }

    @Test
    void testHeapInversoV23() {
        int[] resultado = algoritmo.ordenar(v23.clone(), "v23 (Heap Inverso)");


        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1], "Erro na posição " + i);
        }
    }

}