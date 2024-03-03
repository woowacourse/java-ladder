package domain.ladder;

import static org.junit.jupiter.api.Assertions.assertAll;

import domain.ladder.strategy.BridgeGeneratorStub;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderGeneratorTest {

    @Test
    void createLadderSuccessWithHeightAndPointCount() {
        // given
        PlayerName playerName1 = new PlayerName("kaki");
        PlayerName playerName2 = new PlayerName("solar");
        PlayerName playerName3 = new PlayerName("eden");

        LadderHeight height = new LadderHeight(3);
        List<LadderBridge> bridges = List.of(LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.NONE);
        BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
        PlayerNames playerNames = new PlayerNames(List.of(playerName1, playerName2, playerName3));

        // when
        bridgeGeneratorStub.setBridges(bridges);
        LadderGenerator ladderGenerator = new LadderGenerator(height, playerNames, bridgeGeneratorStub);
        List<Floor> floors = ladderGenerator.generateLadder();

        // then
        assertAll(
                () -> Assertions.assertThat(floors.size()).isEqualTo(3),
                () -> Assertions.assertThat(floors.get(0).getBridges().size()).isEqualTo(3)
        );
    }
}
