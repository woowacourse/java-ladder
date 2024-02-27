package ladderGame.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("Player들이 사다리를 타고 내려간다.")
    void descendLadder() {
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION)),
                new Line(List.of(ConnectionStatus.DISCONNECTION, ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION)),
                new Line(List.of(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION)),
                new Line(List.of(ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION)),
                new Line(List.of(ConnectionStatus.DISCONNECTION, ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION))
        ));

        Players players = new Players(List.of("pobi", "crong", "honux", "jk"));

        ladder.descendLadder(players);

        assertThat(players.getPositions()).isEqualTo(List.of(0, 3, 2, 1));
    }

}
