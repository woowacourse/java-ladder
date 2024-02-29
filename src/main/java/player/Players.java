package player;

import java.util.List;

public class Players {

    private static final int MIN_PLAYER_SIZE = 2;
    private static final int MAX_PLAYER_SIZE = 10;

    private final List<Player> players;

    public Players(List<String> playerNames) {
        validateSize(playerNames);
        this.players = playerNames.stream()
                .map(Player::new)
                .toList();
    }

    private void validateSize(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYER_SIZE || playerNames.size() > MAX_PLAYER_SIZE) {
            throw new IllegalArgumentException("참여자의 수는 2명 이상 10명 이하로 작성해야 합니다.");
        }
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }

    public int size() {
        return players.size();
    }
}
