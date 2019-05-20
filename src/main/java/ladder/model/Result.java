package ladder.model;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Result implements Iterator {
    private final List<Player> result;
    private int index = 0;
    private String ALL_PLAYER = "all";

    Result(List<Player> players, Ladder ladder, List<String> query) {
        result = ladder
                .apply(players)
                .stream()
                .filter(x -> query.contains(ALL_PLAYER) || query.contains(x.getName()))
                .collect(Collectors.toList());
    }
    public boolean hasNext() {
        return index < result.size();
    }

    public Player next() {
        return result.get(index++);
    }
}