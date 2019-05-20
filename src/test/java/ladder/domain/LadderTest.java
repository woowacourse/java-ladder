package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void canDraw_그릴수있는위치() {
        List<HorizontalLine> lines = Arrays.asList(
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE)),
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE))
        );
        Position beginRowPosition = new Position(0, lines.size(), 0);
        Position beginColumnPosition = new Position(0, lines.get(0).getNumPosition(), 0);
        Ladder ladder = new Ladder(lines);

        HorizontalLine line = new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE));


        assertThat(ladder.canDraw(beginRowPosition.plus(1), beginColumnPosition.plus(1))).isTrue();
    }

    @Test
    void canDraw_이미_그려진_위치() {
        List<HorizontalLine> lines = Arrays.asList(
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE)),
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE))
        );
        Position beginRowPosition = new Position(0, lines.size(), 0);
        Position beginColumnPosition = new Position(0, lines.get(0).getNumPosition(), 0);
        Ladder ladder = new Ladder(lines);

        HorizontalLine line = new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE));


        assertThat(ladder.canDraw(beginRowPosition.plus(1), beginColumnPosition.plus(1))).isFalse();
    }

    @Test
    void canDraw_맨_오른쪽_위치() {
        List<HorizontalLine> lines = Arrays.asList(
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE)),
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE))
        );
        Position beginRowPosition = new Position(0, lines.size(), 0);
        Position beginColumnPosition = new Position(0, lines.get(0).getNumPosition(), 0);
        Ladder ladder = new Ladder(lines);

        HorizontalLine line = new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE));


        assertThat(ladder.canDraw(beginRowPosition.plus(1), beginColumnPosition.last())).isFalse();
    }

    @Test
    void canDraw_그려진_위치_옆위치() {
        List<List<HorizontalLine>> inputs = Arrays.asList(
                Arrays.asList(
                        new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE)),
                        new HorizontalLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE, Direction.NONE))
                ),
                Arrays.asList(
                        new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE)),
                        new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.RIGHT, Direction.LEFT))
                )
        );

        HorizontalLine line = new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE));


        for (List<HorizontalLine> lines : inputs) {
            Position beginRowPosition = new Position(0, lines.size(), 0);
            Position beginColumnPosition = new Position(0, lines.get(0).getNumPosition(), 0);
            Ladder ladder = new Ladder(lines);

            assertThat(ladder.canDraw(beginRowPosition.plus(1), beginColumnPosition.plus(1))).isFalse();
        }
    }

    @Test
    void draw_가로선긋기() {
        List<HorizontalLine> lines = Arrays.asList(
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE)),
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE))
        );
        Position beginRowPosition = new Position(0, lines.size(), 0);
        Position beginColumnPosition = new Position(0, lines.get(0).getNumPosition(), 0);
        Ladder ladder = new Ladder(lines);

        ladder.draw(beginRowPosition.plus(1), beginColumnPosition.plus(1));

        assertThat(ladder.drawn()).isEqualTo(new DrawnLadder(Arrays.asList(
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE)),
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE))
        )));
    }

    @Test
    void drawn_초기화된_상태그대로() {
        List<HorizontalLine> lines = Arrays.asList(
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE)),
                new HorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE))
        );
        Ladder ladder = new Ladder(lines);

        assertThat(ladder.drawn()).isEqualTo(new DrawnLadder(Arrays.asList(
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.NONE)),
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE))
        )));
    }

    @Test
    void getNumPosition_잘_계산되었는지() {

    }
}