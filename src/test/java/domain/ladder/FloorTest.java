package domain.ladder;

import domain.ladder.message.LadderExceptionMessage;
import domain.ladder.strategy.BridgeGeneratorStub;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FloorTest {

    @Test
    @DisplayName("가로 라인에서 다리가 연속되어 있다면 예외가 발생한다")
    void createFloorFailByNoneSerialBridge() {
        // given
        List<LadderBridge> bridges = List.of(LadderBridge.BRIDGE, LadderBridge.BRIDGE, LadderBridge.NONE);
        BridgeGeneratorStub pointGenerator = new BridgeGeneratorStub();

        // when
        pointGenerator.setBridges(bridges);
        int bridgeCount = bridges.size();

        // then
        Assertions.assertThatThrownBy(() -> new Floor(pointGenerator.generate(bridgeCount)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LadderExceptionMessage.SERIAL_LADDER_BRIDGE);
    }
}
