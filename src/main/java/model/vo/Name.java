package model.vo;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String MAXIMUM_NAME_LENGTH_ERROR = "[ERROR] 사람 최대 이름 길이는 %d 이하로만 가능합니다.";
    private static final String NAME_HAS_NON_ALPHABETIC_ERROR = "[ERROR] 사람 이름은 영문자로만 입력되어야 합니다.";
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

    private final String name;

    public Name(String name) {
        validateLength(name);
        validateHasOnlyCharacters(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSame(Name other) {
        return this.name.equals(other.name);
    }

    private void validateLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(MAXIMUM_NAME_LENGTH_ERROR, MAXIMUM_NAME_LENGTH));
        }
    }

    private void validateHasOnlyCharacters(String name) {
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NAME_HAS_NON_ALPHABETIC_ERROR);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Name otherName = (Name) other;
        return Objects.equals(name, otherName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
