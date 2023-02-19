package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MINIMUM_PLAYERS_SIZE = 2;

    private final List<Player> players;

    public Players(List<String> names) {
        validatePlayersSize(names);
        this.players = generatePlayer(names);
    }

    private void validatePlayersSize(List<String> names) {
        if (names.size() < MINIMUM_PLAYERS_SIZE) {
            throw new IllegalArgumentException("플레이어는 최소 2명 이상이여야 합니다");
        }
    }

    private List<Player> generatePlayer(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name, 0));
        }
        return players;
    }

    public int getSize() {
        return players.size();
    }

    public List<String> getNameValues() {
        return players.stream()
                .map(Player::getName)
                .map(Name::getValue)
                .collect(Collectors.toList());
    }
}
