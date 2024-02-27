package domain.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.range;

public class PathMapper {
    private final Map<Integer, Integer> mapper;

    public PathMapper(final List<Integer> path) {
        this.mapper = range(0, path.size())
                .boxed()
                .collect(toMap(path::get, index -> index, (a, b) -> a, HashMap::new));
    }

    public int find(final int departure) {
        return this.mapper.get(departure);
    }
}
