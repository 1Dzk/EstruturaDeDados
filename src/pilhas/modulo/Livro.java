package pilhas.modulo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Livro {
    private String titulo;
    private int nrPaginas;
    private int anoLancamento;
    public Livro proximo;
}


