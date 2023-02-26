package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameResultsTest {

    @DisplayName("실행 결과의 개수가 플레이어 수보다 적으면 예외 처리 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "10:11", "11:10", "19:20", "20:21"}, delimiter = ':')
    void validateResultSize(String playerSize, String resultsSize) {
        List<GameResult> results = new ArrayList<>();
        for (int resultIndex = 0; resultIndex < Integer.parseInt(resultsSize); resultIndex++) {
            results.add(new GameResult(String.valueOf(resultIndex)));
        }
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResults(Integer.parseInt(playerSize), results));
    }

    @DisplayName("실행 결과가 비어있는 경우 예외 처리 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullAndEmpty(String result) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResult(result));
    }

    @DisplayName("실행 결과를 일급컬렉션에 저장한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    void generateGameResults(int playerSize) {
        List<GameResult> gameResults = new ArrayList<>();
        for (int resultIndex = 0; resultIndex < playerSize; resultIndex++) {
            gameResults.add(new GameResult("꽝"));
        }
        assertThatNoException()
                .isThrownBy(() -> new GameResults(playerSize, gameResults));
    }

    @DisplayName("저장한 실행 결과명을 가져올 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    void getGameResults(int playerSize) {
        List<GameResult> gameResultList = new ArrayList<>();
        for (int resultIndex = 0; resultIndex < playerSize; resultIndex++) {
            gameResultList.add(new GameResult("꽝"));
        }
        GameResults gameResults = new GameResults(playerSize, gameResultList);
        assertThat(gameResults.getGameResults().get(0))
                .isInstanceOf(GameResult.class);
    }

    @DisplayName("실행 결과는 입력한 순서대로 사다리에 매핑된다.")
    @ParameterizedTest
    @CsvSource(value = {"0:꽝", "1:꽝", "2:당첨"}, delimiter = ':')
    void mapGameResultWithLadder(String index, String gameResult) {
        GameResults gameResults = new GameResults(
                3,
                List.of(new GameResult("꽝"), new GameResult("꽝"), new GameResult("당첨"))
        );
        assertThat(gameResults.getGameResultAt(Integer.parseInt(index)).getGameResultName())
                .isEqualTo(gameResult);
    }

}
