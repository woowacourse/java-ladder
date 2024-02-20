package laddergame.domain;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name.length() > NAME_MAX_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
