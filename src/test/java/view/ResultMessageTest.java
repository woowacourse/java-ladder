package view;

import domain.BooleanGenerator;
import domain.Names;
import domain.line.Line;
import domain.lines.CountToPoints;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultMessageTest {
    @Test
    @DisplayName("각 라인의 출력 메시지를 반환한다.")
    void generateLineResult() {
        int personCount = 3;
        FixedGenerator generator = new FixedGenerator(true);
        CountToPoints countToPoints = new CountToPoints(personCount, generator);
        Line line = new Line(countToPoints.value());

        String expected = "-----|     |\n";
        String actual = ResultMessage.of(line);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("첫번째 이름 길이만큼 라인 앞 공백을 추가한다.")
    void addPaddingAsFirstNameLength() {
        List<String> rawNames = List.of("pobi", "honux");
        Names names = new Names(rawNames);
        String paddedLine = ResultMessage.ladderPadding(names);

        assertEquals("    |", paddedLine);
    }

    static class FixedGenerator implements BooleanGenerator {
        private final Boolean value;

        public FixedGenerator(Boolean value) {
            this.value = value;
        }

        @Override
        public Boolean generate() {
            return value;
        }

    }
}
