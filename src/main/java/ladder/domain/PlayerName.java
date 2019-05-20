package ladder.domain;

public class PlayerName {
    private static final int MAX_PLAYER_NAME_LENGTH = 5;

    private final String name;

    public PlayerName(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private static boolean checkNameLength(String name) {
        return name.length() <= MAX_PLAYER_NAME_LENGTH;
    }
}
