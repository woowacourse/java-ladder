import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {
    Line line;
    @BeforeEach
    @Test
    void createLine() {
        line = new Line(4);
    }

    @DisplayName("랜덤 값의 의한 좌표값 생성")
    @Test
    void createPointOfRandomNumber() {
        int result = line.lineMaker(4).size();
        assertThat(result).isEqualTo(3);
    }
}