package arvore.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree arvore;

    @BeforeEach
    void init(){
        arvore = new BinarySearchTree();
    }
    @Test
    void insere(){
        arvore.inserir(44);
        arvore.inserir(33);
        arvore.inserir(22);
        arvore.inserir(25);
        arvore.inserir(55);
        arvore.inserir(52);
    }
}