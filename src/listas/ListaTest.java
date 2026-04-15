package listas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListaTest {

    Lista lista;

    @BeforeEach
    void init() {
        lista = new Lista();
    }

    @Test
    void insere() {
        lista.inserir(44);
        lista.inserir(33);
        lista.inserir(22);

        // Testa se o tamanho é 3
        assertEquals(3, lista.getTamanho());

        // Testa se o primeiro valor inserido é 44
        assertEquals(44, lista.primeiro.dado);
    }
}