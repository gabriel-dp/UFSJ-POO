package modelo;

public class Veiculo extends Entidade {

    private String modelo;
    private String placa;
    private String nomeCliente;

    public Veiculo(String modelo, String placa, String nomeCliente) {
        super(1);
        this.modelo = modelo;
        this.placa = placa;
        this.nomeCliente = nomeCliente;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String nomeCliente() {
        return nomeCliente;
    }

}
