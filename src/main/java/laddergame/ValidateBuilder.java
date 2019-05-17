package laddergame;

import laddergame.domain.Builder;
import org.apache.commons.lang3.StringUtils;

public abstract class ValidateBuilder implements Builder {
    private static final String COMMA = ",";

    protected void validate(String names) {
        checkLastIndexOfInput(names);
        checkBlank(names);
    }

    private void checkLastIndexOfInput(String input) {
        if (input.lastIndexOf(COMMA) == (input.length() - 1)) {
            throw new IllegalArgumentException("콤마로 끝나면 안됩니다");
        }
    }

    private void checkBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("공백 문자를 입력하지마세요");
        }
    }
}
