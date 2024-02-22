package domain;

import domain.bridge.strategy.BridgeGeneratorStub;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FloorTest {
    @Test
    @DisplayName("가로 라인이 연속되는 포인트는 생성되지 않는다")
    void createFloorSuccessWithNoneSerialPoints() {
        int playerCount = 4;

        List<LadderBridge> points = List.of(LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.BRIDGE);
        BridgeGeneratorStub pointGenerator = new BridgeGeneratorStub();
        pointGenerator.setBridges(points);

        Floor floor = new Floor(pointGenerator.generate(playerCount - 1));
        Assertions.assertThat(floor.getBridges()).containsExactlyElementsOf(points);
    }
}
