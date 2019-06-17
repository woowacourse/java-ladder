package ladder.model.impl;

import ladder.model.Ladder;
import ladder.model.Line;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void move() {
        Line first = new DefaultLine(
                Arrays.asList(right(0), left(1), straight(2)));
        Line second = new DefaultLine(
                Arrays.asList(straight(0), right(1), left(2)));
        Line third = new DefaultLine(
                Arrays.asList(right(0), left(1), straight(2)));
        Ladder ladder = new DefaultLadder(3, Arrays.asList(first, second, third));
        assertThat(ladder.play().getTarget(0)).isEqualTo(2);
        assertThat(ladder.play().getTarget(1)).isEqualTo(1);
        assertThat(ladder.play().getTarget(2)).isEqualTo(0);
    }

    private Point right(int position) {
        return new Point(position, Direction.of(FALSE, TRUE));
    }

    private Point left(int position) {
        return new Point(position, Direction.of(TRUE, FALSE));
    }

    private Point straight(int position) {
        return new Point(position, Direction.of(FALSE, FALSE));
    }
}
