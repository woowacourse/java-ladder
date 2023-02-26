package laddergame.util;

import java.util.List;
import laddergame.domain.exception.IllegalIndexException;

public class IndexValidator {

    private static final int INDEX_UNDER_LIMIT = -1;

    public static void validateBounds(final List<?> target, final int index) {
        if (index <= INDEX_UNDER_LIMIT || index > (target.size() + INDEX_UNDER_LIMIT)) {
            throw new IllegalIndexException(target, index);
        }
    }
}
