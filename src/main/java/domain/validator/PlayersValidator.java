package domain.validator;

import domain.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersValidator {
    private static final int PLAYER_MIN_COUNT = 2;
    private static final int PLAYER_MAX_COUNT = 12;
    private static final String PLAYER_COUNT_ERROR_MESSAGE = "[ERROR] 플레이어 수는 2~12명만 입력 가능합니다.";
    private static final String PLAYER_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 중복이 불가능합니다.";
    private static final String BLANK_MESSAGE = "[ERROR] 입력값이 비어있습니다.";
    private static final String NULL_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다.";

    public void checkPlayers(List<Player> players) {
        checkDuplicatePlayers(players);
        checkPlayerCount(players);
        checkNotEmpty(players);

    }

    private void checkPlayerCount(List<Player> players) {
        if (players.size() < PLAYER_MIN_COUNT || players.size() > PLAYER_MAX_COUNT) {
            throw new IllegalArgumentException(PLAYER_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkDuplicatePlayers(List<Player> players) {
        List<String> playerNames = players.stream()
                .map(player -> player.getPlayerName().getName())
                .collect(Collectors.toList());
        if (playerNames.stream().distinct().count() !=players.size()) {
            throw new IllegalArgumentException(PLAYER_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
    private static void checkNotEmpty(List<Player> players) {
        for (Player player : players) {
            checkBlank(player);
            checkNull(player);
        }
    }
    private static void checkBlank(Player player) {
        if (player.getPlayerName().getName().isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }

    private static void checkNull(Player player) {
        if (player == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }
}
