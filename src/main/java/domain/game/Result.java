package domain.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.IntStream.range;

public class Result {
    private final Map<Integer, Integer> mapper = new HashMap<>();

    public Result(final List<Integer> to) {
        makeMapper(to);
    }

    private void makeMapper(final List<Integer> to) {
        range(0, to.size()).forEach(index ->
                mapper.put(to.get(index), index)
        );
    }

    public Integer getOne(final int from) {
        return mapper.get(from);
    }
}
