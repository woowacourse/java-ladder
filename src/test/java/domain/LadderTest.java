package domain;

import domain.bridge.strategy.BridgeGeneratorStub;
import domain.bridge.strategy.RandomBridgeGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @Test
    void createLadderSuccessWithHeightAndPointCount() {
        LadderHeight height = new LadderHeight("3");
        int pointCount = 3;

        Ladder ladder = Ladder.create(height, pointCount, new RandomBridgeGenerator());
        List<Floor> floors = ladder.getFloors();
        assertAll(
                () -> Assertions.assertThat(floors.size()).isEqualTo(3),
                () -> Assertions.assertThat(floors.get(0).getBridges().size()).isEqualTo(3)
        );

    }
}
