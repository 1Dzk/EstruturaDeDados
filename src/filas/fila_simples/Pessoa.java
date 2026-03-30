package filas.fila_simples;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {
    public String nome;
    public Pessoa proximo;
}
