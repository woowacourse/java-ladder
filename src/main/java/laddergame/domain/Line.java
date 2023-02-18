package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_NUMBER_OF_EXISTENCES = 1;
    private static final int FIRST_INDEX_OF_EXISTENCES = 0;

    private final List<Boolean> line;
    private final PickStrategy strategy;

    private Line(final int numberOfPlayers, final PickStrategy pickStrategy) {
        this.strategy = pickStrategy;
        int numberOfExistences = numberOfPlayers - 1;
        validateNumberOfExistences(numberOfExistences);
        this.line = createLine(numberOfExistences);
    }

    public static Line from(final int numberOfPlayers) {
        return new Line(numberOfPlayers, new RandomBooleanPicker());
    }

    public static Line of(final int numberOfPlayers, final PickStrategy pickStrategy) {
        return new Line(numberOfPlayers, pickStrategy);
    }

    public List<Boolean> getLine() {
        return new ArrayList<>(line);
    }

    private List<Boolean> createLine(final int numberOfStatus) {
        List<Boolean> line = new ArrayList<>();

        for (int i = 0; i < numberOfStatus; i++) {
            line.add(checkExistence(line, i));
        }

        return line;
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

    private void validateNumberOfExistences(final int numberOfExistences) {
        if (numberOfExistences < MIN_NUMBER_OF_EXISTENCES) {
            throw new IllegalStateException(String.format("Line의 길이는 %d보다 작을 수 없습니다.", MIN_NUMBER_OF_EXISTENCES));
        }
    }
}
