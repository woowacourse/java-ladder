package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class GameResultTest {
    @ParameterizedTest
    @ValueSource(strings = {"aaaaa", "b", "11111", "2"})
    @DisplayName("정상 입력한 경우 예외가 발생하지 않는다.")
    void normalInput(String gameResult) {
        assertThatNoException()
                .isThrownBy(() -> new GameResult(gameResult));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", ""})
    @DisplayName("실행 결과 글자 길이가 1~5를 벗어난 경우 예외가 발생한다.")
    void validateOutOfLength(String gameResults) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResult(gameResults))
                .withMessage("각 상품의 글자 길이는 1~5입니다.");
    }
    
    @ParameterizedTest
    @CsvSource(value = {"abcde, 5", "a, 1"})
    @DisplayName("실행 결과의 글자 수를 반환한다.")
    void length(String inputGameResult, int gameResultLength) {
        GameResult gameResult = new GameResult(inputGameResult);
        assertThat(gameResult.length()).isEqualTo(gameResultLength);
    }
}