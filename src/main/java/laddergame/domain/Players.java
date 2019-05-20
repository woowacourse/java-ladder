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

    public int size() {
        return players.size();
    }

    @Override
    public String toString() {
        StringBuilder playersView = new StringBuilder();
        for (Player player : players) {
            playersView.append(player);
        }
        return playersView.toString();
    }
}
