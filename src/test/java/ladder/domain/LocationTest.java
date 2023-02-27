package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LocationTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 5})
    @DisplayName("초기 위치를 입력 받아 Location을 생성한다")
    void shouldDoesNotThrowExceptionWhenCreate(int input) {
        assertDoesNotThrow(() -> new Location(input));
    }

    @Test
    @DisplayName("초기 위치가 음수이면 예외를 발생한다")
    void shouldThrowExceptionWhenCreateLocationWithNegative() {
        assertThatThrownBy(() -> new Location(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시작 위치는 0 이상이어야 합니다.");
    }

    @Test
    @DisplayName("열 위치를 반환한다.")
    void shouldReturnColumnIndexWhenRequest() {
        int columnIndex = 1;
        Location location = new Location(columnIndex);
        assertThat(location.getColumnIndex()).isEqualTo(columnIndex);
    }

    @ParameterizedTest
    @CsvSource(value = {"LEFT:1", "RIGHT:3", "CENTER:2"}, delimiter = ':')
    @DisplayName("방향을 입력 받아 열을 움직인다.")
    void shouldMoveColumnWhenInputDirection(Direction direction, int columnResultAfterMove) {
        Location location = new Location(2);
        location.moveColumnTo(direction);
        assertThat(location.getColumnIndex()).isEqualTo(columnResultAfterMove);
    }
}