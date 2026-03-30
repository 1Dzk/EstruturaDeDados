package pilhas.modulo;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PilhaLivroTest {
    PilhaLivro pilha;
     Livro l2;
     Livro l1;
     Livro l3;


    @BeforeEach
     void init(){
        pilha = PilhaLivro.builder().build();
        l1 = new Livro("Titulo1", 100, 2010,null);
        l2 = new Livro("Titulo2", 200, 2015,null);
        l3 = new Livro("Titulo3",300,2020,null);
    }

    @Test
    @Description("Teste de inserção com pilha vazia")
    void insereEmPilhaVaziaTest(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        Livro topo = pilha.peek();
        assertEquals(l3.getTitulo(),topo.getTitulo());
    }
    @Test
    @Description("teste de remoção da pilha")
    void removePilhaTest(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        pilha.pop();
        assertEquals(l2.getTitulo(), pilha.peek().getTitulo());
        pilha.pop();
        assertEquals(l1.getTitulo(), pilha.peek().getTitulo());
        pilha.pop();
        assertTrue(pilha.isEmpty());
    }
    @Test
    @Description("Teste de view")
    void exibePilhaTest(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        String r = pilha.view();
        assertEquals("Titulo3\nTitulo2\nTitulo1\n",r);
    }
}