package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Players {

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> names) {
        validateDuplicatedNames(names);
        preparePlayers(names);
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("참가자의 이름은 중복될 수 없습니다.");
        }
    }

    private void preparePlayers(List<String> names) {
        for (String name : names) {
            players.add(new Player(name));
        }
    }

    public int findPositionOfPlayer(String name) {
        return players.indexOf(findPlayerByName(name));
    }

    private Player findPlayerByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findAny()
                .orElseThrow();
    }

    public boolean isContained(String name) {
        boolean isContained = false;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return isContained;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
