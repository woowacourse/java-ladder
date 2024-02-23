package domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Name {
    static final int MAX_NAME_LENGTH = 5;
    private static final Pattern NAME_CHARACTER_REGEX = Pattern.compile("^[^a-zA-Z]+$");
    private final String name;

    Name(String name) {
        validateNameLength(name);
        validateNameCharacters(name);
        this.name = name;
    }

    private static void validateNameCharacters(String name) {
        Matcher matcher = NAME_CHARACTER_REGEX.matcher(name);
        if (matcher.matches()) {
            throw new LadderGameException(ExceptionType.NAME_CHARACTER);
        }
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new LadderGameException(ExceptionType.NAME_LENGTH_RANGE);
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
        Name other = (Name) o;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    String getName() {
        return name;
    }
}
