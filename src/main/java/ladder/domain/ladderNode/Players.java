package ladder.domain.ladderNode;

import ladder.domain.Ladder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private static final int MIN_PLAYER_COUNT = 2;
    private final List<Player> players;

    public Players(List<String> names) {
        validateTooLessPlayer(names);
        validateDuplicateNames(names);
        players = new ArrayList<>();

        IntStream.range(0, names.size())
                .forEach(i -> players.add(new Player(names.get(i), i)));
    }

    public Map<Position, String> moveToLadderEnd(Name playerName, Ladder ladder) {
        Map<Position, String> result = new HashMap<>();

        Player player = getPlayerByName(playerName);
        Position destination = player.moveThroughLadder(ladder);
        result.put(destination, player.getName());
        return Collections.unmodifiableMap(result);
    }

    public Map<Position, String> moveAllToLadderEnd(Ladder ladder) {
        Map<Position, String> results = new HashMap<>();

        for (Player player : players) {
            results.put(player.moveThroughLadder(ladder), player.getName());
        }
        return Collections.unmodifiableMap(results);
    }

    private Player getPlayerByName(Name name) {
        return players.stream()
                .filter(player -> player.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어 입니다."));
    }

    private void validateDuplicateNames(List<String> names) {
        int distinctNameSize = new HashSet<>(names).size();
        int size = names.size();
        if (size != distinctNameSize) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private void validateTooLessPlayer(List<String> names) {
        if (names.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("플레이어는 2명 이상이어야 합니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
