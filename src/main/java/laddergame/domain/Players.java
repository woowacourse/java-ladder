package laddergame.domain;

import laddergame.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_PLAYERS = 2;

    private List<Player> players;

    public Players(List<String> names) {
        Validator.checkNumberOfNames(names, MIN_PLAYERS);
        Validator.checkDuplicateNames(names);

        players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Player get(int index) {
        return players.get(index);
    }

    public List<String> getPlayersNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int size() {
        return players.size();
    }
}
