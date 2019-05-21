package ladder.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class CustomStringUtils {
    private static final String VIOLATE_BLANK = "아무것도 입력하지 않으셨습니다. 다시 입력해주세요.";

    public static List<String> splitString(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(VIOLATE_BLANK);
        }
        return Arrays.asList(input.split(","));
    }
}
