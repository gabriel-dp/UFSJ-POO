package ex2;

public class NodoLista<T> {
    private T dado;
    private NodoLista<T> proximo;

    public NodoLista(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public T getDado() {
        return this.dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NodoLista<T> getProximo() {
        return this.proximo;
    }

    public void setProximo(NodoLista<T> proximo) {
        this.proximo = proximo;
    }

    public String toString() {
        return "Dado = " + this.dado;
    }
}
