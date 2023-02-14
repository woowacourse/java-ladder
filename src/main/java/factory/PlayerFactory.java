package factory;

import domain.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerFactory {

    public static final int PLAYER_MIN_SIZE = 1;
    public static final int PLAYER_MAX_SIZE = 20;

    public static List<Player> generate(List<String> playerNames) {
        validate(playerNames);
        return playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private static void validate(List<String> playerNames) {
        if (playerNames.size() < PLAYER_MIN_SIZE || playerNames.size() > PLAYER_MAX_SIZE) {
            throw new IllegalArgumentException("참여자는 1명 이상 20명 이하로 입력할 수 있습니다.");
        }
    }
}
