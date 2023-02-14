package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("bar를 3개를 생성한다")
    void should3barWhenCreateLine() {
        // given
        // when
        Line line = new Line(3);
        // then
        assertThat(line.getBars()).hasSize(3);

    }

}
