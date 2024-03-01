package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.Line;
import domain.Point;
import domain.PointGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultMessageTest {
    @Test
    @DisplayName("각 라인의 출력 메시지를 반환한다.")
    void generateLineResult() {
        Line line = new Line(3, new FixedGenerator(true));
        List<Boolean> movableLinePoints = line.getMovableLinePoints();
        String expected = "-----|     |\n";
        String actual = ResultMessage.of(movableLinePoints);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("첫번째 이름 길이만큼 라인 앞 공백을 추가한다.")
    void addPaddingAsFirstNameLength() {
        List<String> rawNames = List.of("pobi", "honux");
        String paddedLine = ResultMessage.ladderPadding(rawNames);

        assertEquals("    |", paddedLine);
    }

    static class FixedGenerator implements PointGenerator {
        private final Boolean value;

        public FixedGenerator(Boolean value) {
            this.value = value;
        }

        @Override
        public Point generate() {
            if (value) {
                return Point.MOVABLE;
            }
            return Point.UNMOVABLE;
        }
    }
}
