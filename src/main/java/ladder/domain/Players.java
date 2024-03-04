package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Players {

    private static final int MIN_SIZE = 2;

    private final List<Player> players;

    Players(String... strings) {
        this(Arrays.asList(strings));
    }

    public Players(List<String> names) {
        List<Player> players = createPlayers(names);
        validate(players);
        this.players = players;
    }

    private List<Player> createPlayers(List<String> names) {
        return names.stream()
                .map(Player::new)
                .toList();
    }

    private void validate(List<Player> players) {
        validateMinSize(players);
        validateDuplicate(players);
    }

    private void validateMinSize(List<Player> players) {
        if (players.size() < MIN_SIZE) {
            throw new IllegalArgumentException("참여자가 두 명 미만입니다.");
        }
    }

    private void validateDuplicate(List<Player> players) {
        long uniquePlayerCount = players.stream()
                .distinct()
                .count();

        if (uniquePlayerCount < players.size()) {
            throw new IllegalArgumentException("동일한 이름을 가진 참여자가 있습니다.");
        }
    }

    public Index findIndexOfPlayer(Player target) {
        return IntStream.range(0, players.size())
                .filter(index -> isEquals(index, target))
                .mapToObj(Index::new)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참여자가 아닙니다."));
    }

    private boolean isEquals(int index, Player target) {
        return players.get(index).equals(target);
    }

    public int getSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
