package arvore.bst;

public class Node {
    int valor;
    Node esquerda;
    Node direita;

    public int getAltura() {
        return calcularAltura(this);
    }

    private int calcularAltura(Node no) {
        if (no == null) return -1; // Convenção: nó nulo tem altura -1
        return 1 + Math.max(calcularAltura(no.esquerda), calcularAltura(no.direita));
    }

    // Construtor: ao criar um nó, ele nasce sem filhos
    public Node(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
    public int getFatorEquilibrio() {
        int altEsq = (esquerda == null) ? -1 : esquerda.getAltura();
        int altDir = (direita == null) ? -1 : direita.getAltura();
        return altEsq - altDir;
    }
}
