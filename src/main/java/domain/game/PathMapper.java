package domain.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.range;

public class PathMapper {
    private final Map<Integer, Integer> mapper;

    public PathMapper(final List<Integer> to) {
        this.mapper = range(0, to.size())
                .boxed()
                .collect(toMap(to::get, index -> index, (a, b) -> a, HashMap::new));
    }

    public int find(final int from) {
        return this.mapper.get(from);
    }
}
