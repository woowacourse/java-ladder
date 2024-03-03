package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @DisplayName("왼쪽으로 이동한다.")
    @Test
    void moveBackward() {
        // given
        Index index = new Index(1);

        // when
        Index expected = Direction.BACKWARD.move(index);

        // then
        assertThat(expected.getValue()).isEqualTo(0);
    }

    @DisplayName("오른쪽으로 이동한다.")
    @Test
    void moveForward() {
        // given
        Index index = new Index(0);

        // when
        Index expected = Direction.FORWARD.move(index);

        // then
        assertThat(expected.getValue()).isEqualTo(1);
    }

    @DisplayName("그대로 이동한다.")
    @Test
    void moveStay() {
        // given
        Index index = new Index(1);

        // when
        Index expected = Direction.STAY.move(index);

        // then
        assertThat(expected.getValue()).isEqualTo(1);
    }

    @DisplayName("방향이 뒤쪽이다.")
    @Test
    void isBackward() {
        // when & then
        assertThat(Direction.BACKWARD.isBackward()).isTrue();
    }

    @DisplayName("방향이 앞쪽이다.")
    @Test
    void isForward() {
        // when & then
        assertThat(Direction.FORWARD.isForward()).isTrue();
    }

    @DisplayName("방향이 그대로이다.")
    @Test
    void isStay() {
        // when & then
        assertThat(Direction.STAY.isStay()).isTrue();
    }
}
