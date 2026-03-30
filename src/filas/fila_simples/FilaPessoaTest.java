package filas.fila_simples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaPessoaTest {
    FilaPessoa fila;
    Pessoa p1;
    Pessoa p2;
    Pessoa p3;

    @BeforeEach
    void init() {
        fila = FilaPessoa.builder().build();
        p1 = new Pessoa("PEDRO", null);
        p2 = new Pessoa("JOÂO", null);
        p3 = new Pessoa("MARIA", null);
    }

    @Test
    void enqueueTest() {
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
    }


    @Test
    void removeTest() {
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.dequeue();
        assertEquals("JOÂO", fila.inicio.getNome());
        assertEquals("MARIA", fila.fim.getNome());
        fila.dequeue();
        assertEquals("MARIA", fila.inicio.getNome());
        assertEquals("MARIA", fila.fim.getNome());
        fila.dequeue();
        assertTrue(fila.isEmpty());
    }

    @Test
    void viewTest() {
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.enqueue(p1);
        assertEquals("JOÂO | MARIA | PEDRO | ", fila.view());
    }


}