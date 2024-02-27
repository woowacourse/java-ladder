package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerResultsTest {

    private Names names;
    private Ladder ladder;
    private Results results;

    @BeforeEach
    void init() {
        final List<String> rawNames = List.of("pobi", "honux", "crong", "jk");
        names = new Names(rawNames);
        int playerCount = names.count();

        final int height = 3;
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(
                List.of(false, true, false),
                List.of(true, false, false),
                List.of(true, false, true));
        ladder = Ladder.createByStrategy(bridgeGenerator, height, playerCount);

        List<String> rawResults = List.of("꽝", "2000", "꽝", "5000");
        results = Results.of(rawResults, playerCount);
    }

    @DisplayName("참가자의 이름과 사다리를 탄 결과를 저장한다.")
    @Test
    void createPlayerResults() {
        //given
        final List<String> targetNames = List.of("pobi", "honux", "crong", "jk");
        final List<String> expectedResults = List.of("꽝", "5000", "2000", "꽝");

        //when
        PlayerResults playerResults = PlayerResults.of(names, ladder, results);

        //then
        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(playerResults.findResult(targetNames.get(0)).getValue()).isEqualTo(expectedResults.get(0)),
                () -> Assertions.assertThat(playerResults.findResult(targetNames.get(1)).getValue()).isEqualTo(expectedResults.get(1)),
                () -> Assertions.assertThat(playerResults.findResult(targetNames.get(2)).getValue()).isEqualTo(expectedResults.get(2)),
                () -> Assertions.assertThat(playerResults.findResult(targetNames.get(3)).getValue()).isEqualTo(expectedResults.get(3))
        );

    }

    @DisplayName("참가자의 이름으로 실행 결과를 가져온다.")
    @Test
    void findPlayerResult() {
        //given
        PlayerResults playerResults = PlayerResults.of(names, ladder, results);

        String targetName = "honux";
        String expectedResult = "5000";

        //when
        Result result = playerResults.findResult(targetName);

        //then
        Assertions.assertThat(result.getValue()).isEqualTo(expectedResult);
    }

    @DisplayName("존재하지 않는 참가자 이름으로 찾으면 예외를 던진다.")
    @Test
    void findPlayerResultByUnknownName() {
        //given
        PlayerResults playerResults = PlayerResults.of(names, ladder, results);

        String unknownName = "unknown";

        //then
        Assertions.assertThatThrownBy(() -> playerResults.findResult(unknownName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PlayerResults.UNKNOWN_NAME);
    }
}
