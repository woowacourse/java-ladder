package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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

    @Nested
    class MovePositionTest {

        @Test
        @DisplayName("위치가 순서의 양극단이 아닐때, 한 칸 앞으로 갈 수 있다.")
        void whenInRange_thenMoveForward() {

            //given
            int maxCount = 3;
            final Position position = new Position(1, maxCount);

            //when
            position.moveForward();

            //then
            assertThat(position.getOrder()).isEqualTo(0);

        }

        @Test
        @DisplayName("위치가 순서의 양극단이 아닐 때, 한 칸 뒤로 갈 수 있다.")
        void whenInRange_thenGoBack() {

            //given
            int maxCount = 3;
            final Position position = new Position(1, maxCount);

            //when
            position.goBack();

            //then
            assertThat(position.getOrder()).isEqualTo(2);
        }

        @Test
        @DisplayName("위치가 제일 앞일 때, 한 칸 앞으로 갈 수 없다.")
        void whenAtFirst_thenFail() {

            //given
            int maxCount = 3;
            final Position position = new Position(0, maxCount);

            //then
            assertThatThrownBy(() -> position.moveForward())
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage("제일 앞에선 더 앞으로 갈 수 없습니다.");
        }

        @Test
        @DisplayName("위치가 제일 뒤일 때, 한 칸 뒤로 갈 수 없다.")
        void whenAtLast_thenFail() {

            //given
            int maxCount = 3;
            final Position position = new Position(2, maxCount);

            //then
            assertThatThrownBy(() -> position.goBack())
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage("제일 뒤에선 더 뒤로 갈 수 없습니다.");
        }
    }
}
