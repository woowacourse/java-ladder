package ladder.domain.laddergame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {


    @Test
    @DisplayName("0보다 작은 숫자의 위치를 생성하려고 하면 에러가 발생한다")
    void validateValueOfPositionTest() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다 작은 숫자로 이동할 수 없습니다");
    }

    @Test
    @DisplayName("increase하면 현재 위치보다 +1한 Position이 반환된다.")
    void increase() {
        Position currentPosition = new Position(1);

        assertThat(currentPosition.increase())
                .isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("decrease하면 현재 위치보다 -1한 Position이 반환된다.")
    void decrease() {
        Position currentPosition = new Position(1);

        assertThat(currentPosition.decrease())
                .isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("현재 위치보다 0일때, decrease하면 에러가 발생한다.")
    void decreaseAfterZeroPosition() {
        Position currentPosition = new Position(0);

        assertThatThrownBy(currentPosition::decrease)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다 작은 숫자로 이동할 수 없습니다");
    }

}
