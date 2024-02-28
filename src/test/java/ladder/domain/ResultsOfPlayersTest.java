package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsOfPlayersTest {
    @DisplayName("이름(문자열)을 입력하면 보상을 반환한다.")
    @Test
    void getResultByNameTest() {
        Players players = new Players(List.of("poby", "honux"));
        Results results = new Results(List.of("100", "200"));
        Ladder ladder = new Ladder(new Width(2), new Height(3), () -> RIGHT);
        ResultsOfPlayers resultsOfPlayers = new ResultsOfPlayers(players, ladder, results);

        assertThat(resultsOfPlayers.getResultByName("poby")).isEqualTo(new Result("200"));
    }

    @DisplayName("전체 보상을 반환한다.")
    @Test
    void getAllResultsTest() {
        Players players = new Players(List.of("poby", "honux"));
        Results results = new Results(List.of("100", "200"));
        Ladder ladder = new Ladder(new Width(2), new Height(3), () -> RIGHT);
        ResultsOfPlayers resultsOfPlayers = new ResultsOfPlayers(players, ladder, results);

        Map<Player, Result> allResults = resultsOfPlayers.getAllResults();

        assertAll(
                () -> assertThat(allResults.get(new Player("poby"))).isEqualTo(new Result("200")),
                () -> assertThat(allResults.get(new Player("honux"))).isEqualTo(new Result("100"))
        );
    }
}
