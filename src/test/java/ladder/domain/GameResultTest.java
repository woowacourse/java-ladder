package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @DisplayName("게임 결과 내용과 라인 번호를 입력하면 인스턴스를 생성한다.")
    @Test
    void 게임_결과_내용_라인_번호_인스턴스_생성() {
        // Given
        final String gameResultDescription = "1,000원";
        final int lineNumber = 1;

        // When
        GameResult gameResult = GameResult.of(gameResultDescription, lineNumber);

        // Then
        assertThat(gameResult).isNotNull();
    }

    @DisplayName("입력된 라인 번호와 결과가 존재하는 라인 번호가 같으면 true를 반환한다.")
    @Test
    void 결과_라인_번호와_같은지_체크() {
        // Given
        final GameResult gameResult = GameResult.of("꽝", 3);
        final LineNumber inputLineNumber = new LineNumber(3);

        // When
        boolean isEqual = gameResult.isEqualLineNumber(inputLineNumber);

        // Then
        assertThat(isEqual).isTrue();
    }
}
