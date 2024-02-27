package domain.ladder;

import domain.ladder.attirbute.Direction;
import domain.ladder.attirbute.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("Height와 Player 수를 받아 Ladder를 생성한다.")
    void createLadder() {

        Height height = new Height("5");
        int playerCount = 5;
        List<Direction> fixedDirectionList = IntStream.rangeClosed(0, 20)
                                                      .mapToObj((value) -> Direction.RIGHT)
                                                      .toList();

        Ladder ladder = new Ladder(height, playerCount, new FixedDirectionGenerator(fixedDirectionList));

        assertInstanceOf(Ladder.class, ladder);
    }

    @Test
    @DisplayName("특정 높이 가지들의 방향들을 가져온다.")
    void getDirectionAtHorizontalIndex() {
        Height height = new Height("5");
        int playerCount = 5;
        List<Direction> fixedDirectionList = IntStream.rangeClosed(0, 20)
                                                      .mapToObj((value) -> Direction.RIGHT)
                                                      .toList();

        Ladder ladder = new Ladder(height, playerCount, new FixedDirectionGenerator(fixedDirectionList));

        List<Direction> directions = ladder.getDirectionAtHorizontalIndex(0);
        List<Direction> expected = List.of(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.DOWN);
        assertEquals(directions, expected);
    }

    @Test
    @DisplayName("사다리의 특정 지점의 인덱스가 주어지면 재귀적으로 함수를 호출하여 최종 지점의 인덱스를 반환한다")
    void moveFromStartingPointToResultPoint() {
        // Given
        Height height = new Height("3");
        int playerCount = 2;
        List<Direction> fixedDirectionList = List.of(Direction.RIGHT, Direction.RIGHT, Direction.RIGHT);
        Ladder ladder = new Ladder(height, playerCount, new FixedDirectionGenerator(fixedDirectionList));

        // When
        int result1 = ladder.moveCoordinateToResultPoint(0, 0);
        int result2 = ladder.moveCoordinateToResultPoint(1, 0);

        // Then
        assertAll(() -> {
            assertEquals(1, result1);
            assertEquals(0, result2);
        });
    }

}
