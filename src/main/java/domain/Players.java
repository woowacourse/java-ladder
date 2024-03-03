package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    public static final int MAXIMUM_PLAYER_SIZE = 10;
    private static final int MINIMUM_PLAYER_SIZE = 2;

    private final List<Player> players;

    public Players(List<String> names) {
        validate(names);
        this.players = convertToPlayer(names);
    }

    private void validate(List<String> names) {
        int size = names.size();
        if (size < MINIMUM_PLAYER_SIZE || size > MAXIMUM_PLAYER_SIZE) {
            throw new IllegalArgumentException(String.format("2명 이상, 10명 이하인 인원만 입력해주세요. 입력한 인원 : %d", size));
        }
    }

    private List<Player> convertToPlayer(List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int getTotalPlayerSize() {
        return players.size();
    }

    public int getPositionOf(Player player) {
        return players.indexOf(player);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
