package ladder.domain;

public class User {

    private String name;

    public User(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }
}
