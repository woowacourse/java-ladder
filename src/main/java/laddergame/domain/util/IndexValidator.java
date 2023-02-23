package laddergame.domain.util;

public class IndexValidator {

    private static final int INDEX_UNDER_LIMIT = -1;

    public static void validateBounds(int index, int size, String exceptionMessage) {
        if (index < INDEX_UNDER_LIMIT || index > (size + INDEX_UNDER_LIMIT)) {
            throw new IllegalArgumentException(ExceptionMessageFormatter.format(exceptionMessage, index));
        }
    }
}
