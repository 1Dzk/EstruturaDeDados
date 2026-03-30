package filas.fila_prioridade;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class FilaTarefaPrioridade {
    public Tarefa inicio;
    public Tarefa fim;

    boolean isEmpty() {
        return inicio == null && fim == null;
    }

  public void enqueue(Tarefa nova) {
        if (isEmpty()) {
            inicio = nova;
            fim = nova;
            return;
        }
        if (nova.prioridade > inicio.prioridade) {
            nova.proximo = inicio;
            inicio = nova;
            return;
        }
        Tarefa atual = inicio;
        while (atual.proximo != null &&
                atual.proximo.prioridade >= nova.prioridade) {
            atual = atual.proximo;
        }

        nova.proximo = atual.proximo;
        atual.proximo = nova;

        if (nova.proximo == null) {
            fim = nova;
        }
    }

    void dequeue() {
        if (!isEmpty()) {
            inicio = inicio.proximo;

            if (inicio == null) {
                fim = null;
            }
        }
    }

    public String view() {
        Tarefa aux = inicio;
        String ret = "";

        while (aux != null) {
            ret += aux.getDescricao() + "(P:" + aux.prioridade + ") | ";
            aux = aux.proximo;
        }

        return ret;
    }
    public FilaTarefaPrioridade clone() {
        FilaTarefaPrioridade nova = new FilaTarefaPrioridade();

        if (this.inicio == null) {
            return nova;
        }

        Tarefa atualOriginal = this.inicio;

        // cria o primeiro nó
        Tarefa novoInicio = new Tarefa(
                atualOriginal.getDescricao(),
                atualOriginal.getPrioridade(),
                null
        );

        nova.inicio = novoInicio;

        Tarefa atualNovo = novoInicio;
        atualOriginal = atualOriginal.proximo;


        while (atualOriginal != null) {
            Tarefa novo = new Tarefa(
                    atualOriginal.getDescricao(),
                    atualOriginal.getPrioridade(),
                    null
            );

            atualNovo.proximo = novo;
            atualNovo = novo;

            atualOriginal = atualOriginal.proximo;
        }

        nova.fim = atualNovo;

        return nova;
    }
}


