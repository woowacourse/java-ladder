package laddergame.domain.game;

public enum GameCommand {

    PLAYER,
    ALL_PLAYER;

    public static final String ALL_PLAYER_COMMAND = "all";

    public static GameCommand of(final String requestContent) {
        if (requestContent.equals(ALL_PLAYER_COMMAND)) {
            return ALL_PLAYER;
        }
        return PLAYER;
    }
}
