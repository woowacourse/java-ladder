package ladder.domain;

import java.util.regex.Pattern;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;
    private static final Pattern specialCharactersFilter = Pattern.compile("[^a-zA-Z0-9\\s]");

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        validateNameLength(name);
        validateNameIsNotBlank(name);
        validateNotContainsSpecialCharacters(name);
    }

    private void validateNotContainsSpecialCharacters(String name) {
        if (isContainsSpecialCharacters(name)) {
            throw new IllegalArgumentException("이름은 특수문자를 포함할 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 최대 "+MAXIMUM_NAME_LENGTH+"글자 까지 가능합니다.");
        }
    }

    private void validateNameIsNotBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백을 허용하지 않습니다.");
        }
    }

    private boolean isContainsSpecialCharacters(String name) {
        return specialCharactersFilter.matcher(name).find();
    }
}
