package pilhas.desafio;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PilhaParenteseTest {
    PilhaParentese pilha;
    Parentese valor;
    List<String> expressoes;

    @BeforeEach
    void init(){
        pilha = new PilhaParentese();
        expressoes = List.of(
                "(1 + 2) - 3 + (5 - 5 - 6) + (b + v)",
                "(1 + 2) + (b + v)",
                "(((())())))",
                "(1 + 2) + (b + v",
                "((1 + 2) - 3 + (5 - 5 - 6) + (b + v)",
                "(((())))))((()())"
        );
    }
    @Test
    @Description("Avalia as 6 expressões")
    void avaliaExpressoesTest(){
        assertTrue(avaliExpressao(expressoes.get(0)));
        pilha = new PilhaParentese();
        assertTrue(avaliExpressao(expressoes.get(1)));
        pilha = new PilhaParentese();
        assertTrue(avaliExpressao(expressoes.get(2)));
        pilha = new PilhaParentese();
        assertFalse(avaliExpressao(expressoes.get(3)));
        pilha = new PilhaParentese();
        assertFalse(avaliExpressao(expressoes.get(4)));
        pilha = new PilhaParentese();
        assertFalse(avaliExpressao(expressoes.get(5)));
        pilha = new PilhaParentese();
    }

    private boolean avaliExpressao(String expressao){
        char [] caracteres = expressao.toCharArray();
        for (char c : caracteres){
            if (c == '(')
             pilha.push(new Parentese('(',null));
            if (c == ')')
                pilha.pop();
        }
        return pilha.isEmpty();
    }
}