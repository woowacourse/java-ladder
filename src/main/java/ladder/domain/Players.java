package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_COUNT_OF_PLAYERS = 2;
    private final List<Player> players;

    public Players(List<Player> players) {
        validateDuplicatedNames(players);
        validateCountOfPlayers(players);

        this.players = new ArrayList<>(players);
    }

    private void validateDuplicatedNames(List<Player> players) {
        Set<String> names = players.stream()
                .map(Player::getName)
                .collect(Collectors.toSet());

        if(names.size() != players.size()) {
            throw new IllegalArgumentException("플레이어의 이름이 중복됩니다.");
        }
    }

    private void validateCountOfPlayers(List<Player> players) {
        if(players.size() < MINIMUM_COUNT_OF_PLAYERS) {
            throw new IllegalArgumentException("플레이어의 수는 2명 이상이어야 합니다.");
        }
    }

}
