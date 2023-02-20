package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NonExistFootholdGenerator;

class GameTest {

    private static Players players;
    private static Line line;
    private static Lines lines;
    private static Ladder ladder;
    private static LadderResults ladderResults;
    private static Game game;

    @BeforeAll
    public static void initGame() {
        List<String> playerNames = List.of("pobi", "crong", "honux");
        players = new Players(playerNames);
        line = new Line(playerNames.size(), new NonExistFootholdGenerator());
        lines = new Lines(List.of(line, line, line, line));
        ladder = new Ladder(lines, new Height(4));
        ladderResults = new LadderResults(List.of("1", "2", "3"));
        game = new Game(players, ladder, ladderResults);
    }

    @Test
    @DisplayName("사다리 게임의 결과를 계산한다.")
    void calculate_ladder_game_result() {
        // when
        Map<Player, LadderResult> results = game.findGameResults();

        // then
        assertThat(results.get(players.findPlayerByName("pobi")).getResult()).isEqualTo(
                ladderResults.getLadderResultOfIndex(0));
    }

    @Test
    @DisplayName("특정 유저의 결과를 반환한다.")
    void returns_player_result() {
        // given
        Player player = players.getPlayers().get(0);

        // when
        String expectedResult = game.findPlayerResult(player.getName());

        // then
        assertThat(expectedResult).isEqualTo(game.findGameResults().get(player).getResult());
    }
}
