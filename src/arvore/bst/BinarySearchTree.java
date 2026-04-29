package arvore.bst;

import java.util.ArrayList;
import java.util.List;

import static arvore.bst.TipoCaminho.*;

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
        if (atual == null) return new Node(valor);

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        } else {
            return atual; // Valores duplicados não permitidos
        }

        // --- INÍCIO DO BALANCEAMENTO ---
        int fe = atual.getFatorEquilibrio();

        // Caso 1: Rotação Simples à Direita
        if (fe > 1 && valor < atual.esquerda.valor) {
            return rotacionarDireita(atual);
        }

        // Caso 2: Rotação Simples à Esquerda
        if (fe < -1 && valor > atual.direita.valor) {
            return rotacionarEsquerda(atual);
        }

        // Caso 3: Rotação Dupla à Direita (Esquerda-Direita)
        if (fe > 1 && valor > atual.esquerda.valor) {
            atual.esquerda = rotacionarEsquerda(atual.esquerda);
            return rotacionarDireita(atual);
        }

        // Caso 4: Rotação Dupla à Esquerda (Direita-Esquerda)
        if (fe < -1 && valor < atual.direita.valor) {
            atual.direita = rotacionarDireita(atual.direita);
            return rotacionarEsquerda(atual);
        }

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

    private Node rotacionarDireita(Node y) {
        Node x = y.esquerda;
        Node T2 = x.direita;
        x.direita = y;
        y.esquerda = T2;
        return x; // Nova raiz do sub-ramo
    }

    // Rotação à Esquerda (Caso Direita-Direita)
    private Node rotacionarEsquerda(Node x) {
        Node y = x.direita;
        Node T2 = y.esquerda;
        y.esquerda = x;
        x.direita = T2;
        return y; // Nova raiz do sub-ramo
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
        // 1. Remoção padrão de BST
        if (atual == null) return null;

        if (valor < atual.valor) {
            atual.esquerda = removerRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = removerRecursivo(atual.direita, valor);
        } else {
            // Encontrou o nó a remover!
            if (atual.esquerda == null || atual.direita == null) {
                // Caso com 1 filho ou nenhum
                atual = (atual.esquerda == null) ? atual.direita : atual.esquerda;
            } else {
                // Caso com 2 filhos: sucessor (menor da direita)
                atual.valor = encontrarMinimo(atual.direita);
                atual.direita = removerRecursivo(atual.direita, atual.valor);
            }
        }

        // Se a árvore ficou vazia após a remoção
        if (atual == null) return null;

        // --- REBALANCEAMENTO AVL ---
        int fe = atual.getFatorEquilibrio();

        // Caso Esquerda-Esquerda ou Esquerda-Direita
        if (fe > 1) {
            if (atual.esquerda.getFatorEquilibrio() >= 0) {
                return rotacionarDireita(atual); // Rotação simples
            } else {
                atual.esquerda = rotacionarEsquerda(atual.esquerda);
                return rotacionarDireita(atual); // Rotação dupla
            }
            if (fe < -1) {
                if (atual.direita.getFatorEquilibrio() <= 0) {
                    return rotacionarEsquerda(atual); // Rotação simples
                } else {
                    atual.direita = rotacionarDireita(atual.direita);
                    return rotacionarEsquerda(atual); // Rotação dupla
                }
            }

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

    public void exibirComoDesenho() {
        int altura = raiz == null ? 0 : raiz.getAltura() + 1;
        if (altura == 0) {
            System.out.println("Árvore vazia.");
            return;
        }

        List<Node> nivelAtual = new ArrayList<>();
        nivelAtual.add(raiz);

        int larguraMax = (int) Math.pow(2, altura) * 4; // Espaçamento dinâmico

        System.out.println("\n--- Visualização Gráfica da Árvore ---");

        for (int i = 0; i < altura; i++) {
            List<Node> proximoNivel = new ArrayList<>();
            int espacoEntre = larguraMax / (int) Math.pow(2, i);

            // Imprime espaços iniciais
            imprimirEspacos(espacoEntre / 2);

            for (Node no : nivelAtual) {
                if (no != null) {
                    System.out.print(String.format("%2d", no.valor));
                    proximoNivel.add(no.esquerda);
                    proximoNivel.add(no.direita);
                } else {
                    System.out.print("--"); // Representa nó vazio
                    proximoNivel.add(null);
                    proximoNivel.add(null);
                }
                imprimirEspacos(espacoEntre - 2);
            }
            System.out.println("\n");
            nivelAtual = proximoNivel;
        }
        System.out.println("--------------------------------------");
    }

    private void imprimirEspacos(int quantidade) {
        for (int i = 0; i < quantidade; i++) System.out.print(" ");
    }

    private void desenharArvore(Node no, String prefixo, boolean eUltimo) {
        if (no != null) {
            System.out.print(prefixo);

            // Identificador de galho
            System.out.print(eUltimo ? "└── " : "├── ");

            // Exibe Valor, Fator de Equilíbrio e Altura para conferência do balanceamento
            System.out.println(no.valor + " (FE: " + no.getFatorEquilibrio() + " | Alt: " + no.getAltura() + ")");

            // Prefixo para os filhos
            String novoPrefixo = prefixo + (eUltimo ? "    " : "│   ");

            // Desenha os filhos (Direita primeiro para o visual ficar mais natural no console)
            // Se houver algum filho, precisamos processar ambos para manter a indentação
            if (no.esquerda != null || no.direita != null) {
                desenharArvore(no.direita, novoPrefixo, no.esquerda == null);
                desenharArvore(no.esquerda, novoPrefixo, true);
            }
        }
    }

}
