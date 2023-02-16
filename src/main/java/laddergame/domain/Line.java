package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_STATUS = 1;
    private static final int FIRST_STATUS = 0;

    private final List<Boolean> statuses;
    private final PickStrategy strategy;

    private Line(final int numberOfPlayers, final PickStrategy pickStrategy) {
        this.strategy = pickStrategy;
        int numberOfStatus = numberOfPlayers - 1;
        validateNumberOfStatus(numberOfStatus);
        this.statuses = createStatuses(numberOfStatus);
    }

    public static Line from(final int numberOfPlayers) {
        return new Line(numberOfPlayers, new RandomBooleanPicker());
    }

    public static Line of(final int numberOfPlayers, final PickStrategy pickStrategy) {
        return new Line(numberOfPlayers, pickStrategy);
    }

    public List<Boolean> getStatuses() {
        return new ArrayList<>(statuses);
    }

    private List<Boolean> createStatuses(int numberOfStatus) {
        List<Boolean> statuses = new ArrayList<>();

        for (int i = 0; i < numberOfStatus; i++) {
            statuses.add(createLineStatus(statuses, i));
        }

        return statuses;
    }

    private boolean createLineStatus(final List<Boolean> statuses, final int index) {
        final boolean pick = strategy.pick();

        if (index == FIRST_STATUS) {
            return pick;
        }

        if (isOverlap(statuses, pick)) {
            return false;
        }

        return pick;
    }

    private static boolean isOverlap(final List<Boolean> statuses, final boolean pick) {
        int lastIndex = statuses.size() - 1;
        return statuses.get(lastIndex) && pick;
    }

    private void validateNumberOfStatus(final int numberOfStatus) {
        if (numberOfStatus < MIN_STATUS) {
            throw new IllegalStateException("Player는 2명보다 작을 수 없습니다.");
        }
    }
}
