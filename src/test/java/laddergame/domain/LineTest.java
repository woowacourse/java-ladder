package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
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
    void connected() {
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
        List<Stick> sticks = List.of(
                Stick.FILLED,
                Stick.NOT_FILLED,
                Stick.FILLED
        );
        Line line = createLine(sticks, 4);

        Direction result = line.move(new Column(3));

        assertThat(result).isEqualTo(Direction.LEFT);
    }

    @DisplayName("주어진 컬럼 오른쪽에 이동 가능한 막대가 있는지 체크할 수 있다.")
    @Test
    void moveRight() {
        List<Stick> sticks = List.of(
                Stick.FILLED,
                Stick.NOT_FILLED,
                Stick.FILLED
        );
        Line line = createLine(sticks, 4);

        Direction result = line.move(new Column(0));

        assertThat(result).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("주어진 줄에서 왼쪽과 오른쪽에 막대가 없으면 이동 불가능하다.")
    @Test
    void stay() {
        List<Stick> sticks = List.of(
                Stick.NOT_FILLED,
                Stick.NOT_FILLED
        );
        Line line = createLine(sticks, 3);

        Direction result = line.move(new Column(0));

        assertThat(result).isEqualTo(Direction.STAY);
    }

    @DisplayName("막대의 총 갯수 이하의 컬럼만을 이용해서 이동 여부를 판단할 수 있다.")
    @Test
    void checkColumnRange() {
        List<Stick> sticks = List.of(
                Stick.NOT_FILLED,
                Stick.NOT_FILLED
        );
        Line line = createLine(sticks, 3);

        assertThatThrownBy(() -> line.move(new Column(sticks.size() + 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Line createLine(List<Stick> sticks, int playerSize) {
        SimpleStickGenerator simpleStickGenerator = new SimpleStickGenerator(sticks);

        return new Line(simpleStickGenerator, playerSize);
    }

    private StickGenerator filledStickGenerator() {
        return () -> Stick.FILLED;
    }
}
