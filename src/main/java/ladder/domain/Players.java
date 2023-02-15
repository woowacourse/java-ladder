package ladder.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Players {
    private final Map<StartPoint, Player> players;

    public Players(List<String> names) {
        validateDuplicateNames(names);
        players = new HashMap<>();

        IntStream.range(0, names.size())
                .forEach(index -> players.put(new StartPoint(index), new Player(names.get(index))));
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
