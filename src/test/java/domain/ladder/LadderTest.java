package domain.ladder;

import domain.ladder.common.Direction;
import domain.ladder.common.Height;
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

        assertThatCode(() -> new Ladder(
                          height, playerCount,
                          new FixedDirectionGenerator(fixedDirectionList)))
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
        assertEquals(directions, expected);
    }


}
