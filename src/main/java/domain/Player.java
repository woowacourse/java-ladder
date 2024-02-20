package domain;

public class Player {
    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if ((name.isBlank() || name.length() > 5)) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
