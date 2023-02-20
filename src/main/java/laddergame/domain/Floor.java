package laddergame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Floor {

    private static final int MIN_EXISTENCE_COUNT = 1;
    private static final int FIRST_INDEX_OF_EXISTENCES = 0;
    private static final int ABSENCE_OF_TRUE = 1;

    private final List<Boolean> floor;
    private final PickStrategy strategy;

    private Floor(final int playerCount, final PickStrategy pickStrategy) {
        this.strategy = pickStrategy;
        int isExistenceCount = playerCount - 1;
        validateIsExistenceCount(isExistenceCount);
        this.floor = createFloor(isExistenceCount);
    }

    public static Floor from(final int playerCount) {
        return new Floor(playerCount, new RandomBooleanPicker());
    }

    public static Floor of(final int playerCount, final PickStrategy pickStrategy) {
        return new Floor(playerCount, pickStrategy);
    }

    public List<Boolean> getLine() {
        return new ArrayList<>(floor);
    }

    private List<Boolean> createFloor(final int isExistenceCount) {
        List<Boolean> floor = new ArrayList<>();
        for (int i = 0; i < isExistenceCount; i++) {
            floor.add(checkExistence(floor, i));
        }
        if (isAllFalse(isExistenceCount, floor)) {
            return createFloor(isExistenceCount);
        }
        return floor;
    }

    private static boolean isAllFalse(final int isExistenceCount, final List<Boolean> floor) {
        return new HashSet<>(floor).size() == ABSENCE_OF_TRUE && isExistenceCount > MIN_EXISTENCE_COUNT;
    }

    private boolean checkExistence(final List<Boolean> floor, final int index) {
        final boolean pick = strategy.pick();

        if (index == FIRST_INDEX_OF_EXISTENCES) {
            return pick;
        }

        if (isOverlap(floor, pick)) {
            return false;
        }

        return pick;
    }

    private static boolean isOverlap(final List<Boolean> floor, final boolean pick) {
        int lastIndex = floor.size() - 1;
        return floor.get(lastIndex) && pick;
    }

    private void validateIsExistenceCount(final int numberOfExistences) {
        if (numberOfExistences < MIN_EXISTENCE_COUNT) {
            throw new IllegalStateException(String.format("Floor의 길이는 %d보다 작을 수 없습니다.", MIN_EXISTENCE_COUNT));
        }
    }
}
