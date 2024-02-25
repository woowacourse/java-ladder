package ladder.domain;

import static ladder.domain.LadderDirection.LEFT;
import static ladder.domain.LadderDirection.NONE;
import static ladder.domain.LadderDirection.pickRightOrNone;

import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLevel {

    private final LinkedList<LadderDirection> ladderLevel;

    public LadderLevel(int size) {
        ladderLevel = new LinkedList<>();
        IntStream.range(0, size)
                .forEach((index) -> addLadderDirection());
        if (ladderLevel.removeLast() == LEFT) {
            ladderLevel.removeLast();
            ladderLevel.add(NONE);
        }
    }

    private void addLadderDirection() {
        if (ladderLevel.peekLast() == null) {
            ladderLevel.add(pickRightOrNone());
        }
        ladderLevel.add(ladderLevel.peekLast().next());
    }

    public Stream<LadderDirection> stream() {
        return ladderLevel.stream();
    }
}
