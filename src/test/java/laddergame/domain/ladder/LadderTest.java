package laddergame.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.ladder.line.LineWidth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderTest {

    private static final LineWidth DEFAULT_WIDTH = new LineWidth(3);
    private static final LadderHeight DEFAULT_HEIGHT = new LadderHeight(3);

    @Test
    @DisplayName("결과의 개수가 라인의 폭이 같지 않으면 예외를 던진다.")
    void should_ThrowException_When_DestinationSizeNotEqualWithPlayersCount() {
        List<Result> wrongResults = List.of(new Result("실패"));
        assertThatThrownBy(() -> Ladder.of(DEFAULT_WIDTH, DEFAULT_HEIGHT, wrongResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과의 개수와 라인의 폭(3)은 일치해야 합니다.");
    }

    @Test
    @DisplayName("출발지에 따른 종착지 위치의 결과를 반환한다.")
    void should_ReturnResult_When_GivenStartIndex() {
        List<Result> results = List.of(new Result("a"), new Result("b"), new Result("c"));
        Ladder ladder = Ladder.of(DEFAULT_WIDTH, DEFAULT_HEIGHT, results);

        List<Result> foundResults = new ArrayList<>();
        for (int i = 0; i < DEFAULT_WIDTH.get(); i++) {
            foundResults.add(ladder.findResultByStartIndex(i));
        }

        assertThat(foundResults).containsExactlyInAnyOrderElementsOf(results);
    }
}
