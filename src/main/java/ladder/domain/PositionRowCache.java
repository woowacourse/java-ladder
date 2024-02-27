package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class PositionRowCache {
    private final Map<Key, PositionRow> cache;

    public static PositionRowCache of(int cacheLimit) {
        Map<Key, PositionRow> cache = new HashMap<>();
        for (int maxPosition = 0; maxPosition <= cacheLimit; maxPosition++) {
            putInCache(cache, maxPosition);
        }
        return new PositionRowCache(cache);
    }

    private static void putInCache(Map<Key, PositionRow> cache, int maxPosition) {
        for (int position = 0; position <= maxPosition; position++) {
            cache.put(new Key(position, maxPosition), new PositionRow(position, maxPosition));
        }
    }

    private PositionRowCache(Map<Key, PositionRow> cache) {
        this.cache = cache;
    }

    public PositionRow get(int position, int maxPosition) {
        Key key = new Key(position, maxPosition);
        if (!cache.containsKey(key)) {
            throw new IllegalArgumentException("캐싱되어 있지 않습니다");
        }
        return cache.get(key);
    }

    private record Key(int position, int maxPosition) {
    }
}
