package domain.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PathMapper {
    private final Map<Integer, Integer> mapper;

    /**
     * path = [1, 2, 0] 의 의미:
     * (입구 0번 -> 출구 1번),
     * (입구 1번 -> 출구 2번),
     * (입구 2번 -> 출구 0번),
     */
    public PathMapper(final List<Integer> path) {
        this.mapper = path.stream()
                .collect(
                        Collectors.toMap(
                                path::get,
                                Function.identity(),
                                (a, b) -> a,
                                HashMap::new
                        )
                );
    }

    public int findArrival(final int departure) {
        return this.mapper.get(departure);
    }
}
