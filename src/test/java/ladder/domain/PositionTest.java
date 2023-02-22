package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @Test
    @DisplayName("음수 값으로 위치를 생성하는 경우 예외를 던진다.")
    void position_throwException_negativeValue() {
        // expected
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 값을 갖는 위치는 동일한 위치이다.")
    void position_sameValuePositionIsSamePosition() {
        // given
        Position firstPosition = new Position(1);
        Position secondPosition = new Position(1);

        // expected
        assertThat(firstPosition.equals(secondPosition)).isTrue();
    }
}
