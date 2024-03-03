package domain.exception;

public class LadderGameException extends RuntimeException {
    public LadderGameException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
    }
}
