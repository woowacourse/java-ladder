package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BarsTest {
    @Test
    @DisplayName("사다리 실행 결과를 계산한다.")
    void calculateLadderResultTest() {
        Bars bars = new Bars(List.of(new Bar(0), new Bar(1), new Bar(0), new Bar(2)));
        Players players = Players.from(List.of("a", "b", "c", "d"));

        List<String> actualLadderResult = bars.calculateLadderResult(players);
        List<String> expectedLadderResult = List.of("c", "b", "d", "a");

        assertThat(actualLadderResult).isEqualTo(expectedLadderResult);
    }
}
