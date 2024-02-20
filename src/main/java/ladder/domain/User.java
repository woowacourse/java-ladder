package ladder.domain;

import java.util.regex.Pattern;

public class User {

    private final String name;

    public User(String name) {
        validateNameLength(name);
        validateNameEngFormat(name);
        validateBlankInName(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 사용자 이름의 길이는 1~5글자여야 합니다.");
        }
    }

    private void validateNameEngFormat(String name) {
        if (!Pattern.matches("^[a-z A-Z]+$", name)) {
            throw new IllegalArgumentException("[ERROR] 사용자 이름은 영문 대소문자만 허용합니다.");
        }
    }

    private void validateBlankInName(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 사용자 이름 내에는 공백을 허용하지 않습니다.");
        }
    }
}
