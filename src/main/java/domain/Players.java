package domain;

import java.util.List;

public class Players {
    private final List<String> players;

    public Players(List<String> players) {
        checkPlayerCount(players);
        checkPlayerNameLength(players);
        checkDuplicatePlayers(players);
        this.players = players;
    }

    public int getMaxPlayerNameLength() {
        return players.stream().mapToInt(String::length).max().orElse(0);
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<String> getPlayers() {
        return players;
    }

    private void checkPlayerCount(List<String> players) {
        if (players.size() < 2 || players.size() > 12) {
            throw new IllegalArgumentException();
        }
    }

    private void checkPlayerNameLength(List<String> players){
        if (players.stream()
                .anyMatch(player -> player.length() > 5 || player.replaceAll(" ", "").isEmpty())){
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicatePlayers(List<String> players) {
        if (players.stream().distinct().count() != players.size()){
            throw new IllegalArgumentException();
        }
    }

}
