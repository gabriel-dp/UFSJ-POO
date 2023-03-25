package modelo;

public class Veiculo extends Entidade {

    private String modelo;
    private String placa;
    private String nomeCliente;

    public Veiculo(int id, String modelo, String placa, String nomeCliente) {
        super(id);
        this.modelo = modelo;
        this.placa = placa;
        this.nomeCliente = nomeCliente;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String novoModelo) {
        this.modelo = novoModelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String novoPlaca) {
        this.placa = novoPlaca;
    }

    public String nomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String novoNomeCliente) {
        this.nomeCliente = novoNomeCliente;
    }

    public String toString() {
        return String.format("Modelo = %s | Placa = %s | Nome do Cliente = %s", this.modelo, this.placa,
                this.nomeCliente);
    }

}
