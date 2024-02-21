package domain;

import java.util.regex.Pattern;

public class UserName {

    private String userName;

    public UserName(String userName) {
        validate(userName);
        this.userName = userName;
    }

    private void validate(String userName) {
        validateLength(userName);
        validateEmpty(userName);
        validateSpecialCharacter(userName);
    }

    private void validateEmpty(String userName) {
        if (userName.isEmpty()) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 사용자 이름은 비어 있을 수 없습니다.", userName));
        }
    }

    private void validateLength(String userName) {
        if (userName.length() > 5) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 사용자 이름은 5글자 이하로 입력해 주세요.", userName));
        }
    }

    private void validateSpecialCharacter(String userName) {
        Pattern specialCharacter = Pattern.compile("[ !@#$%^&*().?\":{}|<>]");

        if (specialCharacter.matcher(userName).find()) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 특수기호는 들어갈 수 없습니다.", userName));
        }
    }
}
