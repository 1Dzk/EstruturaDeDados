package pilhas_e_filas;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder

public class Pessoa {
    public String nome;
    public Pessoa proximo;
}
