package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void getNextLineTest() {
        Direction first = Direction.first(true);
        Direction next = first.next(false);
        Line line1 = new Line(Arrays.asList(first, next, next.last()));

        first = Direction.first(false);
        next = first.next(true);
        Line line2 = new Line(Arrays.asList(first, next, next.last()));

        Ladder ladder = new Ladder(Arrays.asList(line1, line2));
        assertThat(ladder.getNextLine()).isEqualTo(line1);
        assertThat(ladder.getNextLine()).isEqualTo(line2);
    }

    @Test
    void hasNextLineTest() {
        Direction first = Direction.first(true);
        Direction next = first.next(false);
        Line line1 = new Line(Arrays.asList(first, next, next.last()));
        Ladder ladder = new Ladder(Arrays.asList(line1));

        assertThat(ladder.hasNextLine()).isTrue();
        ladder.getNextLine();
        assertThat(ladder.hasNextLine()).isFalse();
    }
}
