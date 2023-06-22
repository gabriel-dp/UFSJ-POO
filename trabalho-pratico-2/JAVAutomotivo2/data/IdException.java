package data;

public class IdException extends Exception {

    public IdException(int id) {
        super(String.format("Id not found (%d)", id));
    }

}
