package ex4;

public class ItsNotANumberException extends Exception {
    public ItsNotANumberException(String string) {
        super(String.format("The input is not a number (%s)", string));
    }
}
