package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    @DisplayName("인원 수를 인자로 받아서 Line을 생성한다.")
    void createLine() {
        assertThatCode(() -> new Line(3));
    }
}