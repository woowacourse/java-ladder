package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @ParameterizedTest(name = "resultPosition : {0}, executionResult : {1}")
    @CsvSource(value = {"0, 5000", "1, 꽝", "2, 3000", "3, 꽝"})
    @DisplayName("한 플레이어의 인덱스에 해당하는 실행 결과 가져오기")
    void getExecutionResult(int resultPosition, String executionResult) {
        GameResult gameResult = new GameResult(List.of(1,0,3,2), List.of("꽝", "5000", "꽝", "3000"));
        assertThat(gameResult.getExecutionResult(resultPosition)).isEqualTo(executionResult);
    }
}
