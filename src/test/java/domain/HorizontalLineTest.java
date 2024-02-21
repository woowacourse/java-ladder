package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HorizontalLineTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10})
    @DisplayName("올바른 범위의 수가 주어지면, 세로줄을 생성한다.")
    void validPlayerCountCreationTest(int playerCount) {
        assertDoesNotThrow(() -> new HorizontalLine(playerCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 11, 100})
    @DisplayName("올바르지 않은 범위의 수가 주어지면, 예외를 발생한다.")
    void invalidPlayerCountCreationTest(int playerCount) {
        assertThatThrownBy(() -> new HorizontalLine(playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 수 범위는 2 이상 10 이하여야 합니다.");
    }

    @Test
    @DisplayName("초기에 생성했을 때, 가로줄은 없다")
    void initialCreationEmptyCrossingLinesTest() {
        // given
        HorizontalLine horizontalLine = new HorizontalLine(5);
        // when
        HorizontalLineStatus status = horizontalLine.createStatus();
        List<Boolean> actual = status.placedStatuses();
        // then
        assertThat(actual).isEmpty();
    }
}
