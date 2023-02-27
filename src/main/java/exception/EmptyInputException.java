package exception;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException() {
        super(ErrorMessage.EMPTY_INPUT.getMessage());
    }
}
