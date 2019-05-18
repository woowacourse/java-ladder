package ladder.util;

import java.util.List;

public class NotNullValidator {
    public static void validateNotNull(Object o) {
        if (o instanceof List) {
            validateListNotNull((List)o);
        }
        if (o == null) {
            throw new IllegalArgumentException("생성자의 인자로 null을 넘겨줄 수 없습니다.");
        }
    }

    private static void validateListNotNull(List l) {
        if (l == null || l.contains(null)) {
            throw new IllegalArgumentException("생성자의 인자로 null을 넘겨줄 수 없습니다.");
        }
    }
}
