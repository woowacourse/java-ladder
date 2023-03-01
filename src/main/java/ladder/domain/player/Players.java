package ladder.domain.player;

import ladder.domain.Name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final static int PLAYERS_MINIMUM_SIZE = 2;
    private final List<Player> players;

    public Players(List<String> names) {
        validateTooLessPlayer(names);
        validateDuplicateNames(names);
        players = new ArrayList<>();

        IntStream.range(0, names.size())
                .forEach(i -> players.add(new Player(names.get(i), i)));
    }

    private void validateDuplicateNames(List<String> names) {
        int distinctNameSize = new HashSet<>(names).size();
        int size = names.size();
        if (size != distinctNameSize) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private void validateTooLessPlayer(List<String> names) {
        if (names.size() < PLAYERS_MINIMUM_SIZE) {
            throw new IllegalArgumentException("플레이어는 2명 이상이어야 합니다.");
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .map(Name::getValue)
                .collect(Collectors.toList());
    }

    public Player findPlayerByName(String name) {
        return players.stream()
                .filter(
                        player -> player.getName().getValue().equals(name)
                )
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("같은 이름의 플레이어가 존재하지 않습니다."));
    }
}
