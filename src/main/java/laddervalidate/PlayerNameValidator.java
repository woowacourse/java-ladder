package laddervalidate;

import java.util.List;

public class PlayerNameValidator {
    private static final int PLAYER_MIN_COUNT = 2;
    private static final int PLAYER_MAX_COUNT = 12;
    private static final int PLAYER_NAME_MAX_SIZE = 5;
    private static final String BLANK = " ";
    private static final String NON_BLANK = "";
    public static final String PLAYER_COUNT_ERROR_MESSAGE = "플레이어 수는 2~12명만 입력 가능합니다.";
    public static final String PLAYER_NAME_LENGTH_ERROR_MESSAGE = "플레이어 이름음 1~5글자만 가능합니다.";
    public static final String PLAYER_NAME_DUPLICATE_ERROR_MESSAGE = "플레이어의 이름은 중복이 불가능합니다.";

    public void validate(List<String> players){
        checkPlayerCount(players);
        checkPlayerNameLength(players);
        checkDuplicatePlayers(players);
    }

    private void checkPlayerCount(List<String> players) {
        if (players.size() < PLAYER_MIN_COUNT || players.size() > PLAYER_MAX_COUNT) {
            throw new IllegalArgumentException(PLAYER_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkPlayerNameLength(List<String> players) {
        if (players.stream()
                .anyMatch(player -> player.length() >
                        PLAYER_NAME_MAX_SIZE || player.replaceAll(BLANK, NON_BLANK).isEmpty())) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void checkDuplicatePlayers(List<String> players) {
        if (players.stream().distinct().count() != players.size()) {
            throw new IllegalArgumentException(PLAYER_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
