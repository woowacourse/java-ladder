package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.booleangenerator.BooleanGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("현재 생성된 Point의 갯수를 리턴하는 기능")
    @Test
    public void getPointCount() {
        assertThat(new Line(5, new FixedBooleanGenerator(true)).getPointCount())
                .isEqualTo(0);
    }

    @DisplayName("랜덤값이 전부 true일 경우 RIGHT, LEFT Point를 가지는 Line을 생성한다.")
    @Test
    public void createLineTrueCase() {
        Line line = new Line(2, new FixedBooleanGenerator(true));
        assertThat(line.getPoints()).isEqualTo(
                List.of(new Point(Direction.RIGHT), new Point(Direction.LEFT)));
    }

    static class FixedBooleanGenerator implements BooleanGenerator {

        private final boolean value;

        public FixedBooleanGenerator(boolean value) {
            this.value = value;
        }

        @Override
        public boolean generate() {
            return value;
        }
    }
}
