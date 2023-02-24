package laddergame.util;

import java.util.Objects;

public class NullChecker {
    public static <T> void checkNull(T obj, String message) {
        if (Objects.isNull(obj)) {
            throw new NullPointerException(message);
        }
    }
}
