package laddergame.fixture;

import laddergame.domain.BooleanGenerator;
import laddergame.domain.LineCreator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public abstract class LineCreatorFixture {
    public static final LineCreator TEST_LINE_CREATOR = new LineCreator(
            new BooleanGenerator() {
                Deque<Boolean> deque = new ArrayDeque<>(List.of(true, false));

                @Override
                public boolean generate() {
                    Boolean polled = deque.pollFirst();
                    deque.addLast(polled);
                    return polled;
                }
            }
    );
}
