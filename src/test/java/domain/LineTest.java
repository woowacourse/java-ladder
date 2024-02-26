package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("생성 테스트")
    @Test
    void createLine() {
        assertThatCode(() -> new Line(filledStickGenerator(), 3))
                .doesNotThrowAnyException();
    }

    @DisplayName("라인은 인원 수 -1 만큼의 막대를 갖는다.")
    @Test
    void lineHasStick() {
        int playerSize = 3;
        Line line = new Line(filledStickGenerator(), playerSize);

        List<Stick> sticks = line.getSticks();

        assertThat(sticks).hasSize(playerSize - 1);
    }

    @DisplayName("라인에 연속된 막대는 있을 수 없다.")
    @Test
    void opposite() {
        int playerSize = 3;
        Line line = new Line(filledStickGenerator(), playerSize);

        List<Stick> sticks = line.getSticks();

        assertThat(sticks.get(playerSize - 2)).isEqualTo(Stick.NOT_FILLED);
    }

    @DisplayName("주어진 컬럼 왼쪽에 이동 가능한 막대가 있는지 체크할 수 있다.")
    @Test
    void moveLeft() {
        // 0 1 2 3
        // |-| |-|
        Line line = new Line(List.of(
                Stick.FILLED,
                Stick.NOT_FILLED,
                Stick.FILLED
        ));

        Direction result = line.move(3);

        assertThat(result).isEqualTo(Direction.LEFT);
    }

    @DisplayName("주어진 컬럼 오른쪽에 이동 가능한 막대가 있는지 체크할 수 있다.")
    @Test
    void moveRight() {
        Line line = new Line(List.of(
                Stick.FILLED,
                Stick.NOT_FILLED,
                Stick.FILLED
        ));

        Direction result = line.move(0);

        assertThat(result).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("주어진 줄에서 왼쪽과 오른쪽에 막대가 없으면 이동 불가능하다.")
    @Test
    void stay() {
        Line line = new Line(List.of(
                Stick.NOT_FILLED,
                Stick.NOT_FILLED
        ));

        Direction result = line.move(0);

        assertThat(result).isEqualTo(Direction.STAY);
    }

    @DisplayName("0이상 부터 막대의 총 갯수 사이의 컬럼을 이용해서만 이동 여부를 판단할 수 있다.")
    @Test
    void checkColumnRange() {
        List<Stick> sticks = List.of(
                Stick.NOT_FILLED,
                Stick.NOT_FILLED
        );
        Line line = new Line(sticks);

        assertThatThrownBy(() -> line.move(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> line.move(sticks.size() + 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private StickGenerator filledStickGenerator() {
        return () -> Stick.FILLED;
    }
}
