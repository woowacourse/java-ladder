package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {
    @Test
    @DisplayName("높이 값 만큼 Line을 생성한다.")
    void createLines() {
        int height = 5;
        int personCount = 4;

        Lines lines = new Lines(height, personCount, new FixedPointGenerator());
        assertEquals(height, lines.getLines().size());
    }

    @Test
    @DisplayName("사다리의 전체 라인에서 이동 가능한 가로 라인의 위치만 저장한다.")
    void saveMovablePoint() {
        Lines lines = new Lines(2, 2, new FixedPointGenerator());
        List<Integer> movablePointIndexes = lines.getAllMovablePointIndexes();

        assertThat(movablePointIndexes).containsExactly(0, 0);
    }

    static class FixedPointGenerator implements PointGenerator {
        @Override
        public Point generate() {
            return Point.MOVABLE;
        }
    }
}
