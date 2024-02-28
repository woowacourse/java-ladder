package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("존재하지 않는 이름을 입력하면 에러를 던진다.")
    @Test
    void invalidGetResultByNameTest() {
        Players players = new Players(List.of("poby", "honux"));
        Results results = new Results(List.of("100", "200"));
        Ladder ladder = new Ladder(new Width(2), new Height(3), () -> RIGHT);
        ResultsOfPlayers resultsOfPlayers = new ResultsOfPlayers(players, ladder, results);

        assertThatThrownBy(() -> resultsOfPlayers.getResultByName("jk"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 사용자입니다: jk");
    }

    @DisplayName("전체 보상을 반환한다.")
    @Test
    void getAllResultsTest() {
        Players players = new Players(List.of("poby", "honux"));
        Results results = new Results(List.of("100", "200"));
        Ladder ladder = new Ladder(new Width(2), new Height(3), () -> RIGHT);
        ResultsOfPlayers resultsOfPlayers = new ResultsOfPlayers(players, ladder, results);

        Map<Player, Result> allResults = resultsOfPlayers.getResultsOfPlayers();
        Result actualPobyResult = allResults.get(new Player(new Name("poby")));
        Result actualHonuxResult = allResults.get(new Player(new Name("honux")));

        assertAll(
                () -> assertThat(actualPobyResult).isEqualTo(new Result("200")),
                () -> assertThat(actualHonuxResult).isEqualTo(new Result("100"))
        );
    }
}
