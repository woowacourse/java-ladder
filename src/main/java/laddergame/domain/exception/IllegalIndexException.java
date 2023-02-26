package laddergame.domain.exception;

import java.util.List;

public class IllegalIndexException extends IndexOutOfBoundsException {

    private static final String message = "범위를 벗어났습니다.";

    public IllegalIndexException(List<?> target, int index) {
        super(message + " (size: " + target.size() + ", index: " + index + ")");
    }
}
