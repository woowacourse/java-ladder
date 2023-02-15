package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;
    public Players(List<String> playerNames) {
        this.players = playerNames.stream()
                .map(name -> new Player(name))
                .collect(Collectors.toUnmodifiableList());
    }
}
