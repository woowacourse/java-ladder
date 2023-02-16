package domain;

public class PlayerName {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;

    private final String name;

    public PlayerName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name.isBlank() || name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
