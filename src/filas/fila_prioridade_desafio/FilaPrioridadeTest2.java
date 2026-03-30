package filas.fila_prioridade_desafio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaPrioridadeTest2 {
     FilaPrioridade fila;
     Tarefa t1;
     Tarefa t2;
     Tarefa t3;
     Tarefa t4;


     @BeforeEach
    void init(){
         fila = new FilaPrioridade();
         t1 = new Tarefa(200,5,"Deurador",null);
         t2 = new Tarefa(2040,1,"Rodo deslizante",null);
         t3 = new Tarefa(10,2,"Casa",null);
         t4 = new Tarefa(200,4,"Louça",null);
     }

     @Test
    void insertFilaTest(){
         fila.enqueue(t1);
         fila.enqueue(t2);
         fila.enqueue(t3);
         fila.enqueue(t4);
         assertEquals("Deurador",fila.inicio.nome);
         assertEquals("Rodo deslizante",fila.fim.nome);
     }

     @Test
    void dequeueFilaTest(){
         fila.enqueue(t1);
         fila.enqueue(t2);
         fila.enqueue(t3);
         fila.enqueue(t4);
         fila.dequeue();
         fila.dequeue();
         fila.dequeue();
         fila.dequeue();
         assertTrue(fila.isEmpty());
     }
}