package domain;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
