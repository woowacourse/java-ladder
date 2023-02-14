package domain;

public class User {
    String name;

    public User(String name) {
        validateLength(name);
        validateBlank(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
