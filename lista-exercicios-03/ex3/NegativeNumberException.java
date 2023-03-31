package ex3;

public class NegativeNumberException extends Exception {
    public NegativeNumberException(int number) {
        super(String.format("Invalid negative number (%d)", number));
    }
}
