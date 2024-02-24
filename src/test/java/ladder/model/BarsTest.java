package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BarsTest {
    @Test
    @DisplayName("사다리 실행 플레이어 결과를 계산한다.")
    void calculatePlayerResultTest() {
        Bars bars = Bars.from(List.of(0, 1, 0, 2));
        List<String> ladderResult = List.of("a", "b", "c", "d");

        List<String> actualChangedLadderResult = bars.calculateChangedLadderResult(ladderResult);
        List<String> expectedChangedLadderResult = List.of("c", "b", "d", "a");

        assertThat(actualChangedLadderResult).isEqualTo(expectedChangedLadderResult);
    }
}
