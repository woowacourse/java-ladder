package ladder.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Player {

    private static final Pattern NAME_FORMAT = Pattern.compile("[a-zA-Z]+");
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Player(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (!NAME_FORMAT.matcher(value).matches()) {
            throw new IllegalArgumentException("플레이어 이름은 영문자만 가능합니다. 현재 입력은 " + value + "입니다.");
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("플레이어 이름은 " + MAX_NAME_LENGTH + "글자까지 가능합니다. 현재 입력은 " + value + "입니다.");
        }
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
