package domain.ladder;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Floor> floors;

    public Ladder(List<Floor> floors) {
        this.floors = floors;
    }

    public int calculateResultPosition(final int startPosition) {
        int resultPosition = startPosition;
        for (final Floor floor : floors) {
            resultPosition = floor.calculateResultPosition(resultPosition);
        }
        return resultPosition;
    }

    public List<Floor> getFloors() {
        return Collections.unmodifiableList(floors);
    }
}
