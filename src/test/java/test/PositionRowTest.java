package test;

import ladder.domain.PositionRow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionRowTest {
    @Test
    @DisplayName("위치 값을 가진 PositionRow 객체를 생성할 수 있다")
    void makePositionRow() {
        int position = 0;
        PositionRow positionRow = new PositionRow(position);
    }

    @Test
    @DisplayName("음수 인수를 받는 PositionRow 객체를 생성할 수 없다")
    void cantMakePositionRow() {
        int minusVariable = -1;
        assertThatThrownBy(() -> new PositionRow(minusVariable))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("PositionRow는 좌우에 있는 PositionRow를 가져올 수 있다")
    void movePositionRow() {
        PositionRow positionRow = new PositionRow(1);

        assertThatCode(() -> {
            PositionRow right = positionRow.right();
            PositionRow left = positionRow.left();
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("PositionRow의 위치는 음수일 수 없다")
    void PositionRow() {
        PositionRow positionRow = new PositionRow(0);
        assertThatThrownBy(positionRow::left)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
