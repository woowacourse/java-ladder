package domain.ladder;

import static org.junit.jupiter.api.Assertions.assertAll;

import domain.ladder.strategy.BridgeGeneratorStub;
import domain.player.Player;
import domain.player.PlayerName;
import domain.player.Players;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void createLadderSuccessWithHeightAndPointCount() {
        // given
        Player player1 = new Player(new PlayerName("kaki"), 0);
        Player player2 = new Player(new PlayerName("solar"), 0);
        Player player3 = new Player(new PlayerName("eden"), 0);

        LadderHeight height = new LadderHeight(3);
        List<LadderBridge> bridges = List.of(LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.NONE);
        BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
        List<Player> players = List.of(player1, player2, player3);

        // when
        bridgeGeneratorStub.setBridges(bridges);
        Ladder ladder = Ladder.of(height, new Players(players), bridgeGeneratorStub);
        List<Floor> floors = ladder.getFloors();

        // then
        assertAll(
                () -> Assertions.assertThat(floors.size()).isEqualTo(3),
                () -> Assertions.assertThat(floors.get(0).getBridges().size()).isEqualTo(3)
        );
    }
}
