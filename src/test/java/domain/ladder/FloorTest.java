package domain.ladder;

import domain.Players;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FloorTest {

    @DisplayName("사다리의 한 층을 생성한다.")
    @Test
    void createFloor() {
        //given
        final Players players = new Players(List.of("a", "b", "c", "d"));
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(false, true, false));

        //when
        Floor floor = Floor.createByStrategy(bridgeGenerator, Width.from(players));

        //then
        Assertions.assertThat(floor.getBridges()).containsExactly(Bridge.NO_BRIDGE, Bridge.BRIDGE, Bridge.NO_BRIDGE);
    }

    @DisplayName("다리를 따라 참가자의 위치를 이동시킨다.")
    @Test
    void moveLeftAlongBridge() {
        //given
        final Players players = new Players(List.of("a", "b", "c", "d"));
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(false, true, false));
        Floor floor = Floor.createByStrategy(bridgeGenerator, Width.from(players));

        //when
        //then
    }
}
