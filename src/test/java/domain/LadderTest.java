package domain;

import static org.junit.jupiter.api.Assertions.assertAll;

import domain.bridge.strategy.BridgeGeneratorStub;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.ladder.LadderBridge;
import domain.ladder.LadderHeight;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void createLadderSuccessWithHeightAndPointCount() {
        // given
        LadderHeight height = new LadderHeight(3);
        List<LadderBridge> bridges = List.of(LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.NONE);
        BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
        List<PlayerName> playerNames = List.of(new PlayerName("kaki"), new PlayerName("eden"), new PlayerName("solar"));

        // when
        bridgeGeneratorStub.setBridges(bridges);
        Ladder ladder = Ladder.of(height, new PlayerNames(playerNames), bridgeGeneratorStub);
        List<Floor> floors = ladder.getFloors();

        // then
        assertAll(
                () -> Assertions.assertThat(floors.size()).isEqualTo(3),
                () -> Assertions.assertThat(floors.get(0).getBridges().size()).isEqualTo(3)
        );
    }
}
