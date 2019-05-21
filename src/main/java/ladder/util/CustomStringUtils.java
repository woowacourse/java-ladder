package ladder.util;

import org.apache.commons.lang3.StringUtils;

public class CustomStringUtils {
    private static final String VIOLATE_BLANK = "아무것도 입력하지 않으셨습니다. 다시 입력해주세요.";

    public static void checkIsBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(VIOLATE_BLANK);
        }
    }
}
