package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void nextPosition() {
        List<Position> positions = Arrays.asList(Position.create(0), Position.create(1), Position.create(2));
        List<Position> wants = Arrays.asList(Position.create(2), Position.create(0), Position.create(1));
        Ladder ladder = Ladder.from(Arrays.asList(
                HorizontalLine.from(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE)),
                HorizontalLine.from(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT))
        ));

        for (int i = 0; i < positions.size(); i++) {
            Position position = positions.get(i);
            Position want = wants.get(i);

            assertThat(ladder.nextPosition(position)).isEqualTo(want);
        }
    }

    @Test
    void toString_() {
        Ladder ladder = Ladder.from(Arrays.asList(
                HorizontalLine.from(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE)),
                HorizontalLine.from(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT))
        ));

        assertThat(ladder.toString()).isEqualTo(
                        "     |-----|     |\n" +
                        "     |     |-----|\n");
    }
}
