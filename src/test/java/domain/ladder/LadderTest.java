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
    @DisplayName("특정 index의 LadderLeg에 있는 특정 index의 LadderLegPiece에서의 진행 방향을 결정한다.")
    void determineMovingDirectionAtLadderLegPiece() {
        Height height = new Height("1");
        int playerCount = 2;
        List<Direction> fixedDirectionList = List.of(Direction.RIGHT);

        Ladder ladder = new Ladder(height, playerCount, new FixedDirectionGenerator(fixedDirectionList));
        Direction direction1 = ladder.getDirectionOfLadderLegPieceAtSpecificCoordinate(1, 0);
        Direction direction2 = ladder.getDirectionOfLadderLegPieceAtSpecificCoordinate(0, 0);

        assertAll(() -> {
            assertEquals(Direction.LEFT, direction1);
            assertEquals(Direction.RIGHT, direction2);
        });

    }
}
