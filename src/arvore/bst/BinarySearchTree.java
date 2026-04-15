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
        System.out.println("\n--- Inserindo valor: " + valor + " ---");
        this.raiz = inserirRecursivo(raiz, valor);
        exibir(); // Mostra a estrutura após cada inserção
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

    public void exibir() {
        desenharArvore(raiz, "", true);
    }

    private void desenharArvore(Node no, String prefixo, boolean eUltimo) {
        if (no != null) {
            System.out.print(prefixo);

            // Define o caractere do galho
            System.out.print(eUltimo ? "└── " : "├── ");

            // Imprime o valor do nó
            System.out.println(no.valor);

            // Atualiza o prefixo para os próximos níveis
            String novoPrefixo = prefixo + (eUltimo ? "    " : "│   ");

            // Chamada recursiva para os filhos (direita primeiro para visualização vertical ficar intuitiva)
            // Ou esquerda e direita para visualização padrão
            if (no.esquerda != null || no.direita != null) {
                desenharArvore(no.esquerda, novoPrefixo, no.direita == null);
                desenharArvore(no.direita, novoPrefixo, true);
            }
        }
    }
}
