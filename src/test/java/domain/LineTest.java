package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    @DisplayName("라인을 생성한다.")
    @Test
    void createLine() {
        //given
        int personCount = 4;
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(false, true, false));

        //when
        Line line = Line.createByStrategy(bridgeGenerator, personCount);

        //then
        assertThat(line.getBridges()).containsExactly(Bridge.NO_BRIDGE, Bridge.BRIDGE, Bridge.NO_BRIDGE);
    }

    @DisplayName("다리가 있는 방향을 알려준다.")
    @Test
    void climb() {
        //given
        int personCount = 4;
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(false, true, false));
        List<Direction> expectedDirection = List.of(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE);
        Line line = Line.createByStrategy(bridgeGenerator, personCount);

        //when & then
        assertAll(
                () -> assertThat(line.findDirection(0)).isEqualTo(expectedDirection.get(0)),
                () -> assertThat(line.findDirection(1)).isEqualTo(expectedDirection.get(1)),
                () -> assertThat(line.findDirection(2)).isEqualTo(expectedDirection.get(2)),
                () -> assertThat(line.findDirection(3)).isEqualTo(expectedDirection.get(3))
        );
    }
}
