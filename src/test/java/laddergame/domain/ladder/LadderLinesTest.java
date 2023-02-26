package laddergame.domain.ladder;

import static laddergame.domain.ladder.line.StepPoint.EXIST;
import static laddergame.domain.ladder.line.StepPoint.NONE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import laddergame.domain.generator.RandomStepPointGenerator;
import laddergame.domain.generator.StepPointGenerator;
import laddergame.domain.ladder.line.LineWidth;
import laddergame.domain.ladder.line.StepPoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderLinesTest {

    @Test
    @DisplayName("사다리는 주어진 높이만큼의 라인을 가진다.")
    void should_HasLinesNumber_Of_GivenHeight() {
        int height = 3;
        
        LadderLines ladderLines = LadderLines.of(new RandomStepPointGenerator(), new LineWidth(3),
                new LadderHeight(height));

        assertThat(ladderLines.height()).isEqualTo(height);
    }

    @Test
    @DisplayName("출발지에 따른 종착지의 위치를 반환한다.")
    void should_ReturnDestinationIndex_When_GivenStartIndex() {
        List<String> results = List.of("a", "b", "c", "d");
        Queue<StepPoint> stepPoints = new LinkedList<>(List.of(
                EXIST, NONE, EXIST,
                NONE, EXIST, NONE
        ));

        StepPointGenerator mockedGenerator = new MockedPointGenerator(stepPoints);
        LadderLines ladderLines = LadderLines.of(mockedGenerator, new LineWidth(results.size()), new LadderHeight(2));

        assertThat(ladderLines.findDestinationIndex(0)).isEqualTo(2);
        assertThat(ladderLines.findDestinationIndex(1)).isEqualTo(0);
        assertThat(ladderLines.findDestinationIndex(2)).isEqualTo(3);
        assertThat(ladderLines.findDestinationIndex(3)).isEqualTo(1);
    }
}
