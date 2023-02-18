package domain;

import domain.validator.PlayersValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(final List<Player> players) {
        PlayersValidator.validate(players);
        this.players = new ArrayList<>(players);
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getPlayerSize() {
        return players.size();
    }

}
