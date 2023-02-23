package ladder.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Player {

    private static final Pattern NAME_FORMAT = Pattern.compile("[a-zA-Z]+");
    private static final int NAME_MAX_LENGTH = 5;

    private final String value;

    public Player(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        validateFormat(value);
        validateLength(value);
    }

    private void validateFormat(final String value) {
        if (isNotEnglish(value)) {
            throw new IllegalArgumentException("플레이어 이름은 영문자만 가능합니다. 현재 입력은 " + value + "입니다.");
        }
    }

    private boolean isNotEnglish(final String value) {
        return !NAME_FORMAT.matcher(value).matches();
    }

    private void validateLength(final String value) {
        if (isInvalidLength(value)) {
            throw new IllegalArgumentException("플레이어 이름은 " + NAME_MAX_LENGTH + "글자까지 가능합니다. 현재 입력은 " + value + "입니다.");
        }
    }

    private boolean isInvalidLength(final String value) {
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
        final Player player = (Player) o;
        return Objects.equals(getValue(), player.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
