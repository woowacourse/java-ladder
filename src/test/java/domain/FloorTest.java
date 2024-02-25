package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;
import domain.bridge.strategy.BridgeGeneratorStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FloorTest {
    @Test
    @DisplayName("가로 라인이 연속되는 다리는 생성되지 않는다")
    void createLineSuccessWithNoneSerialBridges() {
        //given
        BridgeGeneratorStub bridgeGenerator = new BridgeGeneratorStub();
        List<LadderBridge> bridges = List.of(LadderBridge.BRIDGE, LadderBridge.BRIDGE, LadderBridge.NONE);

        //when
        bridgeGenerator.setBridges(bridges);
        int bridgeCount = bridges.size();

        //then
        Assertions.assertThatThrownBy(
                        () -> new Floor(bridgeGenerator.generate(bridgeCount)))
                .isInstanceOf(ValidationException.class)
                .hasMessage(ExceptionMessage.SERIAL_LADDER_BRIDGE);
    }
}
