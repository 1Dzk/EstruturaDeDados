package listas;

public class Lista {
    No primeiro;

    public void inserir(int dado) {
        No novoNo = new No(dado);
        if (primeiro == null) {
            primeiro = novoNo;
        } else {
            No atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public int getTamanho() {
        int cont = 0;
        No atual = primeiro;
        while (atual != null) {
            cont++;
            atual = atual.proximo;
        }
        return cont;
    }
}