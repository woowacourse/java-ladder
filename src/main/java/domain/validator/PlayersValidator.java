package domain.validator;

import domain.Player;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersValidator {

    private static final int PLAYER_MIN_SIZE = 1;
    private static final int PLAYER_MAX_SIZE = 20;

    public static void validate(final List<Player> players) {
        validatePlayerSize(players);
        validateDuplication(players);
    }

    private static void validatePlayerSize(final List<Player> players) {
        if (players.size() < PLAYER_MIN_SIZE || players.size() > PLAYER_MAX_SIZE) {
            throw new IllegalArgumentException("참여자 수는 1명 이상 20명 이하입니다.");
        }
    }

    private static void validateDuplication(final List<Player> players) {
        List<String> playerNames = players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new IllegalArgumentException("참여자 이름은 중복될 수 없습니다.");
        }
    }

}
