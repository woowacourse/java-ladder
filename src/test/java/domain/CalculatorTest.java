package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NonExistFootholdGenerator;

class CalculatorTest {

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
    }

    @Test
    @DisplayName("유저와 보상을 매칭시킨 자료형을 반환시켜준다.")
    void returns_game_result() {
        // when
        Calculator calculator = new Calculator(players, ladder, ladderResults);
        Map<Player, LadderResult> expectedReturns = calculator.getPlayerWithResult();

        // then
        assertThat(expectedReturns.containsKey(players));
    }

    @Test
    @DisplayName("해당하는 유저의 결과물을 반환한다.")
    void returns_player_result() {
        // when
        Calculator calculator = new Calculator(players, ladder, ladderResults);
        String expectedResult = calculator.findPlayerResult(players.getPlayers().get(0));

        // then
        assertThat(expectedResult).isEqualTo(ladderResults.findFirstResult());
    }
}
