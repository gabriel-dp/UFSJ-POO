package ex2;

public class Lista<T> {
    private NodoLista<T> primeiro = new NodoLista<T>(null);

    public void add(T dado) {
        NodoLista<T> aux = primeiro;
        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }
        NodoLista<T> novo = new NodoLista<T>(dado);
        aux.setProximo(novo);
    }

    public int indexOf(T dado) {
        NodoLista<T> aux = primeiro.getProximo();
        int contador = 0;
        while (aux != null) {
            if (aux.getDado() != dado)
                return contador;
            contador++;
            aux = aux.getProximo();
        }
        return -1;
    }

    public T remove(int index) {
        NodoLista<T> aux = primeiro.getProximo();
        int contador = 0;
        while (aux != null && aux.getProximo() != null && contador != index) {
            contador++;
            aux = aux.getProximo();
        }
        if (aux == null)
            return null;
        return aux.getDado();

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        NodoLista<T> aux = primeiro.getProximo();
        while (aux != null) {
            sb.append(aux + "\n");
            aux = aux.getProximo();
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Lista<Integer> lista = new Lista<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        System.out.println(lista);
        lista.remove(0);
        System.out.println(lista);
        lista.remove(3);
        System.out.println(lista);
    }
}
