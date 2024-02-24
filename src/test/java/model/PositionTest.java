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

    @Test
    @DisplayName("현재 위치보다 한칸 왼쪽의 위치를 반환한다.")
    void getLeftPosition() {
        Position position = new Position(1, 1);
        Position leftPosition = position.getLeftPosition();
        assertThat(leftPosition.depth()).isEqualTo(1);
        assertThat(leftPosition.column()).isEqualTo(0);
    }

    @Test
    @DisplayName("현재 위치보다 한칸 오른쪽의 위치를 반환한다.")
    void getRightPosition() {
        Position position = new Position(1, 1);
        Position rightPosition = position.getRightPosition();
        assertThat(rightPosition.depth()).isEqualTo(1);
        assertThat(rightPosition.column()).isEqualTo(2);
    }
}