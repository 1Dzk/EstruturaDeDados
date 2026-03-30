package pilhas_e_filas;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class Pilha {
    Pessoa topo;

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(Pessoa p) {
        if (!isEmpty()) {
            p.proximo = topo;
        }
        topo = p;
    }

    public Pessoa pop(){
        if (!isEmpty()){
            Pessoa saiu = topo;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }
}
