package model.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.position.Position.NOT_ALLOWED_NEGATIVE_POSITION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositionTest {

    private final Position initPosition = Position.valueOf(1);

    @DisplayName("포지션을 이동할 수 있다")
    @Test
    void move() {
        assertAll(
                () -> assertThat(initPosition.prior()).isEqualTo(Position.valueOf(0)),
                () -> assertThat(initPosition.next()).isEqualTo(Position.valueOf(2))
        );
    }

    @DisplayName("포지션이 같은지 확인할 수 있다.")
    @Test
    void same() {
        assertAll(
                () -> assertThat(initPosition.same(1)).isTrue(),
                () -> assertThat(initPosition.same(0)).isFalse()
        );
    }

    @DisplayName("포지션이 음수인 경우 예외가 발생한다.")
    @Test
    void validateNotNegative() {
        assertThatThrownBy(() -> Position.valueOf(-1))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(NOT_ALLOWED_NEGATIVE_POSITION);
    }

    @DisplayName("캐싱된 값을 가져올 경우 같은 객체를 반환한다.")
    @Test
    void cachedPosition() {
        assertAll(
                () -> assertThat(Position.valueOf(0) == Position.valueOf(0)).isTrue(),
                () -> assertThat(Position.valueOf(19) == Position.valueOf(19)).isTrue()
        );
    }


    @DisplayName("초기에 캐싱되지 않은 값이 들어올 경우 다른 객체를 반환한다.")
    @Test
    void nonCachedPosition() {
        assertThat(Position.valueOf(20) == Position.valueOf(20)).isFalse();
    }

}
