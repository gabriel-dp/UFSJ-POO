package persistencia;

public class IdException extends Exception {
    public IdException(int id) {
        super(String.format("Id não encontrado %d", id));
    }
}
