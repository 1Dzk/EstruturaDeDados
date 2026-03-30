package filas.fila_prioridade;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Tarefa {
    public String descricao;
    public int prioridade;
    public Tarefa proximo;
}
