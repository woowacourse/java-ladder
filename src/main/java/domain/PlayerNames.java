package domain;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {
    public static final String PLAYERS_SIZE_ERROR_MESSAGE = "[ERROR] 사다리 게임을 위해서는 2명 이상의 플레이어가 필요합니다";
    public static final String SAME_PLAYER_NAME_ERROR_MESSAGE = "[ERROR] 중복된 플레이어의 이름이 존재합니다";
    public static final int MIN_PLAYERS_SIZE = 2;
    private final List<PlayerName> playerNames;

    public PlayerNames(List<String> playerNames) {
        playerNames = validatePlayerNames(playerNames);
        this.playerNames = createPlayerNames(playerNames);
    }

    private List<String> validatePlayerNames(List<String> playerNames) {
        validatePlayerName(playerNames);
        validatePlayerSize(playerNames);
        validateSamePlayerName(playerNames);
        return playerNames;
    }


    private static void validatePlayerName(List<String> playerNames) {
        for (String playerName : playerNames) {
            PlayerName.validateName(playerName);
        }
    }

    private static void validatePlayerSize(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYERS_SIZE) {
            throw new IllegalArgumentException(PLAYERS_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateSamePlayerName(List<String> playerNames) {
        if (playerNames.size() != playerNames.stream().distinct().count()) {
            throw new IllegalArgumentException(SAME_PLAYER_NAME_ERROR_MESSAGE);
        }
    }

    private List<PlayerName> createPlayerNames(List<String> playerNames) {
        return playerNames.stream().map(PlayerName::new).collect(Collectors.toList());
    }

    public List<PlayerName> getPlayerNames() {
        return this.playerNames;
    }
}
