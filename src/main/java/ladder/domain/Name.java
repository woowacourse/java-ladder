package ladder.domain;

import java.util.regex.Pattern;

public class Name {

    private final String name;
    private static final Pattern specialCharactersFilter = Pattern.compile("[^a-zA-Z0-9\\s]");

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameLength(name);
        validateNameIsNotBlank(name);
        validateNotContainsSpecialCharacters(name);
    }

    private void validateNotContainsSpecialCharacters(String name) {
        if (isContainsSpecialCharacters(name)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameIsNotBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isContainsSpecialCharacters(String name) {
        return specialCharactersFilter.matcher(name).matches();
    }
}
