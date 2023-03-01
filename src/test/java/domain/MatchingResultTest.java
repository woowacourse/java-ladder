package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.BooleanGenerator;
import util.TrueGenerator;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchingResultTest {

    @Test
    @DisplayName("players와 results의 매칭 결과를 담은 Map을 입력하면 MatchingResult 객체가 생성된다 ")
    void makeMatchingResult() {
        Map<Player, Result> finalResult = Map.of(new Player("로이", 0), new Result("당첨"));

        Assertions.assertDoesNotThrow(() -> new MatchingResult(finalResult));
    }

    @Test
    @DisplayName("결과를 알고 싶은 사람을 입력하면 사람이름과 결과를 담은 hashmap을 리턴한다")
    void findResultWhenGettingPlayerNameAsInput() {
        String[] playersInput = {"roy", "poy", "soy", "coy"};
        Players players = Players.from(playersInput);
        String[] resultInput = {"2nd", "1st", "4th", "3rd"};
        Results results = Results.of(resultInput, 4);
        BooleanGenerator booleanGenerator = new TrueGenerator();
        Ladder ladder = Ladder.makeDefaultLadder(4, 1, booleanGenerator);

        ladder.generateRandomLadder();
        ladder.movePlayers(players);
        MatchingResult matchingResult = results.matchResults(players);

        String[] playerToKnow = {"roy"};
        Player expectedPlayer = players.getPlayers().get(0);
        Result expectedResult = results.getResults().get(1);

        assertThat(matchingResult.getFinalResult(players, playerToKnow)).isEqualTo(Map.of(expectedPlayer, expectedResult));
    }
}
