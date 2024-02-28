package model.position;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CachedPosition {
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 20;

    private static final Map<Integer, Position> positions = new HashMap<>();

    static {
        IntStream.range(MIN_POSITION, MAX_POSITION)
                .forEach(position -> positions.put(position, new Position(position)));
    }

    public static Position valueOf(int positionIndex) {
        if (positions.containsKey(positionIndex)) {
            return positions.get(positionIndex);
        }
        Position position = new Position(positionIndex);
        positions.put(positionIndex, position);
        return position;
    }
}
