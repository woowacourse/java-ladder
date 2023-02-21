package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("true가 연속으로 두 개 나오면 예외를 발생시킨다.")
    void exceptionTest() {
        assertThatThrownBy(() -> new Line(List.of(true, true, false)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로라인이 연속될 수 없습니다.");
    }

    @Test
    @DisplayName("true가 연속으로 두 개 나오지 않아야 한다.")
    void succeedTest() {
        assertDoesNotThrow(() -> new Line(List.of(false, true, false)));
    }

    @DisplayName("해당 column이 true이면 좌우로 움직이는지 판단한다.")
    @Nested
    class LineMoveTest {
        Line line = new Line(List.of(true, false, true));

        @DisplayName("첫 번째 column에서 시작할 때, true를 만나면 오른쪽으로 움직인다.")
        @Test
        void column_first() {
            Position position = new Position(0, 1);
            line.move(position);
            assertThat(position).isEqualTo(new Position(1, 1));
        }

        @DisplayName("마지막 column에서 시작할 때, true를 만나면 왼쪽으로 움직인다.")
        @Test
        void column_last() {
            Position position = new Position(3, 1);
            line.move(position);
            assertThat(position).isEqualTo(new Position(2, 1));
        }

        @DisplayName("가운데 column에서 시작할 때, true를 만나는 쪽으로 움직인다.")
        @Test
        void column_middle_left() {
            Position position = new Position(1, 1);
            line.move(position);
            assertThat(position).isEqualTo(new Position(0, 1));
        }

        @DisplayName("가운데 column에서 시작할 때, true를 만나는 쪽으로 움직인다.")
        @Test
        void column_middle_right() {
            Position position = new Position(2, 1);
            line.move(position);
            assertThat(position).isEqualTo(new Position(3, 1));
        }
    }

}
