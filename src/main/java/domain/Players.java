package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int PLAYER_NUMBER_LOWER_BOUND_INCLUSIVE = 2;
    private static final int PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE = 20;
    public static final String PLAYER_NUMBER_RANGE_ERROR_MESSAGE = "참여자 수는 2 ~ 20명만 가능합니다.";
    private static final String PLAYER_NAME_DUPLICATION_ERROR_MESSAGE = "이름은 중복될 수 없습니다.";

    private final List<Player> players;

    private Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    public static Players from(List<String> names) {
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            players.add(new Player(name, i));
        }

        return new Players(players);
    }

    private void validate(List<Player> players) {
        validateDuplication(players);
        validatePlayerNumber(players.size());
    }

    private void validateDuplication(List<Player> players) {
        int duplicationSize = players.stream()
                .map(Player::getName)
                .collect(Collectors.toSet())
                .size();

        if (duplicationSize != players.size()) {
            throw new IllegalArgumentException(PLAYER_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validatePlayerNumber(int playerNumber) {
        if (isOutOfRange(playerNumber)) {
            throw new IllegalArgumentException(PLAYER_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(int playerNumber) {
        return !(PLAYER_NUMBER_LOWER_BOUND_INCLUSIVE <= playerNumber
                && playerNumber <= PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE);
    }

    public List<Player> getPlayers() {
        return List.copyOf(this.players);
    }

    public int getSize() {
        return players.size();
    }

}
