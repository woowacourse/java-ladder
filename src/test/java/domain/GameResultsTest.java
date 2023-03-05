package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameResultsTest {

    @DisplayName("실행 결과가 비어있는 경우 예외 처리 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullAndEmpty(String result) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResult(new Player("a", 0), result));
    }

    @DisplayName("실행 결과를 일급컬렉션에 저장한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    void generateGameResults(int playerSize) {
        List<GameResult> gameResults = new ArrayList<>();
        for (int resultIndex = 0; resultIndex < playerSize; resultIndex++) {
            gameResults.add(new GameResult(new Player("a", resultIndex), "꽝"));
        }
        assertThatNoException()
                .isThrownBy(() -> new GameResults(gameResults));
    }

    @DisplayName("저장한 실행 결과명을 가져올 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    void getGameResults(int playerSize) {
        List<GameResult> gameResultList = new ArrayList<>();
        for (int resultIndex = 0; resultIndex < playerSize; resultIndex++) {
            gameResultList.add(new GameResult(new Player("a", resultIndex), "꽝"));
        }
        GameResults gameResults = new GameResults(gameResultList);
        assertThat(gameResults.getGameResults().get(0))
                .isInstanceOf(GameResult.class);
    }

}
