package ladder.domain;

import static ladder.domain.LadderDirection.NONE;
import static ladder.domain.LadderDirection.RIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLevel {

    private final List<LadderDirection> ladderLevel;
    private LadderDirection latestLadderDirection;

    public LadderLevel(int size) {
        ladderLevel = new ArrayList<>();
        latestLadderDirection = NONE;
        IntStream.range(0, size).forEach((index) -> {
            addLadderDirection();
        });
        if (latestLadderDirection == RIGHT) {
            ladderLevel.set(size - 1, NONE);
        }
    }

    private void addLadderDirection() {
        latestLadderDirection = latestLadderDirection.next();
        ladderLevel.add(latestLadderDirection);
    }

    public Stream<LadderDirection> stream() {
        return ladderLevel.stream();
    }
}
