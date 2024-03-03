package domain.name;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private static final Pattern ALPHABET_PATTERN = Pattern.compile("^[^a-zA-Z]+$");
    private static final List<String> RESERVED_WORDS = List.of("all");
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        validateNameCharacters(name);
        validateNameReservedWord(name);
        this.name = name;
    }

    public String getName() {
        return name;
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

    private void validateNameCharacters(String name) {
        Matcher matcher = ALPHABET_PATTERN.matcher(name);
        if (matcher.matches()) {
            throw new LadderGameException(ExceptionType.INVALID_NAME_CHARACTER);
        }
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new LadderGameException(ExceptionType.INVALID_NAME_LENGTH_RANGE);
        }
    }

    private void validateNameReservedWord(String name) {
        if (RESERVED_WORDS.contains(name)) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_RESERVED_WORD);
        }
    }
}
