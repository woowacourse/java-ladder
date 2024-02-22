package domain;

import domain.point.strategy.BridgeGeneratorStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @Test
    @DisplayName("가로 라인이 연속되는 포인트는 생성되지 않는다")
    void createLineSuccessWithNoneSerialPoints() {
        int playerCount = 4;

        List<LadderBridge> points = List.of(LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.BRIDGE);
        BridgeGeneratorStub pointGenerator = new BridgeGeneratorStub();
        pointGenerator.setBridges(points);

        Line line = new Line(pointGenerator.generate(playerCount - 1));
        Assertions.assertThat(line.getBridges()).containsExactlyElementsOf(points);
    }
}
