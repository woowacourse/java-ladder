package laddergame.domain;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.regex.Pattern;

import static laddergame.utils.OptionalUtils.getValueAfterNullCheck;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_NOT_MACHE_EXCEPTION = "이름은 1자 이상의 영문만 들어올 수 있습니다.";
    private static final String NAME_OVER_LENGTH_EXCEPTION = "이름은 {0}글자를 초과할 수 없습니다.";
    private static final Pattern NAME_REGEX = Pattern.compile("([a-z]|[A-Z]|[0-9])+");

    private final String value;

    public Name(final String inputName) {
        final String value = getValueAfterNullCheck(inputName);
        validateName(value);
        this.value = value;
    }

    public boolean isSame(final String name) {
        return value.equals(name);
    }

    public String getValue() {
        return value;
    }

    private void validateName(final String value) {
        if (!NAME_REGEX.matcher(value).matches()) {
            throw new IllegalArgumentException(NAME_NOT_MACHE_EXCEPTION);
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    MessageFormat.format(NAME_OVER_LENGTH_EXCEPTION, MAX_NAME_LENGTH));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        Name name = (Name) o;
        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
