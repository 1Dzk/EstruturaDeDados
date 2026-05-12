package ordenaçao.Merge_Sort;

import ordenaçao.Bubble_Sort.GeraVetorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest {
    Merge algoritmo;
    int[] v21 = new int[500];
    int[] v22 = new int[500];
    int[] v23 = new int[500];

    int[] v31 = new int[50000];
    int[] v32 = new int[50000];
    int[] v33 = new int[50000];

    @BeforeEach
    void gerarDados() {
        algoritmo = new Merge();

        v21 = GeraVetorUtil.geraOrdenado(500);
        v22 = GeraVetorUtil.geraAleatorio(500);
        v23 = GeraVetorUtil.geraInverso(500);

        v31 = GeraVetorUtil.geraOrdenado(50000);
        v32 = GeraVetorUtil.geraAleatorio(50000);
        v33 = GeraVetorUtil.geraInverso(50000);
    }

    @Test
    void testarV32Aleatorio() {
        // Testa o aleatório de 50 mil (o teste de fogo)
        int[] resultado = algoritmo.ordenar(v32, "v32 (Aleatório 50.000)");

        assertNotNull(resultado);

        assertEquals(50000, resultado.length);

        // Valida se está realmente ordenado
        for (
                int i = 0;
                i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1], "Erro na posição " + i);
        }
    }

    @Test
    void testarV33Inverso() {
        // No Merge Sort, o inverso é tão rápido quanto o ordenado
        int[] resultado = algoritmo.ordenar(v33, "v33 (Inverso 50.000)");

        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1]);
        }
    }

    @Test
    void testarV22Aleatorio() {
        // Teste rápido com 500 elementos
        int[] resultado = algoritmo.ordenar(v22, "v22 (Aleatório 500)");

        for (int i = 0; i < resultado.length - 1; i++) {
            assertTrue(resultado[i] <= resultado[i + 1]);
        }
    }

    @Test
    void testarV22Inverso(){
        int [] resultado = algoritmo.ordenar(v22, "v22 (Inverso 500)");

        for (int i = 0; i< resultado.length - 1; i++){
            assertTrue(resultado[i] <= resultado[i + 1]);
        }
    }

}