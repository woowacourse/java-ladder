package domain;

import java.util.regex.Pattern;

public class UserName {
    private final String userName;

    public UserName(final String userName) {
        validate(userName);
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userName;
    }

    private void validate(final String userName) {
        validateLength(userName);
        validateEmpty(userName);
        validateSpecialCharacter(userName);
    }

    private void validateEmpty(final String userName) {
        if (userName.isEmpty()) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 사용자 이름은 비어 있을 수 없습니다.", userName));
        }
    }

    private void validateLength(final String userName) {
        if (userName.length() > 5) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 사용자 이름은 5글자 이하로 입력해 주세요.", userName));
        }
    }

    private void validateSpecialCharacter(final String userName) {
        final Pattern specialCharacter = Pattern.compile("[ !@#$%^&*().?\":{}|<>]");

        if (specialCharacter.matcher(userName).find()) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 특수기호는 들어갈 수 없습니다.", userName));
        }
    }
}
