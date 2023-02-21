package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("position끼리 서로의 값을 swap하는 메서드 테스트")
    void swapPositionTest() {
        final Position positionOne = new Position(4);
        final Position positionTwo = new Position(5);

        positionOne.swapPosition(positionTwo);

        assertThat(positionOne).extracting("position")
                .isEqualTo(5);
        assertThat(positionTwo).extracting("position")
                .isEqualTo(4);
    }
}
