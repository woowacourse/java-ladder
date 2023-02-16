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
        if(size != distinctNameSize) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    public String getPlayerName(StartPoint startPoint) {
        return players.get(startPoint).getName();
    }
}
