package laddergame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import laddergame.domain.LadderResult;
import laddergame.domain.PersonalName;
import laddergame.domain.PersonalNames;
import laddergame.domain.ladder.Height;
import laddergame.domain.ladder.Width;
import laddergame.domain.ladder.line.BooleanGenerator;

public class TestDummy {
    public static final PersonalName PERSONAL_NAME_ROSIE = PersonalName.valueOf("rosie");
    public static final PersonalNames NAME_SIZE_2 = new PersonalNames(List.of("hyena", "rosie"));
    public static final Width WIDTH_VALUE_2 = new Width(2);
    public static final Height HEIGHT_VALUE_1 = new Height(1);
    public static final LadderResult LADDER_RESULT_SIZE_2 = LadderResult.of(NAME_SIZE_2,
            List.of("result1", "result2"));
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
