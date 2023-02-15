package ladder.domain;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.regex.Pattern;

public class Player {

    private static final Pattern NAME_FORMAT = Pattern.compile("[a-zA-Z]+");
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_FORMAT_ERROR_MESSAGE = "사람 이름은 영문자만 가능합니다. 현재 입력은 {0} 입니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE =
            "사람 이름은 " + NAME_MAX_LENGTH + "글자까지 가능합니다. 현재 입력은 {0} 입니다.";

    private final String name;

    public Player(final String name) {
        final String trimName = name.trim();
        validate(trimName);
        this.name = trimName;
    }

    private void validate(final String name) {
        validateNameFormat(name);
        validateNameLength(name);
    }

    private void validateNameFormat(final String name) {
        if (isNotEnglish(name)) {
            throw new IllegalArgumentException(MessageFormat.format(NAME_FORMAT_ERROR_MESSAGE, name));
        }
    }

    private boolean isNotEnglish(final String name) {
        return !NAME_FORMAT.matcher(name).matches();
    }

    private void validateNameLength(final String name) {
        if (hasExceedLength(name)) {
            throw new IllegalArgumentException(MessageFormat.format(NAME_LENGTH_ERROR_MESSAGE, name));
        }
    }

    private boolean hasExceedLength(final String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    public String getName() {
        return name;
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
        return Objects.equals(getName(), player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

