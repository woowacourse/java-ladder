package domain;

import java.util.Collections;
import java.util.List;
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
                .map(name -> new Player(name))
                .collect(Collectors.toList());
    }

    public boolean isIncludePlayerName(String playerName) {
        return players.stream()
                .anyMatch(player -> player.getName().equals(playerName) || playerName.equals("all"));
    }

    public void switchingPlayers(Line line) {
        for (int pointNumber = 0; pointNumber < line.getSize(); pointNumber++) {
            calculatePoints(line, pointNumber);
        }
    }

    private void calculatePoints(Line line, int pointNumber) {
        if (line.canGoThisPoint(pointNumber)) {
            Collections.swap(players, pointNumber, pointNumber + 1);
        }
    }
}