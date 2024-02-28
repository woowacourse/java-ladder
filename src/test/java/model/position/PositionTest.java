package model.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    private Position initPosition = new Position(1);

    @DisplayName("포지션을 이동할 수 있다")
    @Test
    void move(){
        assertAll(
                () -> assertThat(initPosition.prior()).isEqualTo(new Position(0)),
                () -> assertThat(initPosition.next()).isEqualTo(new Position(2))
        );
    }

    @DisplayName("포지션이 같은지 확인할 수 있다.")
    @Test
    void same(){
        assertAll(
                () -> assertThat(initPosition.same(1)).isTrue(),
                () -> assertThat(initPosition.same(0)).isFalse()
        );
    }

    @DisplayName("포지션이 음수인 경우 예외가 발생한다.")
    @Test
    void validateNotNegative(){
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("포지션(위치)은 음수가 될 수 없습니다.");
    }

}
