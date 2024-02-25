package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @DisplayName("0, 또는 자연수의 위치를 가지는 Position 객체를 생성할 수 있다.")
    @ParameterizedTest(name = "{0} 위치를 가지는 Position 객체를 생성할 수 있다.")
    @ValueSource(ints = {0, 1})
    void constructSuccessTest(int positionValue) {
        assertThatNoException()
                .isThrownBy(() -> new Position(positionValue));
    }

    @DisplayName("음수 위치를 가지는 Position 객체를 생성하면 예외가 발생한다.")
    @Test
    void constructFailWIthNegativePosition() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 위치를 가지는 Position 동등성 비교")
    @Test
    void positionEqualsWithSamePosition() {
        assertThat(new Position(1))
                .isEqualTo(new Position(1));
    }
}
