package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("현재 생성된 Bridge 갯수를 리턴하는 기능")
    @Test
    public void getPointCount() {
        assertThat(new Line(5, new FixedBooleanGenerator(true)).getBridgeCount())
                .isEqualTo(4);
    }

    @DisplayName("연속으로 이어진 다리는 존재하지 않는다")
    @Test
    public void createLineNonContinuous() {
        Line line = new Line(4, new FixedBooleanGenerator(true));
        assertThat(line.getBridgesInformation()).isEqualTo(List.of(true, false, true));
    }

    @Test
    @DisplayName("왼쪽으로 이동가능한지 판단한다.")
    void canMoveLeft() {
        Line line = new Line(4, new FixedBooleanGenerator(true));
        int movableIndex = 1;
        int immovableIndex = 2;

        assertThat(line.canMoveLeft(movableIndex)).isTrue();
        assertThat(line.canMoveLeft(immovableIndex)).isFalse();

    }

    @Test
    @DisplayName("오른쪽으로 이동가능한지 판단한다.")
    void canMoveRight() {
        Line line = new Line(4, new FixedBooleanGenerator(true));
        int movableIndex = 2;
        int immovableIndex = 1;

        assertThat(line.canMoveRight(movableIndex)).isTrue();
        assertThat(line.canMoveRight(immovableIndex)).isFalse();

    }
}

