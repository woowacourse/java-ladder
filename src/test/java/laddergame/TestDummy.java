package laddergame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import laddergame.domain.BooleanGenerator;
import laddergame.domain.Height;
import laddergame.domain.Name;
import laddergame.domain.Participants;
import laddergame.domain.Width;

public class TestDummy {
    public static final Name NAME_HYENA = new Name("hyena");
    public static final Name NAME_ROSIE = new Name("rosie");
    public static final Participants PARTICIPANTS_SIZE_2 = new Participants(List.of(NAME_ROSIE, NAME_HYENA));
    public static final Width WIDTH_VALUE_2 = new Width(2);
    public static final Height HEIGHT_VALUE_1 = new Height(1);
    public static final BooleanGenerator TEST_BOOLEAN_GENERATOR = new BooleanGenerator() {
        final Deque<Boolean> deque = new ArrayDeque<>(List.of(true, false));

        @Override
        public boolean generate() {
            Boolean polled = deque.pollFirst();
            deque.addLast(polled);
            return polled;
        }
    };
}
