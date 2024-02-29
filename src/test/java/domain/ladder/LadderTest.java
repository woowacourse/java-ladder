package domain.ladder;

import domain.FixedDirectionGenerator;
import domain.Point;
import domain.ladder.attribute.Direction;
import domain.ladder.attribute.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatCode;

class LadderTest {

    @Test
    @DisplayName("Height와 Player 수를 받아 Ladder를 생성한다.")
    public void createLadder() {

        Height height = new Height("5");
        Integer playerCount = 5;
        List<Direction> fixedDirectionList = IntStream.rangeClosed(0, 20)
                                                      .mapToObj((value) -> Direction.RIGHT)
                                                      .toList();

        assertThatCode(() -> new Ladder(height, playerCount, new FixedDirectionGenerator(fixedDirectionList)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("특정 높이 가지들의 방향들을 가져온다.")
    public void getDirectionAtHorizontalIndex() {
        Height height = new Height("5");
        Integer playerCount = 5;
        List<Direction> fixedDirectionList = IntStream.rangeClosed(0, 20)
                                                      .mapToObj((value) -> Direction.RIGHT)
                                                      .toList();

        Ladder ladder = new Ladder(height, playerCount, new FixedDirectionGenerator(fixedDirectionList));

        List<Direction> directions = ladder.getDirectionAtHorizontalIndex(0);
        List<Direction> expected = List.of(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.DOWN);
        assertEquals(expected, directions);
    }

    @Test
    @DisplayName("특정 Point 의 방향을 가져온다")
    public void getDirectionWithPoint() {
        Point point1 = new Point(4, 3);
        Point point2 = new Point(1, 2);

        Ladder ladder = 오른쪽_왼쪽_오른쪽_왼쪽_아래_사다리_생성();

        Direction direction1 = ladder.getDirectionWithRowAndColumn(point1.row(), point1.column());
        Direction direction2 = ladder.getDirectionWithRowAndColumn(point2.row(), point2.column());
        assertEquals(direction1, Direction.DOWN);
        assertEquals(direction2, Direction.LEFT);
    }

    @Test
    @DisplayName("시작 포인트에서 사다리를 순회해서 끝 포인트까지 순회한다.")
    public void traverseLadderFromStartToEnd() {
        Point startPoint = new Point(0, 0);
        Ladder ladder = 오른쪽_왼쪽_오른쪽_왼쪽_아래_사다리_생성();

        Point endPoint = ladder.traverseLadderFromStartToEnd(startPoint);

        assertEquals(endPoint, new Point(1,5));
    }

    /**
     * R    L   R   L   D
     * R    L   R   L   D
     * R    L   R   L   D
     * R    L   R   L   D
     * R    L   R   L   D
     */
    private Ladder 오른쪽_왼쪽_오른쪽_왼쪽_아래_사다리_생성() {
        Height height = new Height("5");
        Integer playerCount = 5;
        List<Direction> fixedDirectionList = IntStream.rangeClosed(0, 20)
                                                      .mapToObj((value) -> Direction.RIGHT)
                                                      .toList();
        return new Ladder(height, playerCount, new FixedDirectionGenerator(fixedDirectionList));
    }
}
