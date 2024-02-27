package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.ladder.BridgeGenerator;
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
        final LadderGame ladderGame = new LadderGame(
                List.of("pobi", "honux", "crong", "jk"),
                List.of("꽝", "5000", "꽝", "3000"),
                5,
                bridgeGenerator);
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

    @DisplayName("개인별 이름을 입력하면 개인별 결과를 알려준다.")
    @Test
    void informPersonalResult() {
        //given
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(
                true, false, true,
                false, true, false,
                true, false, false,
                false, true, false,
                true, false, true
        ));
        final LadderGame ladderGame = new LadderGame(
                List.of("pobi", "honux", "crong", "jk"),
                List.of("꽝", "5000", "꽝", "3000"),
                5,
                bridgeGenerator);

        ladderGame.play();
        final String pobiResult = ladderGame.matchResult("pobi");
        final String honuxResult = ladderGame.matchResult("honux");
        final String crongResult = ladderGame.matchResult("crong");
        final String jkResult = ladderGame.matchResult("jk");

        // when & then
        assertAll(
                () -> assertThat(pobiResult).isEqualTo("꽝"),
                () -> assertThat(honuxResult).isEqualTo("3000"),
                () -> assertThat(crongResult).isEqualTo("꽝"),
                () -> assertThat(jkResult).isEqualTo("5000")
        );
    }
}
