package laddergame.utils;

import java.text.MessageFormat;
import java.util.Optional;

public class OptionalUtils {
    private static final String OPTIONAL_NULL_EXCEPTION = "{0}에서 null 체크 오류가 발생하였습니다.";

    private OptionalUtils() {
    }

    public static <T> T getValueAfterNullCheck(T t) {
        return Optional.ofNullable(t)
                .orElseThrow(() -> new IllegalArgumentException(MessageFormat.format(OPTIONAL_NULL_EXCEPTION, t)));
    }
}
