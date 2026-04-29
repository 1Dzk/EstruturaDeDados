package arvore.bst;

public class BinarySearchTree {

    private Node raiz;

    public void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Se for Windows, executa o comando cls
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Se for Linux ou Mac, executa o comando clear
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Se falhar, apenas ignoramos
        }
    }

    public void inserir(int valor) {
        limparConsole();
        this.raiz = inserirRecursivo(raiz, valor);
    }

    private Node inserirRecursivo(Node atual, int valor) {
        // 1. Se chegamos em um lugar vazio, criamos o nó aqui
        if (atual == null) {
            return new Node(valor);
        }

        // 2. Se o valor for menor, "andamos" para a esquerda
        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        }
        // 3. Se o valor for maior, "andamos" para a direita
        else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        }

        // Retorna o nó (sem alterações para os pais na subida da recursão)
        return atual;
    }

    public int getNoNivel(int valor) {
        return buscarNivelRecursivo(raiz, valor, 0);
    }

    private int buscarNivelRecursivo(Node atual, int valor, int nivel) {
        if (atual == null) return -1; // Não encontrado
        if (atual.valor == valor) return nivel;
        return valor < atual.valor
                ? buscarNivelRecursivo(atual.esquerda, valor, nivel + 1)
                : buscarNivelRecursivo(atual.direita, valor, nivel + 1);
    }

    public Node buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private Node buscarRecursivo(Node atual, int valor) {
        if (atual == null || atual.valor == valor) {
            return atual;
        }
        return valor < atual.valor
                ? buscarRecursivo(atual.esquerda, valor)
                : buscarRecursivo(atual.direita, valor);
    }

    public boolean eFolha(int valor) {
        Node no = buscar(valor);
        // Um nó é folha se ele existe e não tem nenhum filho
        return no != null && no.esquerda == null && no.direita == null;
    }

    public void remover(int valor) {
        this.raiz = removerRecursivo(raiz, valor);
    }

    private Node removerRecursivo(Node atual, int valor) {
        if (atual == null) return null;

        // 1. Navegação até encontrar o nó
        if (valor < atual.valor) {
            atual.esquerda = removerRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = removerRecursivo(atual.direita, valor);
        }
        // 2. Nó encontrado!
        else {
            // Caso A e B: Nó com um filho ou nenhum (folha)
            if (atual.esquerda == null) return atual.direita;
            if (atual.direita == null) return atual.esquerda;

            // Caso C: Nó com dois filhos
            // Buscamos o menor valor do lado direito (sucessor)
            atual.valor = encontrarMinimo(atual.direita);

            // Removemos o sucessor da subárvore direita
            atual.direita = removerRecursivo(atual.direita, atual.valor);
        }
        return atual;
    }

    private int encontrarMinimo(Node no) {
        int minimo = no.valor;
        while (no.esquerda != null) {
            minimo = no.esquerda.valor;
            no = no.esquerda;
        }
        return minimo;
    }

    public int getValorRaiz() {
        if (this.raiz == null) {
            throw new RuntimeException("A árvore está vazia!");
        }
        return this.raiz.valor;
    }

    public void caminhar(TipoCaminho tipo) {
        System.out.print("Caminhamento " + tipo + ": ");
        switch (tipo) {
            case IN_ORDER -> caminharInOrder(raiz);
            case PRE_ORDER -> caminharPreOrder(raiz);
            case POS_ORDER -> caminharPosOrder(raiz);
        }
        System.out.println(); // Quebra de linha ao final
    }

    // 1. Esquerda -> Raiz -> Direita (Retorna os números em ordem crescente)
    private void caminharInOrder(Node atual) {
        if (atual != null) {
            caminharInOrder(atual.esquerda);
            System.out.print(atual.valor + " ");
            caminharInOrder(atual.direita);
        }
    }

    // 2. Raiz -> Esquerda -> Direita (Útil para copiar a árvore)
    private void caminharPreOrder(Node atual) {
        if (atual != null) {
            System.out.print(atual.valor + " ");
            caminharPreOrder(atual.esquerda);
            caminharPreOrder(atual.direita);
        }
    }

    // 3. Esquerda -> Direita -> Raiz (Útil para deletar a árvore ou calcular espaços)
    private void caminharPosOrder(Node atual) {
        if (atual != null) {
            caminharPosOrder(atual.esquerda);
            caminharPosOrder(atual.direita);
            System.out.print(atual.valor + " ");
        }
    }

    }
