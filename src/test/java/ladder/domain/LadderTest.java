package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @BeforeEach
    void setup() {
        Players.NUM_OF_PLAYERS = 3;
    }

    @Test
    void getNextLineTest() {
        Point first = Point.first(true);
        Point next = first.next(false);
        Line line1 = new Line(Arrays.asList(first, next, next.last()));

        first = Point.first(false);
        next = first.next(true);
        Line line2 = new Line(Arrays.asList(first, next, next.last()));

        Ladder ladder = new Ladder(Arrays.asList(line1, line2), 2);
        assertThat(ladder.getNextLine()).isEqualTo(line1);
        assertThat(ladder.getNextLine()).isEqualTo(line2);
    }

    @Test
    void hasNextLineTest() {
        Point first = Point.first(true);
        Point next = first.next(false);
        Line line1 = new Line(Arrays.asList(first, next, next.last()));
        Ladder ladder = new Ladder(Arrays.asList(line1), 1);

        assertThat(ladder.hasNextLine()).isTrue();
        ladder.getNextLine();
        assertThat(ladder.hasNextLine()).isFalse();
    }
}
