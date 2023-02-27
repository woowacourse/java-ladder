package ladder.domain.player;

import ladder.domain.exception.NoSuchPlayerException;
import ladder.domain.exception.PlayerNumberException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Players {

    private static final int PLAYER_MINIMUM_NUMBER = 2;

    private final List<Player> players;
    private final Map<Player, String> gameRecords;

    public Players(final List<String> playerNames) {
        validatePlayerNumber(playerNames);
        players = mapPlayerNamesToPlayers(playerNames);
        gameRecords = new HashMap<>();
    }

    private void validatePlayerNumber(final List<String> playerNames) {
        if (playerNames.size() < PLAYER_MINIMUM_NUMBER) {
            throw new PlayerNumberException();
        }
    }

    private List<Player> mapPlayerNamesToPlayers(final List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public void recordGameResult(List<String> gameRecord) {
        for (int i = 0; i < size(); i++) {
            gameRecords.put(players.get(i), gameRecord.get(i));
        }
    }

    public Map<Player, String> getAllGameRecords() {
        return Map.copyOf(gameRecords);
    }

    public Map.Entry<Player, String> getGameRecordFor(String playerName) {
        return gameRecords.entrySet().stream()
                .filter((entry -> entry.getKey().getName().equals(playerName)))
                .findFirst()
                .orElseThrow(NoSuchPlayerException::new);
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public int size() {
        return players.size();
    }
}
