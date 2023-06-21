package view;

public class InputException extends Exception {

    public InputException(String text) {
        super(String.format("Invalid inputs: '%s'", text));
    }

}