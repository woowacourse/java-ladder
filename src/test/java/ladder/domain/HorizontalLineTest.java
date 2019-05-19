package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLineTest {

    @Test
    void canDraw_그릴수있는위치() {
        HorizontalLine line = new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE));
        Position beginPosition = new Position(0, line.getNumPosition(), 0);

        assertThat(line.canDraw(beginPosition)).isTrue();
    }

    @Test
    void canDraw_이미_그려진_위치() {
        HorizontalLine line = new HorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE));
        Position beginPosition = new Position(0, line.getNumPosition(), 0);

        assertThat(line.canDraw(beginPosition.add(1))).isFalse();
    }

    @Test
    void canDraw_맨_오른쪽_위치() {
        HorizontalLine line = new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE));
        Position beginPosition = new Position(0, line.getNumPosition(), 0);

        assertThat(line.canDraw(beginPosition.Last())).isFalse();
    }

    @Test
    void canDraw_그려진_위치_옆위치() {
        List<HorizontalLine> lines = Arrays.asList(
                new HorizontalLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE, Direction.NONE)),
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.RIGHT, Direction.LEFT))
        );

        for (HorizontalLine line : lines) {
            Position beginPosition = new Position(0, line.getNumPosition(), 0);

            assertThat(line.canDraw(beginPosition.add(1))).isFalse();
        }
    }

    @Test
    void draw_가로선긋기() {
        HorizontalLine line = new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE));
        Position beginPosition = new Position(0, line.getNumPosition(), 0);

        line.draw(beginPosition.add(1));

        assertThat(line.drawn()).isEqualTo(new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE)));
    }

    @Test
    void drawn_초기화된_상태그대로() {
        HorizontalLine line = new HorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE));
        Position beginPosition = new Position(0, line.getNumPosition(), 0);

        assertThat(line.drawn()).isEqualTo(new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE)));
    }

    @Test
    void getNumPosition_잘_계산되었는지() {
        List<Direction> directions = Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE);
        HorizontalLine line = new HorizontalLine(directions);

        assertThat(line.getNumPosition()).isEqualTo(directions.size());
    }
}
