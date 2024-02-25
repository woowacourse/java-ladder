package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Integer, Integer> mapper = new HashMap<>();

    public Result(final List<Integer> from, final List<Integer> to) {
        makeMapper(from, to);
    }

    private void makeMapper(final List<Integer> from, final List<Integer> to) {
        for (int i = 0; i < from.size(); i++) {
            mapper.put(from.get(i), to.get(i));
        }
    }

    public Integer getOne(final int from) {
        return mapper.get(from);
    }
}
