package domain;

import static message.ErrorMessage.INVALID_PLAYER_COUNT_EXCEPTION;
import static message.ErrorMessage.OVERLAP_PAYER_NAME_EXCEPTION;

import java.util.List;

public class Players {

    private static final int MINIMUM_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(List<Player> players) {
        validatePlayerOverlap(players);
        validatePlayerSize(players);
    }

    private void validatePlayerOverlap(List<Player> players) {
        long distinctSize = players.stream().map(Player::getName).distinct().count();
        if (players.size() != distinctSize) {
            throw new IllegalArgumentException(OVERLAP_PAYER_NAME_EXCEPTION.getMessage());
        }
    }

    private void validatePlayerSize(List<Player> players) {
        if (players.size() < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException(INVALID_PLAYER_COUNT_EXCEPTION.getMessage());
        }
    }

    public int getPlayerOrderNumber(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
