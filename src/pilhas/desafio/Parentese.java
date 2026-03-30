package pilhas.desafio;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Parentese {
     char valor;
    Parentese proximo;
}
