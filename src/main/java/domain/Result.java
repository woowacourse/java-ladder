package domain;

import java.util.*;

public class Result {
    private final Map<Integer, Integer> mapper = new LinkedHashMap<>();

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

    public List<Integer> getAll() {
        return new ArrayList<>(mapper.values());
    }
}
