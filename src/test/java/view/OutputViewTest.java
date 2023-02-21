package view;

import domain.Height;
import domain.ladder.Ladder;
import domain.Names;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.FixBooleanGenerator;
import util.MockMessagePrinter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("출력 메시지는")
class OutputViewTest {

    private OutputView outputView;
    private MockMessagePrinter messagePrinter;

    @BeforeEach
    void setUp() {
        messagePrinter = new MockMessagePrinter();
        outputView = new OutputView(messagePrinter);
    }

    @Nested
    @DisplayName("사다리 결과를 출력할 때 ")
    class PrintingResultCase {
        @Test
        @DisplayName("주어진 이름과 사다리를 바탕으로 사다리를 만든다.")
        void givenNamesAndLadder_thenReturnsLadderMessage() {
            Names names = Names.ofValues(List.of("참가자1", "참가자2"));
            Ladder ladder = Ladder.of(new FixBooleanGenerator(true, false));
            ladder.build(Height.of(2), 2);

            outputView.printResult(names, ladder);

            assertThat(messagePrinter.getMessages())
                    .containsExactly(
                            "실행결과",
                            "참가자1 참가자2 ",
                            "|----|",
                            "|    |"
                    );
        }

        @Test
        @DisplayName("옆으로 길게 뻗은 사다리도 만들 수 있다.")
        void givenMultipleNamesAndLadder_thenReturnsLadderMessage() {
            Names names = Names.ofValues(List.of("참가자1", "참가자2", "참가자3", "참가자4"));
            Ladder ladder = Ladder.of(
                    new FixBooleanGenerator(true, true, false, true, false)
            );
            ladder.build(Height.of(2), 4);

            outputView.printResult(names, ladder);

            assertThat(messagePrinter.getMessages())
                    .containsExactly(
                            "실행결과",
                            "참가자1 참가자2 참가자3 참가자4 ",
                            "|----|    |----|",
                            "|    |----|    |"
                    );
        }
    }
}