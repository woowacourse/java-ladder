package domain;

public class User {
    private String username;

    public User() {
    }

    public User(String username) {
        validate(username);
        this.username = username;
    }

    private void validate(String username) {
        validateNameLength(username);
    }

    private static void validateNameLength(String username) {
        if (username.length() > 5) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 사용자 이름은 5글자 이하로 입력해 주세요.", username));
        }
    }
}
