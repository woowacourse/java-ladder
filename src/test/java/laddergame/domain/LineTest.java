package laddergame.domain;

import laddergame.util.PointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    static class FalseGenerator implements PointGenerator {
        @Override
        public boolean generate() {
            return false;
        }
    }

    static class TrueGenerator implements PointGenerator {
        @Override
        public boolean generate() {
            return true;
        }
    }

    @Test
    @DisplayName("Line이 정상적으로 생성된다.")
    void lineCreateTest() {
        int playerCount = 4;
        assertDoesNotThrow(() -> new Line(playerCount, new FalseGenerator()));
    }

    @Test
    @DisplayName("이웃한 라인끼리는 겹치지 않는다.")
    void overlapNeighborLineTest() {
        int playerCount = 4;
        Line line = new Line(playerCount, new TrueGenerator());
        assertThat(line.getLine()).containsExactly(Point.CONNECT, Point.DISCONNECT, Point.CONNECT);
    }

    @Nested
    @DisplayName("player의 현재 위치와 연결 여부에 따라 오른쪽/왼쪽으로 이동한다.")
    class MoveTest {

        int playerCount = 4;
        Line line = new Line(playerCount, new TrueGenerator());

        @ParameterizedTest(name = "player{index}가 이동한다.")
        @CsvSource(delimiter = ':', value = {"0:1", "1:0", "2:3", "3:2"})
        public void moveTest(int currentPosition, int expectedPosition) {
            int resultPosition = line.move(currentPosition);
            assertThat(resultPosition).isEqualTo(expectedPosition);
        }
    }
}
