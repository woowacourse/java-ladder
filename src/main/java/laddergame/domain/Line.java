package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String MIN_WIDTH_MESSAGE = "너비는 1보다 작을 수 없습니다.";
    private static final int MIN_WIDTH = 1;

    private final List<Boolean> statuses;
    private final PickStrategy strategy;

    private Line(final int width, final PickStrategy pickStrategy) {
        this.strategy = pickStrategy;
        validateMinWidth(width);
        this.statuses = createStatuses(width);
    }

    public static Line from(final int width) {
        return new Line(width, new RandomBooleanPicker());
    }

    public static Line of(final int width, final PickStrategy pickStrategy) {
        return new Line(width, pickStrategy);
    }

    public List<Boolean> getStatuses() {
        return new ArrayList<>(statuses);
    }

    private List<Boolean> createStatuses(int width) {
        List<Boolean> statuses = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            statuses.add(createLineStatus(statuses, i));
        }

        return statuses;
    }

    private boolean createLineStatus(final List<Boolean> statuses, final int index) {
        final boolean pick = strategy.pick();

        if (index == 0) {
            return pick;
        }

        if (isOverlap(statuses, pick)) {
            return false;
        }

        return pick;
    }

    private static boolean isOverlap(final List<Boolean> statuses, final boolean pick) {
        return statuses.get(statuses.size() - 1) && pick;
    }

    private void validateMinWidth(final int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalStateException(MIN_WIDTH_MESSAGE);
        }
    }
}
