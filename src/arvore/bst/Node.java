package arvore.bst;

public class Node {
    int valor;
    Node esquerda;
    Node direita;

    // Construtor: ao criar um nó, ele nasce sem filhos
    public Node(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}
