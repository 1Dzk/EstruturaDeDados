package arvore.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree arvore;

    @BeforeEach
    void init() {
        arvore = new BinarySearchTree();
    }

    @Test
    void insere() {
        arvore.inserir(44);
        arvore.inserir(33);
        arvore.inserir(22);
        arvore.inserir(25);
        arvore.inserir(55);
        arvore.inserir(52);
    }


    @Test
    void testeBuscaValor() {
        insere(); // Garante que a árvore está populada
        Node resultado = arvore.buscar(55);
        assertNotNull(resultado, "O nó 55 deveria existir");
        assertEquals(55, resultado.valor);
    }

    @Test
    void testeNivelDoNo() {
        insere();
        // 44 é raiz (Nível 0)
        // 33 é filho (Nível 1)
        // 22 é neto (Nível 2)
        // 25 é bisneto (Nível 3)
        assertEquals(0, arvore.getNoNivel(44));
        assertEquals(1, arvore.getNoNivel(33));
        assertEquals(3, arvore.getNoNivel(25));
    }

    @Test
    void testeAlturaDoNo() {
        insere();
        // A altura é a distância até a folha mais profunda
        Node no44 = arvore.buscar(44); // Raiz
        Node no55 = arvore.buscar(55); // Tem o filho 52
        Node no25 = arvore.buscar(25); // Folha

        assertEquals(3, no44.getAltura(), "Raiz deve ter altura 3");
        assertEquals(1, no55.getAltura(), "Nó 55 deve ter altura 1");
        assertEquals(0, no25.getAltura(), "Folha deve ter altura 0");
    }

    @Test
    void testeBuscaFolha() {
        insere(); // Popula a árvore com 44, 33, 22, 25, 55, 52

        // Teste 1: O valor 25 é uma folha? (Sim, está na ponta esquerda)
        assertTrue(arvore.eFolha(25), "O nó 25 deveria ser uma folha");

        // Teste 2: O valor 52 é uma folha? (Sim, está na ponta direita)
        assertTrue(arvore.eFolha(52), "O nó 52 deveria ser uma folha");

        // Teste 3: O valor 33 é uma folha? (Não, ele é pai do 22)
        assertFalse(arvore.eFolha(33), "O nó 33 NÃO deveria ser uma folha, ele tem filhos");

        // Teste 4: A raiz (44) é uma folha? (Não!)
        assertFalse(arvore.eFolha(44), "A raiz nunca será folha em uma árvore com vários nós");
    }

    @Test
    void testeRemoverFolha() {
        insere(); // 44, 33, 22, 25, 55, 52
        arvore.remover(25); // Removendo uma folha

        assertNull(arvore.buscar(25), "O nó 25 deveria ter sido removido");
        assertNotNull(arvore.buscar(22), "O nó pai (22) deve continuar na árvore");
    }

    @Test
    void testeRemoverNoComUmFilho() {
        insere();
        arvore.remover(55); // O 55 tem apenas o filho 52

        assertNull(arvore.buscar(55));
        assertNotNull(arvore.buscar(52), "O filho (52) deveria ter subido para o lugar do 55");
    }

    @Test
    void testeRemoverNoComDoisFilhos() {
        insere();
        // O 44 (raiz) tem dois filhos (33 e 55)
        arvore.remover(44);

        assertNull(arvore.buscar(44));
        // O sucessor do 44 na sua árvore original é o 52 (o menor dos maiores)
        assertNotNull(arvore.buscar(52), "O sucessor deveria estar na árvore");

        //Opcional: verifique se a nova raiz é o 52
        assertEquals(52, arvore.getValorRaiz(), "O 52 deveria ser a nova raiz");

        System.out.println("✅ Nova raiz confirmada: " + arvore.getValorRaiz());
    }

    @Test
    void testeExcluirRaizAteEsvaziar() {
        // 1. Insere apenas um elemento
        arvore.inserir(100);
        assertEquals(100, arvore.getValorRaiz());

        // 2. Remove a raiz única
        arvore.remover(100);

        // 3. Verifica se a árvore está vazia (vai disparar a exceção que criamos no getValorRaiz)
        assertThrows(RuntimeException.class, () -> {
            arvore.getValorRaiz();
        }, "A árvore deveria estar vazia após remover a raiz");
    }

    @Test
    void removerRaizComFilhos() {
        insere(); // 44 está no topo
        arvore.remover(44); // O método encontra o 52 e o coloca no topo

        int novaRaiz = arvore.getValorRaiz();
        System.out.println("A antiga raiz era 44, a nova raiz agora é: " + novaRaiz);

        assertEquals(52, novaRaiz); // O 52 assume o lugar
        assertNull(arvore.buscar(44)); // O 44 sumiu de vez
    }

    @Test
    void testeCaminhamentos() {
        insere(); // 44, 33, 22, 25, 55, 52

        System.out.println("\n--- Validando ordens de percurso ---");

        // Teste visual no console
        arvore.caminhar(TipoCaminho.IN_ORDER);   // Esperado: 22 25 33 44 52 55
        arvore.caminhar(TipoCaminho.PRE_ORDER);  // Esperado: 44 33 22 25 55 52
        arvore.caminhar(TipoCaminho.POS_ORDER);  // Esperado: 25 22 33 52 55 44
    }

    @Test
    void testeDesenhoGrafico() {
        arvore.inserir(23);
        arvore.inserir(20);
        arvore.inserir(232);

        arvore.exibirComoDesenho();
    }
}