package persistencia;

public class Dados {

    private Persistente veiculos;
    private Persistente procedimentos;
    private Persistente manutencoes;

    public Dados() {
        this.veiculos = new Persistente();
        this.procedimentos = new Persistente();
        this.manutencoes = new Persistente();
    }

    public Persistente getVeiculos() {
        return this.veiculos;
    }

    public Persistente getProcedimentos() {
        return this.procedimentos;
    }

    public Persistente getManutencoes() {
        return this.manutencoes;
    }

}
