package ladder.model;

import java.util.HashSet;
import java.util.List;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> playerNames) {
        validate(playerNames);
        return new Players(playerNames.stream()
                .map(Player::new)
                .toList()
        );
    }

    private static void validate(List<String> playerNames) {
        if (isDuplicated(playerNames)) {
            throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
        }
    }

    private static boolean isDuplicated(List<String> playerNames) {
        return new HashSet<>(playerNames).size() != playerNames.size();
    }

    public int getSize() {
        return players.size();
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }
}
