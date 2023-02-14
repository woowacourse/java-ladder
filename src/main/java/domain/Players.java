package domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(String input) {
        String[] names = input.split(",");
        this.players = Arrays.stream(names)
                .map(Player::new)
                .collect(toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
