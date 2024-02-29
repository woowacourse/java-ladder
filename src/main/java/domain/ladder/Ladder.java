package domain.ladder;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Floor> ladder;

    public Ladder(List<Floor> ladder) {
        this.ladder = ladder;
    }

    public int moveFrom(final int startPosition) {
        int resultPosition = startPosition;
        for (final Floor floor : ladder) {
            resultPosition = floor.calculateResultPosition(resultPosition);
        }
        return resultPosition;
    }

    public List<Floor> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
