package ladder.domain;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.regex.Pattern;

public class Name {

    private static final Pattern NAME_FORMAT = Pattern.compile("[a-zA-Z]+");
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_FORMAT_ERROR_MESSAGE = "사람 이름은 영문자만 가능합니다. 현재 입력은 {0} 입니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE =
            "사람 이름은 " + NAME_MAX_LENGTH + "글자까지 가능합니다. 현재 입력은 {0} 입니다.";

    private final String value;

    public Name(final String value) {
        final String trimValue = value.trim();
        validate(trimValue);
        this.value = trimValue;
    }

    private void validate(final String value) {
        validateFormat(value);
        validateLength(value);
    }

    private void validateFormat(final String value) {
        if (isNotEnglish(value)) {
            throw new IllegalArgumentException(MessageFormat.format(NAME_FORMAT_ERROR_MESSAGE, value));
        }
    }

    private boolean isNotEnglish(final String value) {
        return !NAME_FORMAT.matcher(value).matches();
    }

    private void validateLength(final String value) {
        if (hasExceedLength(value)) {
            throw new IllegalArgumentException(MessageFormat.format(NAME_LENGTH_ERROR_MESSAGE, value));
        }
    }

    private boolean hasExceedLength(final String value) {
        return value.length() > NAME_MAX_LENGTH;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Name name = (Name) o;
        return Objects.equals(getValue(), name.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
