package ladder.domain.participant;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final Pattern specialCharactersFilter = Pattern.compile("[^ㄱ-ㅎ가-힣a-zA-Z0-9\\s]");

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameLength(name);
        validateNameIsNotBlank(name);
        validateNotContainsSpecialCharacters(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 최대 " + MAXIMUM_NAME_LENGTH + "글자 까지 가능합니다.");
        }
    }

    private void validateNameIsNotBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백을 허용하지 않습니다.");
        }
    }

    private void validateNotContainsSpecialCharacters(String name) {
        if (isContainsSpecialCharacters(name)) {
            throw new IllegalArgumentException("이름은 특수문자를 포함할 수 없습니다.");
        }
    }

    private boolean isContainsSpecialCharacters(String name) {
        return specialCharactersFilter.matcher(name).find();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name other = (Name) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
