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

    public void setVeiculos(Persistente novosVeiculos) {
        this.veiculos = novosVeiculos;
    }

    public Persistente getProcedimentos() {
        return this.procedimentos;
    }

    public void setProcedimentos(Persistente novosProcedimentos) {
        this.procedimentos = novosProcedimentos;
    }

    public Persistente getManutencoes() {
        return this.manutencoes;
    }

    public void setManutencoes(Persistente novasManutencoes) {
        this.manutencoes = novasManutencoes;
    }
}
