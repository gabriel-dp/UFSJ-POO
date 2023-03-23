package persistencia;

public class Dados {
    private Persistente veiculos;
    private Persistente procedimentos;
    private Persistente servicos;

    public Dados() {
        this.veiculos = new Persistente();
        this.procedimentos = new Persistente();
        this.servicos = new Persistente();
    }

    public Persistente getVeiculos() {
        return this.veiculos;
    }

    public Persistente getProcedimentos() {
        return this.procedimentos;
    }

    public Persistente getServicos() {
        return this.servicos;
    }
}
