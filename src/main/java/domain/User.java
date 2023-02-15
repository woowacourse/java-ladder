package domain;

public class User {
    private final String name;

    public User(String name) {
        validateLength(name);
        validateBlank(name);
        this.name = name;
    }

    public String getName() {
        return name;
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
