package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import domain.ladder.BridgeGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.Width;
import domain.player.Player;
import domain.player.Position;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @DisplayName("결과에 맞게 참가자의 위치를 변경한다.")
    @Test
    void reflectLadderGamePlay() {
        //given
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(
                true, false, true,
                false, true, false,
                true, false, false,
                false, true, false,
                true, false, true
        ));
        final LadderGame ladderGame = new LadderGame(List.of("pobi", "honux", "crong", "jk"), 5, bridgeGenerator);
        final Players players = ladderGame.play();
        final List<Player> rawPlayers = players.getPlayers();

        // when & then
        assertAll(
                () -> assertThat(rawPlayers.get(0).getPosition()).isEqualTo(new Position(0)),
                () -> assertThat(rawPlayers.get(1).getPosition()).isEqualTo(new Position(3)),
                () -> assertThat(rawPlayers.get(2).getPosition()).isEqualTo(new Position(2)),
                () -> assertThat(rawPlayers.get(3).getPosition()).isEqualTo(new Position(1))
        );
    }
}
