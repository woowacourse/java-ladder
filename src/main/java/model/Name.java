package model;

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
        validateNameLength(name);
        validateNameHasOnlyCharacters(name);
        this.name = name;
    }

    public String getValue() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Name otherName = (Name) object;
        return Objects.equals(name, otherName.getValue());
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(MAXIMUM_NAME_LENGTH_ERROR, MAXIMUM_NAME_LENGTH));
        }
    }

    private void validateNameHasOnlyCharacters(String name) {
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NAME_HAS_NON_ALPHABETIC_ERROR);
        }
    }
}
