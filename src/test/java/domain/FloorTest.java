package domain;

import domain.bridge.strategy.BridgeGeneratorStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FloorTest {
    @Test
    @DisplayName("가로 라인이 연속되는 포인트는 생성되지 않는다")
    void createLineSuccessWithNoneSerialPoints() {
        int playerCount = 4;

        List<LadderBridge> bridges = List.of(LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.BRIDGE);
        BridgeGeneratorStub bridgeGenerator = new BridgeGeneratorStub();
        bridgeGenerator.setBridges(bridges);

        Floor floor = new Floor(bridgeGenerator.generate(playerCount - 1));
        Assertions.assertThat(floor.getBridges()).containsExactlyElementsOf(bridges);
    }
}
