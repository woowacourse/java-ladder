package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("true일 때 FILLED를 반환한다.")
    void returnFilledTest() {
        assertThat(Point.of(true))
                .isEqualTo(Point.FILLED);
    }

    @Test
    @DisplayName("false일 때 EMPTY를 반환한다.")
    void returnEmptyTest() {
        assertThat(Point.of(false))
                .isEqualTo(Point.EMPTY);
    }
}
