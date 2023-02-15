package util;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineStrategyTest {

    @Test
    @DisplayName("랜덤하게 Line의 생성이 정상적으로 되어야 한다.")
    void create_randomSuccess() {
        // given
        LineStrategy lineStrategy = new RandomLineStrategy();

        // when
        Line line = lineStrategy.generate(5);

        // then
        assertThat(line.getSize())
                .isEqualTo(4);
    }
}
