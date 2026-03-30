package filas.fila_prioridade_desafio;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Tarefa {
    public double valor;
    public int prioridade;
    public String nome;
    public Tarefa proximo;
}
