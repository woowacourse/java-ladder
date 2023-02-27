package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players;

    public Players(List<String> names) {
        validatePlayerCount(names);
        this.players = createPlayers(names);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersCount() {
        return players.size();
    }

    private static void validatePlayerCount(List<String> names) {
        if (names.size() <= 1) {
            throw new IllegalArgumentException("사다리 게임의 최소 참가자 수는 2명 이상이어야 합니다.");
        }
    }

    private List<Player> createPlayers(List<String> names) {
        return names.stream()
                .map(name -> new Player(name, names.indexOf(name)))
                .collect(Collectors.toList());
    }

    public boolean contains(String name) {
        return players.stream()
                .anyMatch(player -> player.getName().equals(name));
    }

    public Map<String, Integer> calculatePosition(Lines lines) {
        Map<String, Integer> playerPositionResults = new HashMap<>();
        for (Player player : players) {
            playerPositionResults.put(player.getName(), lines.calculateResults(player.getPosition()));
        }
        return playerPositionResults;
    }
}