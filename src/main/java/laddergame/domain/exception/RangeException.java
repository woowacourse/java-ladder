package laddergame.domain.exception;

public class RangeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] %s %d ~ %d 사이의 값만 입력할 수 있습니다.";

    public RangeException(final String name, final int startRange, final int endRange) {
        super(String.format(ERROR_MESSAGE, name, startRange, endRange));
    }
}
