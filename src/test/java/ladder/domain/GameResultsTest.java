package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {

    @DisplayName("게임 결과들을 입력하면 인스턴스를 생성한다.")
    @Test
    void 게임_결과들_인스턴스_생성() {
        // Given
        final List<String> inputGameResults = List.of("꽝", "5000", "꽝", "3000");

        // When
        GameResults gameResults = GameResults.of(inputGameResults);

        // Then
        assertThat(gameResults).isNotNull();
    }

    @DisplayName("게임 결과 문자열 리스트를 반환한다.")
    @Test
    void 게임_결과_문자열_리스트_반환() {
        // Given
        final List<String> inputGameResults = List.of("꽝", "5000", "꽝", "3000");
        final GameResults gameResults = GameResults.of(inputGameResults);

        // When
        List<String> gameResultValues = gameResults.getGameResults();

        // Then
        assertThat(gameResultValues).contains("꽝", "5000", "꽝", "3000");
    }
}
