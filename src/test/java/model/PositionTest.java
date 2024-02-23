package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    @DisplayName("위치는 depth와 column을 갖는다.")
    @Test
    void createPoint() {
        int depth = 0;
        int column = 0;
        Position position = new Position(depth, column);
        assertThat(position.depth()).isEqualTo(depth);
        assertThat(position.column()).isEqualTo(column);
    }

    @ParameterizedTest(name = "위치의 depth와 column은 음수일 수 없다.")
    @CsvSource({"0, -1", "-1, 0", "-1, -1"})
    void createPointThrowExceptionWhenNegativeNumber(int depth, int column) {
        assertThatThrownBy(() -> new Position(depth, column))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 음수일 수 없습니다.");
    }
}