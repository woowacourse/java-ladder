package ladder.domain;

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

    public Position moveToResult(String playerName, Ladder ladder) {
        Player player = getByName(playerName);
        return player.moveThroughLadder(ladder);
    }

    private Player getByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .get();
    }

    public int getNameMaxLength() {
        return this.players.stream()
                .map(Player::getNameLength)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException("플레이어가 존재하지 않습니다."));
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

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
