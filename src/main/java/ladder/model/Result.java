package ladder.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Result implements Iterator {
    private final List<Player> result;
    private int index = 0;

    Result(List<Player> players, Ladder ladder, List<String> query) {
        result = Collections.unmodifiableList(ladder.apply(players).stream()
            .filter(x -> query.contains("all") || query.contains(x.getName()))
            .collect(Collectors.toList()));
    }
    public boolean hasNext() {
        return index < result.size();
    }

    public Player next() {
        return result.get(index++);
    }
}