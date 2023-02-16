package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    public Players(List<String> names) {
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

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .map(Name::getName)
                .collect(Collectors.toList());
    }

    public int getNameMaxLength() {
        return this.players.stream()
                .map(player -> player.getName().getName().length())
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException("플레이어가 존재하지 않습니다."));
    }
}
