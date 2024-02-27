package domain.ladder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FloorTest {

    @DisplayName("사다리의 한 층을 생성한다.")
    @Test
    void createFloor() {
        //given
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(false, true, false));

        //when
        Floor floor = Floor.createByStrategy(bridgeGenerator, new Width(3));

        //then
        assertThat(floor.getBridges()).containsExactly(Bridge.NO_BRIDGE, Bridge.BRIDGE, Bridge.NO_BRIDGE);
    }

    @DisplayName("위치를 받으면 다리를 따라 이동한 결과 위치를 반환한다.")
    @Test
    void moveAlongBridge() {
        //given
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(true, false, true));
        Floor floor = Floor.createByStrategy(bridgeGenerator, new Width(3));

        //when & then
        assertAll(
                () -> assertThat(floor.move(0)).isEqualTo(1),
                () -> assertThat(floor.move(1)).isEqualTo(0),
                () -> assertThat(floor.move(2)).isEqualTo(3),
                () -> assertThat(floor.move(3)).isEqualTo(2)
        );
    }
}
