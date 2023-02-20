package ladder.controller;

import ladder.domain.ladder.Line;
import ladder.domain.valueGenerator.MockValueGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.ladder.Bar.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderControllerTest {

    private LadderController ladderController;

    @Test
    @DisplayName("사다리 컨트롤러 정상 테스트")
    void ladderControllerTest() {
        MockInputView inputView = new MockInputView(List.of(List.of("a","b","c","d")), List.of(3));
        MockResultView resultView = new MockOutputView();
        MockValueGenerator valueGenerator = new MockValueGenerator(List.of(3), List.of(false, true, false));
        ladderController = new LadderController(inputView, resultView, valueGenerator);
        ladderController.run();
        List<Line> resultLadder = resultView.getLadder();

        assertThat(resultLadder.get(0).getLine()).isEqualTo(List.of(UNMOVABLE_BAR, MOVABLE_BAR, UNMOVABLE_BAR));
        assertThat(resultLadder.get(1).getLine()).isEqualTo(List.of(UNMOVABLE_BAR, MOVABLE_BAR, UNMOVABLE_BAR));
        assertThat(resultLadder.get(2).getLine()).isEqualTo(List.of(UNMOVABLE_BAR, MOVABLE_BAR, UNMOVABLE_BAR));
    }

    @Test
    @DisplayName("사다리 컨트롤러 예외 후 정상 테스트")
    void ladderControllerExceptionTest() {
        MockInputView inputView = new MockInputView(
                List.of(List.of("a","b","c","c"), List.of("aaaaaa","b","c","d"), List.of("a","b","c","d")),
                List.of(0, 3));
        MockResultView resultView = new MockOutputView();
        MockValueGenerator valueGenerator = new MockValueGenerator(List.of(3), List.of(false, true, false));
        ladderController = new LadderController(inputView, resultView, valueGenerator);
        ladderController.run();
        List<Line> resultLadder = resultView.getLadder();
        boolean resultError = resultView.hasError();

        assertThat(resultError).isTrue();
        assertThat(resultLadder.get(0).getLine()).isEqualTo(List.of(UNMOVABLE_BAR, MOVABLE_BAR, UNMOVABLE_BAR));
        assertThat(resultLadder.get(1).getLine()).isEqualTo(List.of(UNMOVABLE_BAR, MOVABLE_BAR, UNMOVABLE_BAR));
        assertThat(resultLadder.get(2).getLine()).isEqualTo(List.of(UNMOVABLE_BAR, MOVABLE_BAR, UNMOVABLE_BAR));\
    }

}
