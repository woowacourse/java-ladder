package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LineTest {
    private Line line;

    @BeforeEach
    void setting() {
        line = new Line();
    }

    @Test
    @DisplayName("MAKE_LINE을 받으면 다리를 생성한다..")
    void makeTrue() {
        line.make(LineSource.MAKE_LINE);

        assertThat(line)
                .extracting("isExist")
                .isEqualTo(true);
    }

    @Test
    @DisplayName("Line.make에 MAKE_BLANK를 넣으면 아무 변화가 없다.")
    void makeLineBlankTest() {
        line.make(LineSource.MAKE_BLANK);
        assertThat(line)
                .extracting("isExist")
                .isEqualTo(false);
    }

    @Test
    @DisplayName("Line은 모든 LineSoure에 대한 처리를 하고있다.")
    void makeBlankTest() {
        final Line line = new Line();
        assertDoesNotThrow(() -> {
            for (final LineSource lineSource : LineSource.values()) {
                line.make(lineSource);
            }
        });
    }
}
