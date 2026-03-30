package pilhas;

public class Elemento {

    int valor;
    Elemento proximo;
    Elemento topo;

    public  Elemento(int vl){
        this.valor = vl;
        this.proximo = null;
        this.topo = null;
    }

    public boolean isEmpty(){
        return topo == null;
    }

    public void push(int vl){
        Elemento novo = new Elemento(vl);
        if (!isEmpty()) {
            novo.proximo = topo;
        }
        topo = novo;
    }

    public void pop(){
        topo = topo.proximo;

    }

    public int peek(){
        return topo.valor;
    }

    public String view() {
        if (isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Elemento aux = topo;

        while (aux != null) {
            sb.append(aux.valor);

            if (aux.proximo != null) {
                sb.append("-");
            }

            aux = aux.proximo;
        }

        return sb.toString();
    }
}
