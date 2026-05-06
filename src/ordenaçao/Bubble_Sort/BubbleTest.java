package ordenaçao.Bubble_Sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static ordenaçao.Bubble_Sort.GeraVetorUtil.geraInverso;

class BubbleTest {

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
        v12 =GeraVetorUtil.geraAleatorio(50);
        v13 = GeraVetorUtil.geraAleatorio(50);

        v21 = GeraVetorUtil.geraOrdenado(500);
        v22 = GeraVetorUtil.geraAleatorio(500);
        v23 = GeraVetorUtil.geraAleatorio(500);

        v31 =GeraVetorUtil.geraOrdenado(50000);
        v32 =GeraVetorUtil.geraAleatorio(50000);
        v33 =GeraVetorUtil.geraInverso(50000);
    }


    @Test
    void ordenaPequenos(){
        Bubble algoritmo = new Bubble();
        algoritmo.ordenar(v11, "v11 (Ordenado)");
        algoritmo.ordenar(v12, "v12 (Aleatório)");
        algoritmo.ordenar(v13, "v13 (Inverso)");
    }

    @Test
    void ordenaMedios(){
        Bubble algoritmo = new Bubble();
        algoritmo.ordenar(v21, "v21 (Ordenado)");
        algoritmo.ordenar(v22, "v22 (Aleatório)");
        algoritmo.ordenar(v23, "v23 (Inverso)");
    }

    @Test
    void ordenaGrandes(){
        Bubble algoritmo = new Bubble();
        algoritmo.ordenar(v31, "v31 (Ordenado)");
        algoritmo.ordenar(v32, "v32 (Aleatório)");
        algoritmo.ordenar(v33, "v33 (Inverso)");
    }

}
