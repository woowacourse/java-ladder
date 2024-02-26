package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameResultsTest {

    @DisplayName("게임 결과들을 입력하면 인스턴스를 생성한다.")
    @Test
    void 게임_결과들_인스턴스_생성() {
        // Given
        final List<String> inputGameResults = List.of("꽝", "5000", "꽝", "3000");

        // When
        GameResults gameResults = GameResults.of(inputGameResults);

        // Then
        Assertions.assertThat(gameResults).isNotNull();
    }
}
