package laddergame.domain;

import org.apache.commons.lang3.StringUtils;

public class NamesValidator {

    public static void validateNames(String names) {
        checkNull(names, "치명적인 오류 발생");
        checkLastIndexOfNames(names);
    }

    private static void checkLastIndexOfNames(String names) {
        if (names.lastIndexOf(Constant.COMMA) == names.length() - 1) {
            throw new IllegalArgumentException("콤마 다음에는 이름을 써주세요.");
        }
    }

    private static void checkNull(String names, String s) {
        if (StringUtils.isBlank(names)) {
            throw new IllegalArgumentException(s);
        }
    }
}
