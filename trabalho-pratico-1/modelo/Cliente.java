package modelo;

public class Cliente extends Entidade {

    private String nome;

    public Cliente(String nome) {
        super(1);
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
