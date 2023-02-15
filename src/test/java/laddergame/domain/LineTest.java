package laddergame.domain;

import laddergame.util.PointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    class FalseGenerator implements PointGenerator {
        @Override
        public boolean generate() {
            return false;
        }
    }

    class TrueGenerator implements PointGenerator {
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
}