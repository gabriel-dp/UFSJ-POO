package ex3;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("Invalid empty String");
    }
}
