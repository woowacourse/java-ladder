package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultsTest {

    @DisplayName("index파라미터를 통해 해당 index도착지의 실행결과값을 조회할 수 있다.")
    @Test
    void findByDestinationPosition() {
        final WinningResult winningResult = new WinningResult("꽝");
        final WinningResult winningResult1 = new WinningResult("당첨");
        final WinningResults winningResults = new WinningResults(List.of(winningResult, winningResult1));

        assertThat(winningResults.findByDestinationPosition(1).getWinningResult()).isEqualTo("당첨");
    }
}
