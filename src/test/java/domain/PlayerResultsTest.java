package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class PlayerResultsTest {

    private HashMap<Name,Result>rawPlayerResults;

    @BeforeEach
    void init(){
        final List<String> names = List.of("pobi", "honux", "crong", "jk");
        final Names players = new Names(names);
        int playerCount = players.count();

        List<String> rawResults = List.of("꽝", "2000", "꽝", "5000");
        Results results = Results.of(rawResults, playerCount);

        rawPlayerResults = new HashMap<>();
        for (int i = 0; i < playerCount; i++) {
            rawPlayerResults.put(players.getValues().get(i), results.getValues().get(i));
        }
    }

    @DisplayName("각 참가자는 하나의 결과를 가진다.")
    @Test
    void createPlayerResults() {
        //when & then
        Assertions.assertThatCode(() -> new PlayerResults(rawPlayerResults)).doesNotThrowAnyException();

    }

    @DisplayName("참가자의 이름으로 실행 결과를 가져온다.")
    @Test
    void findPlayerResult() {
        //given
        PlayerResults playerResults = new PlayerResults(rawPlayerResults);

        String targetName = "honux";
        String expectedResult = "2000";

        //when
        Result result = playerResults.findResult(targetName);

        //then
        Assertions.assertThat(result.getValue()).isEqualTo(expectedResult);
    }

    @DisplayName("존재하지 않는 참가자 이름으로 찾으면 예외를 던진다.")
    @Test
    void findPlayerResultByUnknownName() {
        //given
        PlayerResults playerResults = new PlayerResults(rawPlayerResults);

        String unknownName = "unknown";

        //then
        Assertions.assertThatThrownBy(() -> playerResults.findResult(unknownName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PlayerResults.UNKNOWN_NAME);
    }
}
