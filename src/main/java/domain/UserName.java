package domain;

import java.util.regex.Pattern;

public class UserName {
    private static final Pattern ALPHABET = Pattern.compile("^[a-zA-Z]*$");
    private static final int MAX_LENGTH = 5;

    private final String userName;

    public UserName(final String userName) {
        validate(userName);
        this.userName = userName;
    }

    private void validate(final String userName) {
        validateLength(userName);
        validateEmpty(userName);
        validateCharacter(userName);
    }

    private void validateEmpty(final String userName) {
        if (userName.isEmpty()) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 사용자 이름은 비어 있을 수 없습니다.", userName));
        }
    }

    private void validateLength(final String userName) {
        if (userName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("입력 된 값: %s, 사용자 이름은 %d글자 이하로 입력해 주세요.", userName, MAX_LENGTH));
        }
    }

    private void validateCharacter(final String userName) {
        if (!ALPHABET.matcher(userName).find()) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 영문만 입력해주세요.", userName));
        }
    }

    @Override
    public String toString() {
        return userName;
    }
}
