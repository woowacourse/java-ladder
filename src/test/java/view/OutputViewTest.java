package view;

import domain.*;
import domain.ladder.Ladder;
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
    class PrintingLadderCase {
        @Test
        @DisplayName("주어진 이름과 사다리, 도착 결과를 바탕으로 사다리를 만든다.")
        void givenNamesAndLadder_thenReturnsLadderMessage() {
            List<String> playerNames = List.of("참가자1", "참가자2");
            List<String> goalNames = List.of("골", "탈락");
            Ladder ladder = makeLadder(playerNames, goalNames, true, false);
            ladder.build(Height.of(2));

            outputView.printLadder(playerNames.iterator(), ladder.findAllConnectedConditions(), goalNames.iterator());

            assertThat(messagePrinter.getMessages())
                    .containsExactly(
                            "실행결과",
                            "참가자1 참가자2 ",
                            "|-----|",
                            "|     |",
                            "골     탈락   "
                    );
        }

        @Test
        @DisplayName("옆으로 길게 뻗은 사다리도 만들 수 있다.")
        void givenMultipleNamesAndLadder_thenReturnsLadderMessage() {

            List<String> playerNames = List.of("참가자1", "참가자2", "참가자3", "참가자4");
            List<String> goalNames = List.of("골", "탈락", "40000", "3000");
            Ladder ladder = makeLadder(playerNames, goalNames, true, true, false, true, false);
            ladder.build(Height.of(2));

            outputView.printLadder(playerNames.iterator(), ladder.findAllConnectedConditions(), goalNames.iterator());

            assertThat(messagePrinter.getMessages())
                    .containsExactly(
                            "실행결과",
                            "참가자1 참가자2 참가자3 참가자4 ",
                            "|-----|     |-----|",
                            "|     |-----|     |",
                            "골     탈락    40000 3000 "
                    );
        }

        private Ladder makeLadder(List<String> playerNames, List<String> goalNames, boolean... connectedCondition) {
            Players players = Players.ofNames(playerNames);
            Goals goals = Goals.of(players.count(), goalNames);
            return Ladder.of(new FixBooleanGenerator(connectedCondition), players, goals);
        }
    }

    @Nested
    @DisplayName("사다리 결과를 출력하기 위해 ")
    class PrintingResultCase {
        @Test
        @DisplayName("참석자 이름, 도착지 이름이 주어지면 결과 메시지를 출력한다.")
        void givenParticipantNameAndGoalName_thenReturnsMessage() {
            String name = "참석자1";
            String goal = "도착지1";
            outputView.printResult(name, goal);

            assertThat(messagePrinter.getMessages())
                    .containsExactly("참석자1 : 도착지1");
        }
    }
}