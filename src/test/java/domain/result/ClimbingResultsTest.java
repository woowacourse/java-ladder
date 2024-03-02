package domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClimbingResultsTest {
    static ClimbingResults climbingResults;

    @BeforeAll
    static void initClimbingResults() {
        Map<String, String> results = new HashMap<>();
        results.put("a", "꽝");
        results.put("b", "당첨");
        results.put("c", "꽝");

        climbingResults = new ClimbingResults(results);
    }

    @Test
    @DisplayName("사다리 게임에 참여한 사람이 아닌 경우 예외가 발생한다")
    void createClimbingResultsFailNotPlayer() {
        assertThatThrownBy(() -> climbingResults.findResultByPlayerName("kaki"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ClimbingResults.NOT_PARTICIPATION_PLAYER);
    }

    @Test
    @DisplayName("입력한 참가자의 사다리 타기 실행 결과를 보여준다.")
    void findResultByPlayerNameTest() {
        assertAll(
                () -> assertThat(climbingResults.findResultByPlayerName("a")).isEqualTo("꽝"),
                () -> assertThat(climbingResults.findResultByPlayerName("b")).isEqualTo("당첨"),
                () -> assertThat(climbingResults.findResultByPlayerName("c")).isEqualTo("꽝")
        );
    }
}
