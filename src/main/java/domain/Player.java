package domain;

public class Player {
    public Player(String name) {
        validate(name);
    }

    private static void validate(String name) {
        if ((name.isBlank() || name.length() > 5)) {
            throw new IllegalArgumentException();
        }
    }
}
