package domain;

public class User {
    private final String name;

    public User(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }
}
