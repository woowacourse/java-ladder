package laddergame.domain;

import laddergame.util.PointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    class FalseGenerator implements PointGenerator {
        @Override
        public boolean generate() {
            return false;
        }
    }

    @Test
    @DisplayName("Line이 정상적으로 생성된다.")
    void lineCreateTest() {
        int playerCount = 4;
        assertDoesNotThrow(() -> new Line(playerCount, new FalseGenerator()));
    }

}