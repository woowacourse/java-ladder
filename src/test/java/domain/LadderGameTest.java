package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.ladder.BridgeGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.ladder.Width;
import domain.player.Player;
import domain.player.Players;
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
        final Players players = Players.createInOrderPoisition(List.of("pobi", "honux", "crong", "jk"));
        final MatchingItems matchingItems = new MatchingItems(List.of("꽝", "5000", "꽝", "3000"), players.count());
        final Height height = new Height(5);
        final Width width = Width.from(players);
        final Ladder ladder = LadderFactory.createByStrategy(bridgeGenerator, height, width);
        final LadderGame ladderGame = new LadderGame(players, matchingItems, ladder);

        ladderGame.play();
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
    void matchPersonalResult() {
        //given
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(
                true, false, true,
                false, true, false,
                true, false, false,
                false, true, false,
                true, false, true
        ));
        final Players players = Players.createInOrderPoisition(List.of("pobi", "honux", "crong", "jk"));
        final MatchingItems matchingItems = new MatchingItems(List.of("꽝", "5000", "꽝", "3000"), players.count());
        final Height height = new Height(5);
        final Width width = Width.from(players);
        final Ladder ladder = LadderFactory.createByStrategy(bridgeGenerator, height, width);
        final LadderGame ladderGame = new LadderGame(players, matchingItems, ladder);

        ladderGame.play();
        final GameResult pobiResult = ladderGame.matchResult("pobi");
        final GameResult honuxResult = ladderGame.matchResult("honux");
        final GameResult crongResult = ladderGame.matchResult("crong");
        final GameResult jkResult = ladderGame.matchResult("jk");

        //when & then
        assertAll(
                () -> assertThat(pobiResult).isEqualTo(new GameResult("pobi", "꽝")),
                () -> assertThat(honuxResult).isEqualTo(new GameResult("honux", "3000")),
                () -> assertThat(crongResult).isEqualTo(new GameResult("crong", "꽝")),
                () -> assertThat(jkResult).isEqualTo(new GameResult("jk", "5000"))
        );
    }

    @DisplayName("all을 입력하면 전체 결과를 알려준다.")
    @Test
    void matchAllResult() {
        //given
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(
                true, false, true,
                false, true, false,
                true, false, false,
                false, true, false,
                true, false, true
        ));
        final Players players = Players.createInOrderPoisition(List.of("pobi", "honux", "crong", "jk"));
        final MatchingItems matchingItems = new MatchingItems(List.of("꽝", "5000", "꽝", "3000"), players.count());
        final Height height = new Height(5);
        final Width width = Width.from(players);
        final Ladder ladder = LadderFactory.createByStrategy(bridgeGenerator, height, width);
        final LadderGame ladderGame = new LadderGame(players, matchingItems, ladder);

        ladderGame.play();
        final List<GameResult> gameResults = ladderGame.matchResultAll();

        //when & then
        assertAll(
                () -> assertThat(gameResults.get(0)).isEqualTo(new GameResult("pobi", "꽝")),
                () -> assertThat(gameResults.get(1)).isEqualTo(new GameResult("honux", "3000")),
                () -> assertThat(gameResults.get(2)).isEqualTo(new GameResult("crong", "꽝")),
                () -> assertThat(gameResults.get(3)).isEqualTo(new GameResult("jk", "5000"))
        );
    }
}
