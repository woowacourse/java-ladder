package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    GameResult gameResult;
    
    @BeforeEach
    void setUp() {
        gameResult = new GameResult(List.of(1,0,3,2), List.of("꽝", "5000", "꽝", "3000"));
    }
    
    @ParameterizedTest(name = "resultPosition : {0}, executionResult : {1}")
    @CsvSource(value = {"0, 5000", "1, 꽝", "2, 3000", "3, 꽝"})
    @DisplayName("한 플레이어의 인덱스에 해당하는 실행 결과 가져오기")
    void getOneExecutionResult(int resultPosition, String executionResult) {
        assertThat(gameResult.getOneExecutionResult(resultPosition)).isEqualTo(executionResult);
    }
    
    @Test
    @DisplayName("모든 플레이어의 인덱스에 해당하는 실행 결과 가져오기")
    void getAllExecutionResult() {
        assertThat(gameResult.getAllExecutionResult()).isEqualTo(List.of("5000", "꽝", "3000", "꽝"));
    }
}
