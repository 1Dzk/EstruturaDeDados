package filas.fila_prioridade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaTarefaPrioridadeTest {
    FilaTarefaPrioridade fila;
    Tarefa p1;
    Tarefa p2;
    Tarefa p3;

    @BeforeEach
    void init(){
        fila = FilaTarefaPrioridade.builder().build();
        p1 = new Tarefa("A",2,null);
        p2 = new Tarefa("B",1,null);
        p3 = new Tarefa("C",3,null);
    }


    @Test
    void inserirPorPrioridadeTest(){
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        Assertions.assertEquals("C",fila.getInicio());
     }

     @Test
    void viewPrioridadeTest(){
         fila.enqueue(p1);
         fila.enqueue(p2);
         fila.enqueue(p3);
         assertEquals("C(P:3) | A(P:2) | B(P:1) | ",fila.view());
     }


    @Test
    void deveManterOrdemEmEmpate() {
        FilaTarefaPrioridade fila = new FilaTarefaPrioridade();

        fila.enqueue(new Tarefa("A", 3, null));
        fila.enqueue(new Tarefa("B", 3, null));

        String resultado = fila.view();

        assertEquals("A(P:3) | B(P:3) | ", resultado);
    }

}