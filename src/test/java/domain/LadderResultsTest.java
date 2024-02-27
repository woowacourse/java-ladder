package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestLineItemGenerator;
import view.LineItem;
import java.util.List;
import java.util.stream.Stream;

class LadderResultsTest {

    private static Stream<Arguments> LadderResults() {
        return Stream.of(
                Arguments.arguments(List.of("냥", "2000", "5000")),
                Arguments.arguments(List.of("꽝", "-2000", "5000"))
        );
    }

    @DisplayName("실행 결과가 꽝 또는 자연수가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("LadderResults")
    void occurExceptionIfLadderResultsIsNotLoseOrNaturalNumber(List<String> ladderResults) {
        int columnLength = 3;
        assertThatThrownBy(() -> new LadderResults(ladderResults, columnLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 꽝 또는 자연수만 입력 가능합니다.");
    }

    @DisplayName("실행 결과 개수가 참여자 수와 다른 경우 예외가 발생한다.")
    @Test
    void occurExceptionIfLadderResultsIsInvalidLength() {
        int columnLength = 3;
        assertThatThrownBy(() -> new LadderResults(List.of("꽝", "2000", "3000", "꽝"), columnLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과 개수는 참여자 수와 일치해야 합니다.");
    }

    @DisplayName("현재 위치의 사다리 실행 결과를 반환한다.")
    @Test
    void returnLadderResultByCurrentPosition() {
        // given
        int columnLength = 4;
        int position = 0;
        TestLineItemGenerator lineItemGenerator = new TestLineItemGenerator(LineItem.CONNECTED);
        Ladder ladder = Ladder.of(new Height("5"), columnLength, lineItemGenerator);
        ladder.playLadderGame(position);
        LadderResults ladderResults = new LadderResults(List.of("꽝", "5000", "꽝", "3000"), columnLength);

        // when
        String result = ladderResults.findLadderResultByPosition(position);

        // then
        assertThat(result).isEqualTo(ladderResults.getLadderResults().get(2));
    }
}
