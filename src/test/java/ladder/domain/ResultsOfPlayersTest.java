package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsOfPlayersTest {
    @DisplayName("이름(문자열)을 입력하면 보상을 반환한다.")
    @Test
    void getResultByNameTest() {
        Player poby = new Player(new Name("poby"), new Location(0));
        Player honux = new Player(new Name("honux"), new Location(1));
        Players climbedPlayers = new Players(List.of(poby, honux));
        Results results = new Results(List.of(new Result("100"), new Result("200")));
        ResultsOfPlayers resultsOfPlayers = new ResultsOfPlayers(climbedPlayers, results);

        assertThat(resultsOfPlayers.getResultByName("poby")).isEqualTo(new Result("100"));
    }

    @DisplayName("존재하지 않는 이름을 입력하면 에러를 던진다.")
    @Test
    void invalidGetResultByNameTest() {
        Player poby = new Player(new Name("poby"), new Location(0));
        Player honux = new Player(new Name("honux"), new Location(1));
        Players climbedPlayers = new Players(List.of(poby, honux));
        Results results = new Results(List.of(new Result("100"), new Result("200")));
        ResultsOfPlayers resultsOfPlayers = new ResultsOfPlayers(climbedPlayers, results);

        assertThatThrownBy(() -> resultsOfPlayers.getResultByName("jk"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 사용자입니다: jk");
    }

    @DisplayName("전체 보상을 반환한다.")
    @Test
    void getAllResultsTest() {
        Player poby = new Player(new Name("poby"), new Location(0));
        Player honux = new Player(new Name("honux"), new Location(1));
        Players climbedPlayers = new Players(List.of(poby, honux));
        Results results = new Results(List.of(new Result("100"), new Result("200")));
        ResultsOfPlayers resultsOfPlayers = new ResultsOfPlayers(climbedPlayers, results);

        Map<Player, Result> allResults = resultsOfPlayers.getResultsOfPlayers();

        assertThat(allResults).isEqualTo(Map.of(poby, new Result("100"), honux, new Result("200")));
    }
}
