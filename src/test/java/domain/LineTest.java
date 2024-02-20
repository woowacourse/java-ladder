package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("현재 위치에서 오른쪽으로 다리를 놓을 수 없는 경우")
    @Test
    void checkIsImpossibleAddBridgeTest() {
        // given
        Line line = new Line(5);
        line.getPoints().add(Direction.RIGHT);

        // when
        assertThat(line.checkIsPossibleAddBridge(1)).isFalse();
    }

    @DisplayName("현재 위치에서 오른쪽으로 다리를 놓을 수 있는 경우")
    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"RIGHT"})
    void checkIsPossibleAddBridgeTest(Direction direction) {
        // given
        Line line = new Line(5);
        line.getPoints().add(direction);

        // when
        assertThat(line.checkIsPossibleAddBridge(1)).isTrue();
    }
}