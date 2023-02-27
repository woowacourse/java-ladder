package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Nested
    class CreatePositionTest {

        private static final int playerCount = 3;

        @ParameterizedTest
        @ValueSource(ints = {0, 2})
        @DisplayName("0 이상, 플레이어수 미만의 순서와, 플레이어수가 입력되면 Position이 정상적으로 생성된다.")
        void givenRangeInput_thenSuccess(int order) {

            //then
            assertThatCode(() -> Position.of(order, playerCount))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, -1000})
        @DisplayName("0 미만의 정수가 입력되면 Position이 예외가 발생된다.")
        void givenNegativeNumber_thenFail(int order) {


            //then
            assertThatThrownBy(() -> Position.of(order, playerCount))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage("0이상 3미만의 값만 입력해주세요.");
        }

        @ParameterizedTest
        @ValueSource(ints = {3, 100})
        @DisplayName("플레이어 수 이상의 정수가 입력되면 예외가 발생된다.")
        void givenMorePlayerCount_thenFail(int order) {


            //then
            assertThatThrownBy(() -> Position.of(order, playerCount))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage("0이상 3미만의 값만 입력해주세요.");
        }
    }
}
