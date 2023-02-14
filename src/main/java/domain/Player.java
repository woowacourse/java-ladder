package domain;

public class Player {

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateSpace(name);
    }

    private void validateLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }
}
