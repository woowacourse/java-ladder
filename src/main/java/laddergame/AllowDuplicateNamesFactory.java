package laddergame;

import org.apache.commons.lang3.StringUtils;

public abstract class AllowDuplicateNamesFactory implements NamesFactory {

    protected void validate(String names) {
        checkBlank(names);
        checkLastIndexOfInput(names);
    }

    private void checkLastIndexOfInput(final String input) {
        if (input.lastIndexOf(this.DELIMITER) == (input.length() - 1)) {
            throw new IllegalArgumentException("콤마로 끝나면 안됩니다");
        }
    }

    private void checkBlank(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("공백 문자를 입력하지마세요");
        }
    }
}
