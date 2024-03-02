package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ColumnTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> new Column(0))
                .doesNotThrowAnyException();
    }

    @DisplayName("컬럼은 음수가 될 수 없다.")
    @Test
    void checkNegativeColumn() {
        assertThatThrownBy(() -> new Column(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("컬럼은 주어진 값보다 큰지 검사할 수 있다.")
    @Test
    void isGreaterThan() {
        Column column = new Column(1);

        boolean result = column.isGreaterThan(0);

        assertThat(result).isTrue();
    }

    @DisplayName("컬럼은 0인지 검사할 수 있다.")
    @Test
    void isLessThan() {
        Column column = new Column(0);

        boolean result = column.isZero();

        assertThat(result).isTrue();
    }

    @DisplayName("컬럼은 왼쪽 방향이 주어지면, 왼쪽 방향으로 움직인다.")
    @Test
    void changeLeft() {
        Column column = new Column(1);

        Column result = column.change(Direction.LEFT);

        assertThat(result.getValue()).isEqualTo(0);
    }

    @DisplayName("컬럼은 오른쪽 방향이 주어지면, 오른쪽 방향으로 움직인다.")
    @Test
    void changeRight() {
        Column column = new Column(0);

        Column result = column.change(Direction.RIGHT);

        assertThat(result.getValue()).isEqualTo(1);
    }

    @DisplayName("컬럼은 아무 방향도 주어지지 않으면 움직이지 않는다.")
    @Test
    void notChange() {
        Column column = new Column(0);

        Column result = column.change(Direction.STAY);

        assertThat(result.getValue()).isEqualTo(0);
    }
}
