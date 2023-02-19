package laddergame.domain;

import java.text.MessageFormat;
import java.util.Optional;
import java.util.regex.Pattern;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String DEFAULT_NAME = "ANONY";
    private static final String NAME_NOT_MACHE_EXCEPTION = "이름은 1자 이상의 영문만 들어올 수 있습니다.";
    private static final String NAME_NULL_EXCEPTION = "이름은 null이 될 수 없습니다.";
    private static final String NAME_OVER_LENGTH_EXCEPTION = "이름은 {0}글자를 초과할 수 없습니다.";
    private static final Pattern NAME_REGEX = Pattern.compile("([a-z]|[A-Z])+");

    private final String value;


    public Name(final String inputName) {
        final String value = Optional.ofNullable(inputName).orElse(DEFAULT_NAME);
        validateName(value);
        this.value = value;
    }

    private void validateName(final String value) {
        if (value == null) {
            throw new IllegalArgumentException(NAME_NULL_EXCEPTION);
        }
        if (!NAME_REGEX.matcher(value).matches()) {
            throw new IllegalArgumentException(NAME_NOT_MACHE_EXCEPTION);
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    MessageFormat.format(NAME_OVER_LENGTH_EXCEPTION, MAX_NAME_LENGTH));
        }
    }

    public String getValue() {
        return value;
    }
}
