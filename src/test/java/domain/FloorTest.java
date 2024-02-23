package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;
import domain.bridge.strategy.BridgeGeneratorStub;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FloorTest {

    @Test
    @DisplayName("가로 라인에서 다리가 연속되어 있다면 예외가 발생한다")
    void createFloorFailByNoneSerialBridge() {
        List<LadderBridge> points = List.of(LadderBridge.BRIDGE, LadderBridge.BRIDGE, LadderBridge.NONE);
        BridgeGeneratorStub pointGenerator = new BridgeGeneratorStub();
        pointGenerator.setBridges(points);
        int pointCount = points.size();

        Assertions.assertThatThrownBy(() -> new Floor(pointGenerator.generate(pointCount)))
                .isInstanceOf(ValidationException.class)
                .hasMessage(ExceptionMessage.SERIAL_BRIDGE);
    }
}
