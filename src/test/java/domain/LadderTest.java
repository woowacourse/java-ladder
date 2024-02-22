package domain;

import static org.junit.jupiter.api.Assertions.assertAll;

import domain.bridge.strategy.BridgeGeneratorStub;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void createLadderSuccessWithHeightAndPointCount() {
        LadderHeight height = new LadderHeight("3");
        int pointCount = 3;
        BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
        bridgeGeneratorStub.setBridges(List.of(LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.BRIDGE));
        Ladder ladder = Ladder.of(height, pointCount, bridgeGeneratorStub);
        List<Floor> floors = ladder.getFloors();
        assertAll(
                () -> Assertions.assertThat(floors.size()).isEqualTo(3),
                () -> Assertions.assertThat(floors.get(0).getBridges().size()).isEqualTo(3)
        );
    }
}
