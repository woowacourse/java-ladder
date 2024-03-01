package domain.game;

import domain.ladder.LineNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderDestinationsTest {

    @DisplayName("게임 결과들을 입력하면 인스턴스를 생성한다.")
    @Test
    void 게임_결과들_인스턴스_생성() {
        // Given
        List<String> inputGameResults = List.of("꽝", "5000", "꽝", "3000");

        // When
        LadderDestinations ladderDestinations = LadderDestinations.of(inputGameResults);

        // Then
        assertThat(ladderDestinations).isNotNull();
    }

    @DisplayName("게임 결과 문자열 리스트를 반환한다.")
    @Test
    void 게임_결과_문자열_리스트_반환() {
        // Given
        List<String> inputGameResults = List.of("꽝", "5000", "꽝", "3000");
        LadderDestinations ladderDestinations = LadderDestinations.of(inputGameResults);

        // When
        List<String> gameResultValues = ladderDestinations.getGameResults();

        // Then
        assertThat(gameResultValues).contains("꽝", "5000", "꽝", "3000");
    }

    @DisplayName("입력된 라인 번호에 존재하는 게임 결과를 찾아 반환한다.")
    @Test
    void 입력_라인_번호_일치_게임_결과_반환() {
        // Given
        LadderDestinations ladderDestinations = LadderDestinations.of(List.of("꽝", "5000", "꽝", "3000"));
        LineNumber inputLineNumber = new LineNumber(2);

        // When
        LadderDestination ladderDestination = ladderDestinations.findGameResult(inputLineNumber);

        // Then
        assertThat(ladderDestination.getDescription()).isEqualTo("5000");
    }
}
