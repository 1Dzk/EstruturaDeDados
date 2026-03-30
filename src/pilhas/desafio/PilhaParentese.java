package pilhas.desafio;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PilhaParentese {
    private Parentese topo;


    public boolean isEmpty() {
        return topo == null;
    }

    public void push(Parentese p) {
        if (!isEmpty()) {
            p.proximo = topo;
        }
        topo = p;
    }

    public Parentese pop(){
        if (!isEmpty()){
            Parentese saiu = topo;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }
}

