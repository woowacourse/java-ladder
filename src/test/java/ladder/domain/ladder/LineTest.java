package ladder.domain.ladder;

import ladder.domain.MockRandomBooleanGenerator;
import ladder.domain.ladderGame.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private final int widthOfLine = 5;
    private Line line;

    /**
     * true,false,true,false
     */
    @BeforeEach
    void setup() {
        line = new Line(widthOfLine, new MockRandomBooleanGenerator());
    }

    @Test
    @DisplayName("widthOfLadder 크기의 라인이 생성되는지 확인한다.")
    void generateLineSizeTest() {
        assertThat(line.getLine().size()).isEqualTo(widthOfLine);
    }

    /**
     * true,false,true,false
     */

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4"})
    @DisplayName("제공된 출발위치가 Line을 통과한 후, 예상한대로 이동하는지 확인한다")
    void findNextPositionTest(int startIndex, int movedIndex) {
        Position startPosition = new Position(startIndex);
        Position movedPosition = new Position(movedIndex);

        assertThat(line.findNextPosition(startPosition))
                .isEqualTo(movedPosition);
    }

    @Test
    @DisplayName("Line이 예상한대로 생성되었는지 확인한다")
    void getLine() {
        List<Direction> directions = List.of(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.STAY);

        assertThat(line.getLine())
                .isEqualTo(directions);
    }


//    @Test
//    @DisplayName("생성된 Line의 가로가 겹치지 않는지 확인한다.")
//    void generateLineTest() {
//
//        List<Direction> directions = line.getLine();
//
//        for (int i = 0; i < widthOfLine - 1; i++) {
//            Direction currentDirection = directions.get(i);
//            Direction nextDirection = directions.get(i + 1);
//
//            if((currentDirection == Direction.LEFT || currentDirection == Direction.STAY)
//                    && nextDirection == Direction.LEFT) {
//                throw new IllegalArgumentException();
//            }
//            if(currentDirection == Direction.RIGHT
//                    && (nextDirection == Direction.RIGHT || nextDirection == Direction.STAY)) {
//                throw new IllegalArgumentException();
//
//            }
//        }
//    }

}
