package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.BooleanGenerator;
import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultMessageTest {
    @Test
    @DisplayName("각 라인의 출력 메시지를 반환한다.")
    void generateLineResult() {
        Line line = new Line(3, new FixedGenerator(true));
        String expected = "-----|     |\n";
        String actual = ResultMessage.of(line);
        assertEquals(expected, actual);
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