package laddervalidate;

import java.util.List;

public class PlayerNameValidator {
    private static final int PLAYER_MIN_COUNT = 2;
    private static final int PLAYER_MAX_COUNT = 12;
    private static final int PLAYER_NAME_MAX_SIZE = 5;
    private static final String BLANK = " ";
    private static final String NON_BLANK = "";

    public void checkPlayerCount(List<String> players) {
        if (players.size() < PLAYER_MIN_COUNT || players.size() > PLAYER_MAX_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public void checkPlayerNameLength(List<String> players) {
        if (players.stream()
                .anyMatch(player -> player.length() >
                        PLAYER_NAME_MAX_SIZE || player.replaceAll(BLANK, NON_BLANK).isEmpty())) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicatePlayers(List<String> players) {
        if (players.stream().distinct().count() != players.size()) {
            throw new IllegalArgumentException();
        }
    }
}
