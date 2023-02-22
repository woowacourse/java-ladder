package laddergame.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class PersonalName {
    private static final Pattern NAME_REGEX = Pattern.compile("([a-z]|[A-Z])+");
    private final String value;

    public static PersonalName valueOf(final String value) {
        return new PersonalName(value);
    }

    private PersonalName(final String name) {
        validate(name);
        this.value = name;
    }

    private void validate(final String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("이름은 null이 될 수 없습니다.");
        }
        if (!NAME_REGEX.matcher(value).matches()) {
            throw new IllegalArgumentException("이름은 영어로만 이루어져야합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonalName that = (PersonalName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String getValue() {
        return value;
    }
}
