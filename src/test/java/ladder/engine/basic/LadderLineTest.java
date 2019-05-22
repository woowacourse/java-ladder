package ladder.engine.basic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLineFactory.createLine(sizeOfPerson));
    }

    @Test
    public void move() {
        Point first = Point.first(true);
        List<Point> points = Arrays.asList(
                first, first.next(false), first.next(false).next(false));
        DefaultLadderLine line = new DefaultLadderLine(points);
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
