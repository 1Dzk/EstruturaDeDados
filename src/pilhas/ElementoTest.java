package pilhas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoTest {

    Elemento pilha = new Elemento(0);


    @Test
    public void pushTest(){
        pilha.push(1);
        pilha.push(5);
        pilha.push(8);
        int valorTopo = pilha.peek();
        assertEquals(8,valorTopo);
        String view = pilha.view();
        assertEquals("8-5-1",view);
    }

}