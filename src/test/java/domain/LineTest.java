package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("false로 초기화된 가로 라인을 생성한다.")
    @Test
    void createLine() {
        // given
        int size = 4;
        // when
        final Line line = new Line(size);
        // then
        Assertions.assertThat(line.getPoints()).containsAll(List.of(false, false, false, false));
    }

}