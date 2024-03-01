package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("참가자의 수와 실행 결과의 수가 같으면 잘 생성된다.")
    @Test
    void samePlayerCountAndMatchingItemsCount() {
        //given
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(
                true, false, true,
                false, true, false,
                true, false, false,
                false, true, false,
                true, false, true
        ));
        final Players players = Players.createInOrderPoisition(List.of("pobi", "honux"));
        final Results results = new Results(List.of(new Result("꽝"), new Result("3000")));
        final Height height = new Height(5);
        final Width width = Width.from(players);
        final Ladder ladder = LadderFactory.createByStrategy(bridgeGenerator, height, width);

        //when & then
        assertThatCode(() -> new LadderGame(players, results, ladder))
                .doesNotThrowAnyException();
    }

    @DisplayName("참가자의 수와 실행 결과의 수가 다르면 예외가 발생한다.")
    @Test
    void doesNotSamePlayerCountAndMatchingItemsCount() {
        //given
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(
                true, false, true,
                false, true, false,
                true, false, false,
                false, true, false,
                true, false, true
        ));
        final Players players = Players.createInOrderPoisition(List.of("pobi", "honux"));
        final Results results = new Results(List.of(new Result("꽝")));
        final Height height = new Height(5);
        final Width width = Width.from(players);
        final Ladder ladder = LadderFactory.createByStrategy(bridgeGenerator, height, width);

        //when & then
        assertThatThrownBy(() -> new LadderGame(players, results, ladder))
                .isInstanceOf(IllegalArgumentException.class);
    }

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
        final Results results = new Results(List.of(
                new Result("꽝"), new Result("5000"), new Result("꽝"), new Result("3000"))
        );
        final Height height = new Height(5);
        final Width width = Width.from(players);
        final Ladder ladder = LadderFactory.createByStrategy(bridgeGenerator, height, width);
        final LadderGame ladderGame = new LadderGame(players, results, ladder);

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
        final Results results = new Results(List.of(
                new Result("꽝"), new Result("5000"), new Result("꽝"), new Result("3000"))
        );
        final Height height = new Height(5);
        final Width width = Width.from(players);
        final Ladder ladder = LadderFactory.createByStrategy(bridgeGenerator, height, width);
        final LadderGame ladderGame = new LadderGame(players, results, ladder);

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
        final Results results = new Results(List.of(
                new Result("꽝"), new Result("5000"), new Result("꽝"), new Result("3000"))
        );
        final Height height = new Height(5);
        final Width width = Width.from(players);
        final Ladder ladder = LadderFactory.createByStrategy(bridgeGenerator, height, width);
        final LadderGame ladderGame = new LadderGame(players, results, ladder);

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
