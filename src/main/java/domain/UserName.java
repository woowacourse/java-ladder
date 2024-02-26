package domain;

import java.util.regex.Pattern;

public class UserName {

    private static final Pattern SPECIAL_CHARACTER = Pattern.compile("[ !@#$%^&*().?\":{}|<>]");
    private static final int MAX_USERNAME_LENGTH = 5;

    private final String name;

    public UserName(final String name) {
        validate(name);
        this.name = name;
    }


    private void validate(final String name) {
        validateLength(name);
        validateEmpty(name);
        validateSpecialCharacter(name);
    }

    private void validateEmpty(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 사용자 이름은 비어 있을 수 없습니다.", name));
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_USERNAME_LENGTH) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 사용자 이름은 %d글자 이하로 입력해 주세요.", name, MAX_USERNAME_LENGTH));
        }
    }

    private void validateSpecialCharacter(final String name) {
        if (SPECIAL_CHARACTER.matcher(name).find()) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 특수기호는 들어갈 수 없습니다.", name));
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
