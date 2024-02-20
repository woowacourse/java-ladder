package ladder.domain;

import java.util.regex.Pattern;

public class User {

    private final String name;

    public User(String name) {
        validateNameLength(name);
        validateNameEngFormat(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 사용자 이름의 길이는 1~5글자여야 합니다.");
        }
    }

    private void validateNameEngFormat(String name) {
        if (!Pattern.matches("^[a-zA-Z]+$", name)) {
            throw new IllegalArgumentException("[ERROR] 사용자 이름은 영문 대소문자만 허용합니다.");
        }
    }
}
