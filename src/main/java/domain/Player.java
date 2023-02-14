package domain;

public class Player {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    
    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name.isBlank() || name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
