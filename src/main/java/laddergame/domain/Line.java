package laddergame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Line {

    private static final int MIN_EXISTENCE_COUNT = 1;
    private static final int FIRST_INDEX_OF_EXISTENCES = 0;
    private static final int ABSENCE_OF_TRUE = 1;

    private final List<Boolean> line;
    private final PickStrategy strategy;

    private Line(final int playerCount, final PickStrategy pickStrategy) {
        this.strategy = pickStrategy;
        int isExistenceCount = playerCount - 1;
        validateIsExistenceCount(isExistenceCount);
        this.line = createLine(isExistenceCount);
    }

    public static Line from(final int playerCount) {
        return new Line(playerCount, new RandomBooleanPicker());
    }

    public static Line of(final int playerCount, final PickStrategy pickStrategy) {
        return new Line(playerCount, pickStrategy);
    }

    public List<Boolean> getLine() {
        return new ArrayList<>(line);
    }

    private List<Boolean> createLine(final int isExistenceCount) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < isExistenceCount; i++) {
            line.add(checkExistence(line, i));
        }
        if (isAllFalse(isExistenceCount, line)) {
            return createLine(isExistenceCount);
        }
        return line;
    }

    private static boolean isAllFalse(final int isExistenceCount, final List<Boolean> line) {
        return new HashSet<>(line).size() == ABSENCE_OF_TRUE && isExistenceCount > MIN_EXISTENCE_COUNT;
    }

    private boolean checkExistence(final List<Boolean> line, final int index) {
        final boolean pick = strategy.pick();

        if (index == FIRST_INDEX_OF_EXISTENCES) {
            return pick;
        }

        if (isOverlap(line, pick)) {
            return false;
        }

        return pick;
    }

    private static boolean isOverlap(final List<Boolean> line, final boolean pick) {
        int lastIndex = line.size() - 1;
        return line.get(lastIndex) && pick;
    }

    private void validateIsExistenceCount(final int numberOfExistences) {
        if (numberOfExistences < MIN_EXISTENCE_COUNT) {
            throw new IllegalStateException(String.format("Line의 길이는 %d보다 작을 수 없습니다.", MIN_EXISTENCE_COUNT));
        }
    }
}
