package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import ladder.domain.ladder.generator.RungGenerator;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 30;

    private final List<Floor> floors;

    private Ladder(List<Floor> floors) {
        this.floors = floors;
    }

    public static Ladder of(int height, int playerCount, RungGenerator rungGenerator) {
        validateHeightRange(height);

        List<Floor> floors = Stream.generate(() -> new Floor(playerCount, rungGenerator))
                .limit(height)
                .toList();

        return new Ladder(floors);
    }

    private static void validateHeightRange(int height) {
        if (MINIMUM_HEIGHT > height || height > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format("사다리의 높이는 %d이상 %d이하여야 합니다.", MINIMUM_HEIGHT, MAXIMUM_HEIGHT));
        }
    }

    public int findEndIndex(int index) {
        int currentIndex = index;

        for (Floor floor : floors) {
            currentIndex = floor.findConnectedIndex(currentIndex);
        }

        return currentIndex;
    }

    public int getColumnSize() {
        return floors.get(0).getRungs().size();
    }

    public List<Floor> getFloors() {
        return Collections.unmodifiableList(floors);
    }
}
