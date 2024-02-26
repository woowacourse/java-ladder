package laddergame.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @DisplayName("음수를 포지션으로 가질 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-10, -5, -1})
    void validateRange(int value) {
        assertThatThrownBy(() -> new Position(value))
                .isInstanceOf(LadderGameException.class)
                .hasMessage("[ERROR] 음수를 포지션으로 가질 수 없습니다.");
    }


    @DisplayName("포지션이 increase로 증가한다.")
    @Test
    void increase() {
        // given
        Position position = new Position(0);

        // when
        Position increasePosition = position.increase();

        // then
        assertThat(increasePosition).isEqualTo(new Position(1));
    }

    @DisplayName("포지션이 decrease로 감소한다.")
    @Test
    void decrease() {
        // given
        Position position = new Position(1);

        // when
        Position decreasedPosition = position.decrease();

        // then
        assertThat(decreasedPosition).isEqualTo(new Position(0));
    }
}
