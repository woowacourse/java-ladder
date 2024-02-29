package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Players {

    private static final int MIN_SIZE = 2;
    public static final String INVALID_PLAYER = "all";

    private final List<Index> players;

    public Players(List<String> names) {
        List<Index> players = IntStream.range(0, names.size())
                .mapToObj(i -> new Index(i, names.get(i)))
                .toList();

        validate(players);
        this.players = players;
    }

    private void validate(List<Index> players) {
        validateMinSize(players);
        validateDuplicate(players);
        validateContainsInvalidPlayer(players);
    }

    private void validateMinSize(List<Index> players) {
        if (players.size() < MIN_SIZE) {
            throw new IllegalArgumentException("참여자가 두 명 미만입니다.");
        }
    }

    private void validateDuplicate(List<Index> players) {
        long uniquePlayerCount = players.stream()
                .distinct()
                .count();

        if (uniquePlayerCount < players.size()) {
            throw new IllegalArgumentException("동일한 이름을 가진 참여자가 있습니다.");
        }
    }

    private void validateContainsInvalidPlayer(List<Index> players) {
        boolean containsInvalidPlayer = players.stream()
                .anyMatch(player -> player.getData().equals(INVALID_PLAYER));

        if (containsInvalidPlayer) {
            throw new IllegalArgumentException("유효하지 않은 참여자(all)가 있습니다.");
        }
    }

    public int getSize() {
        return players.size();
    }

    public List<Index> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
