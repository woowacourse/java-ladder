package test;

import ladder.domain.PositionRow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionRowTest {
    @Test
    @DisplayName("시작 위치와 위치 최대 값을 가진 PositionRow 객체를 생성할 수 있다")
    void makePositionRow() {
        int start = 0;
        int maxPosition = 5;
        PositionRow positionRow = new PositionRow(start, maxPosition);
    }

    @Test
    @DisplayName("음수 인수를 받는 PositionRow 객체를 생성할 수 없다")
    void cantMakePositionRow() {
        int plusVariable = 3;
        int minusVariable = -1;
        assertThatThrownBy(() -> new PositionRow(plusVariable, minusVariable))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PositionRow(minusVariable, plusVariable))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("PositionRow는 좌우로 움직일 수 있다")
    void movePositionRow() {
        PositionRow positionRow = new PositionRow(0, 5);

        assertThatCode(() -> {
            positionRow.moveRight();
            positionRow.moveLeft();
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("PositionRow의 위치는 음수일 수 없다")
    void PositionRow() {
        PositionRow positionRow = new PositionRow(0, 0);
        assertThatThrownBy(positionRow::moveLeft)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("PositionRow의 위치는 maxPosition을 초과할 수 없다")
    void cantMovePositionRow() {
        PositionRow positionRow = new PositionRow(0, 0);
        assertThatThrownBy(positionRow::moveRight)
                .isInstanceOf(IllegalStateException.class);
    }
}
