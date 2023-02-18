package domain;

public class User {

    public static final int NAME_LENGTH_UPPER_BOUND = 5;
    private final String name;

    public User(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name.isEmpty() || name.length() > NAME_LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
