package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class PositionRowCache {
    private final Map<Integer, PositionRow> cache;

    public static PositionRowCache of(int cacheLimit) {
        Map<Integer, PositionRow> cache = new HashMap<>();
        for (int position = 0; position <= cacheLimit; position++) {
            cache.put(position, new PositionRow(position));
        }
        return new PositionRowCache(cache);
    }

    private PositionRowCache(Map<Integer, PositionRow> cache) {
        this.cache = cache;
    }

    public PositionRow get(int position) {
        if (!cache.containsKey(position)) {
            throw new IllegalArgumentException("캐싱하지 않는 위치입니다");
        }
        return cache.get(position);
    }
}
