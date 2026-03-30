package filas.fila_prioridade_desafio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class FilaPrioridade {
    public Tarefa inicio;
    public Tarefa fim;

    boolean isEmpty() {
        return inicio == null && fim == null;
    }

    public void enqueue(Tarefa nova) {
        if (isEmpty()) {
            inicio = nova;
            fim = nova;
        }
        if (nova.prioridade > inicio.prioridade) {
            nova.proximo = inicio;
            inicio = nova;
            return;
        }
        Tarefa atual = inicio;
        while (atual.proximo != null && atual.proximo.prioridade >= nova.prioridade) {
            atual = atual.proximo;
        }
        nova.proximo = atual.proximo;
        atual.proximo = nova;
        if (nova.proximo == null) {
            fim = nova;
        }
    }

    public void dequeue() {
        if (!isEmpty()) {
            if (inicio == fim) {
                inicio = null;
                fim = null;
            } else {
                inicio = inicio.proximo;
            }
        }
    }

    public String view() {
        Tarefa aux = inicio;
        String ret = "----- Lista de Tarefas -----\n";
        double somaTotal = 0;

        while (aux != null) {
            ret += ("- " + aux.nome + " Valor: " + aux.prioridade + ")\n");

            somaTotal += aux.prioridade;
            aux = aux.proximo;
        }
        ret += ("Soma total dos valores: " + somaTotal);

        return ret;
    }

}
