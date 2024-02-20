package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("지정된 수 만큼의 길이를 갖는 한 행이 생성된다.")
    void createLineTest() {
        Line line = Line.of(5);

        int actual = line.size();
        int expected = 5;

        assertThat(actual).isEqualTo(expected);
    }
}
