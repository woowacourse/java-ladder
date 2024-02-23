package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgesTest {

    @DisplayName("다리들을 생성한다.")
    @Test
    void createLine() {
        //given
        int personCount = 4;
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(false, true, false));

        //when
        Bridges line = Bridges.createByStrategy(bridgeGenerator, personCount);

        //then
        Assertions.assertThat(line.getBridges()).containsExactly(Bridge.NO_BRIDGE, Bridge.BRIDGE, Bridge.NO_BRIDGE);
    }
}
