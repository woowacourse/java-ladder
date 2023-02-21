package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("position끼리 서로의 값을 swap하는 메서드 테스트")
    void swapPositionTest() {
        final Position positionOne = Position.from(4);
        final Position positionTwo = Position.from(5);

        positionOne.swap(positionTwo);

        assertThat(positionOne).extracting("position")
                .isEqualTo(5);
        assertThat(positionTwo).extracting("position")
                .isEqualTo(4);
    }

    @Test
    @DisplayName("position은 내부 int position만 같으면 같은 값으로 취급한다.")
    void positionEqualCheckByField() {
        final Position positionOne = Position.from(4);
        final Position positionTwo = Position.from(4);
        assertThat(positionOne).isEqualTo(positionTwo);
    }
}
