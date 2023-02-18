package laddergame.domain.exception;

public class RangeException extends IllegalArgumentException {

    public static final String errorMessage = "[ERROR] %d ~ %d 사이의 값만 입력할 수 있습니다.";

    public RangeException(final int startRange, final int endRange) {
        super(String.format(errorMessage, startRange, endRange));
    }
}
