package ladder.domain.user;

import java.util.regex.Pattern;

public class User {

    private static final String ALPHABET_FORMAT = "^[a-zA-Z0-9 ]+$";
    private static final String BLANK = " ";
    private static final int MAX_NAME_LENGTH = 5;

    private final String userName;

    public User(String userName) {
        validateNameLength(userName);
        validateNameEngFormat(userName);
        validateContainedBlank(userName);
        this.userName = userName;
    }

    private void validateNameLength(String userNameToAdd) {
        if (userNameToAdd.isEmpty() || userNameToAdd.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 사용자 이름의 길이는 1~5글자여야 합니다.");
        }
    }

    private void validateNameEngFormat(String userNameToAdd) {
        if (!Pattern.matches(ALPHABET_FORMAT, userNameToAdd)) {
            throw new IllegalArgumentException("[ERROR] 사용자 이름은 영문 대소문자와 숫자만 허용합니다.");
        }
    }

    private void validateContainedBlank(String userNameToAdd) {
        if (userNameToAdd.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 사용자 이름 내에는 공백을 허용하지 않습니다.");
        }
    }

    public String getUserName() {
        return userName;
    }
}
