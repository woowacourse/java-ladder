package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    void 높이_유효성_테스트() {
        int countOfPlayers = 5;
        int height = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(height, countOfPlayers);
        });
    }

    @Test
    void 사람_수_테스트() {
        int countOfPlayers = 0;
        int height = 5;
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(height, countOfPlayers);
        });
    }

    @Test
    void 사다리_게임_진행() {
        List<Direction> line1 = Arrays.asList(
                new Direction(false, false),
                new Direction(false, true),
                new Direction(true, false));

        List<Direction> line2 = Arrays.asList(
                new Direction(false, true),
                new Direction(true, false),
                new Direction(false, false));

        List<Line> lines = Arrays.asList(new Line(line1.size(), () -> line1), new Line(line2.size(), () -> line2));

        Ladder ladder = new Ladder(3, 3, () -> lines);

        assertThat(ladder.moveLadder(0)).isEqualTo(1);
    }
}
