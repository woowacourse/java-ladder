package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.BooleanGenerator;
import util.TrueGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultsTest {

    @Test
    @DisplayName("사다리 결과 배열을 입력받았을 때 배열의 크기만큼 result 객체를 생성")
    void makeResultsAsAmountOfResultArraySize() {

        String[] results = {"1등", "2등", "3등", "꽝"};
        int numberOfPlayers = 4;

        assertThat(Results.of(results, numberOfPlayers).getResults().size()).isEqualTo(results.length);
    }

    @Test
    @DisplayName("사다리 결과 개수가 플레이어 수와 불일치할 경우 예외 발생")
    void throwExceptionWhenNumberOfResultsIsNotMatchedWithPlayers() {

        String[] results = {"1등", "2등", "3등", "꽝"};
        int numberOfPlayers = 6;

        assertThatThrownBy(() -> Results.of(results, numberOfPlayers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리 결과 수가 플레이어 수와 일치하지 않습니다.");
    }

    @Test
    @DisplayName("Player와 실행 결과를 매칭했을 때 HashMap 형식으로 매칭 결과가 출력된다")
    void matchPlayersWithResults() {
        String[] playersInput = {"roy", "poy", "soy", "coy"};
        Players players = Players.from(playersInput);
        String[] resultInput = {"2nd", "1st", "4th", "3rd"};
        Results results = Results.of(resultInput, 4);
        BooleanGenerator booleanGenerator = new TrueGenerator();
        Ladder ladder = Ladder.makeDefaultLadder(4, 1, booleanGenerator);

        ladder.generateRandomLadder();
        ladder.movePlayers(players);
        MatchingResult matchingResult = results.matchResults(players);

        assertThat(matchingResult.getMatchingResult().get(players.getPlayers().get(0))).isEqualTo(results.getResults().get(1));
        assertThat(matchingResult.getMatchingResult().get(players.getPlayers().get(1))).isEqualTo(results.getResults().get(0));
        assertThat(matchingResult.getMatchingResult().get(players.getPlayers().get(2))).isEqualTo(results.getResults().get(3));
        assertThat(matchingResult.getMatchingResult().get(players.getPlayers().get(3))).isEqualTo(results.getResults().get(2));
    }
}
