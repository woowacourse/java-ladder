package view;

import domain.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private ByteArrayOutputStream byteArrayOutputStream;

    void setOutput() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @DisplayName("모든 라인의 첫번째가 연결되어 있는 경우에 대한 출력.")
    @Test
    void printLadderAllLinesFirstConnected() {
        setOutput();
        OutputView outputView = new OutputView();
        Participants participants = new Participants("jamie,split,pobi");
        Ladder ladder = new Ladder(
                new Height("4"), new Weight(participants.getParticipantCount()), () -> true);
        Results results = new Results("a,b,c", 3);
        LadderGame ladderGame = new LadderGame(participants, results, ladder);
        outputView.printLadder(ladderGame.getParticipants(), ladderGame.getLadder(),
                ladderGame.getResults());
        Assertions.assertThat(byteArrayOutputStream)
                  .hasToString("\n사다리 결과\n\n"
                          + "jamie split  pobi \n"
                          + "    |-----|     |\n"
                          + "    |-----|     |\n"
                          + "    |-----|     |\n"
                          + "    |-----|     |\n"
                          + "    a     b     c \n");
    }

    @DisplayName("모든 라인이 연결되어 있는 않은 경우에 대한 출력.")
    @Test
    void printLadderAllLinesNotConnected() {
        setOutput();
        OutputView outputView = new OutputView();
        Participants participants = new Participants("jamie,split,pobi");
        Ladder ladder = new Ladder(
                new Height("4"), new Weight(participants.getParticipantCount()), () -> false);
        Results results = new Results("a,b,c", 3);
        LadderGame ladderGame = new LadderGame(participants, results, ladder);
        outputView.printLadder(ladderGame.getParticipants(), ladderGame.getLadder(),
                ladderGame.getResults());
        Assertions.assertThat(byteArrayOutputStream)
                  .hasToString("\n사다리 결과\n\n"
                          + "jamie split  pobi \n"
                          + "    |     |     |\n"
                          + "    |     |     |\n"
                          + "    |     |     |\n"
                          + "    |     |     |\n"
                          + "    a     b     c \n");
    }
}
