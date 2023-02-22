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
        @ParameterizedTest
        @ValueSource(ints = {0, 2})
        @DisplayName("0 이상 플레이어 수 미만의 정수가 입력되면 Position이 정상적으로 생성된다. ")
        void givenRangeInput_thenSuccess(int order) {

            int maxCount = 3;

            //then
            assertThatCode(() -> new Position(order, maxCount))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, -1000})
        @DisplayName("0 이상 플레이어 수 미만의 정수가 입력되면 Position이 정상적으로 생성된다. ")
        void givenNegativeNumber_thenFail(int order) {

            int maxCount = 3;

            //then
            assertThatThrownBy(() -> new Position(order, maxCount))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage("0이상 3미만의 값만 입력해주세요.");
        }

        @ParameterizedTest
        @ValueSource(ints = {4, 100})
        @DisplayName("0 이상 플레이어 수 미만의 정수가 입력되면 Position이 정상적으로 생성된다. ")
        void givenMorePlayerCount_thenFail(int order) {

            int maxCount = 3;

            //then
            assertThatThrownBy(() -> new Position(order, maxCount))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage("0이상 3미만의 값만 입력해주세요.");
        }
    }
}
