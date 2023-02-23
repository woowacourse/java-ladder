package domain.player;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<Player> players;

    private static final int PLAYER_MIN_COUNT = 2;
    private static final int PLAYER_MAX_COUNT = 12;
    private static final String PLAYER_COUNT_ERROR_MESSAGE = "[ERROR] 플레이어 수는 2~12명만 입력 가능합니다.";
    private static final String PLAYER_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 중복이 불가능합니다.";

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players generate(List<String> playersName) {
        checkPlayers(playersName);
        List<Player> players = new ArrayList<>();
        for (int index = 0; index < playersName.size(); index++) {
            players.add(new Player(playersName.get(index), index));
        }
        return new Players(players);
    }

    public int getMaxPlayerNameLength() {
        return players.stream()
                .mapToInt(player -> player.getPlayerName().length())
                .max()
                .orElseThrow();
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    private static void checkPlayers(List<String> playerNames) {
        checkPlayerCount(playerNames);
        checkDuplicatePlayers(playerNames);
    }

    private static void checkPlayerCount(List<String> players) {
        if (players.size() < PLAYER_MIN_COUNT || players.size() > PLAYER_MAX_COUNT) {
            throw new IllegalArgumentException(PLAYER_COUNT_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicatePlayers(List<String> players) {
        if (players.stream().distinct().count() != players.size()) {
            throw new IllegalArgumentException(PLAYER_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
