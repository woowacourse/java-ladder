package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("인원수 -1 개수 만큼의 포인트를 가진 Line 인스턴스를 생성한다.")
    @Test
    void createLine() {
        final Line line = new Line(4);

        assertThat(line.getPoints().size())
                .isEqualTo(4 - 1);
    }
}
