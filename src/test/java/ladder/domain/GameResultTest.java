package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameResultTest {
    private PlayerNames playerNames;
    private GameResult gameResult;
    private List<Integer> movedPositions;
    
    @BeforeEach
    void setUp() {
        playerNames = new PlayerNames("a,b,c,d");
        movedPositions = List.of(1,0,3,2);
        gameResult = new GameResult("꽝,5000,꽝,3000", playerNames);
    }
    
    @ParameterizedTest(name = "resultPosition : {0}, executionResult : {1}")
    @CsvSource(value = {"0, 5000", "1, 꽝", "2, 3000", "3, 꽝"})
    @DisplayName("한 플레이어의 인덱스에 해당하는 실행 결과 가져오기")
    void getOneExecutionResult(int resultPosition, String executionResult) {
        assertThat(gameResult.getOneExecutionResult(resultPosition, movedPositions)).isEqualTo(executionResult);
    }
    
    @Test
    @DisplayName("모든 플레이어의 인덱스에 해당하는 실행 결과 가져오기")
    void getAllExecutionResult() {
        assertThat(gameResult.getAllExecutionResult(movedPositions)).isEqualTo(List.of("5000", "꽝", "3000", "꽝"));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"aaaaa,bbb,c,d", "a,b,가,나"})
    @DisplayName("실행 결과 정상 입력 시 예외가 발생하지 않는다.")
    void normalInput(String inputExecutionResults) {
        assertThatNoException()
                .isThrownBy(() -> new GameResult(inputExecutionResults, playerNames));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa,bbb", "aaaaa,,bbb", ",aaa"})
    @DisplayName("실행 결과 글자 길이가 1~5를 벗어난 경우 예외가 발생한다.")
    void validateOutOfLength(String inputExecutionResults) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResult(inputExecutionResults, playerNames))
                .withMessage("각 상품의 글자 길이는 1~5입니다.");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,가,나", "aaaaa,cc,bbb"})
    @DisplayName("실행 결과 개수가 플레이어의 수와 다른 경우 예외가 발생한다.")
    void validateCount(String inputExecutionResults) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResult(inputExecutionResults, playerNames))
                .withMessage("실행 결과의 개수는 플레이어의 수가 같아야합니다.");
    }
}
