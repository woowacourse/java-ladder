package laddergame.fixture;

import laddergame.domain.BooleanGenerator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public abstract class BooleanGeneratorFixture {
    public static final BooleanGenerator TEST_BOOLEAN_GENERATOR = new BooleanGenerator() {
        Deque<Boolean> deque = new ArrayDeque<>(List.of(true, false));
        @Override
        public boolean generate() {
            Boolean polled = deque.pollFirst();
            deque.addLast(polled);
            return polled;
        }
    };
}
