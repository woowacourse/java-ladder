package view;

import domain.Ladder;
import domain.Participants;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.output.OutputView;

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
        Ladder ladder = new Ladder("4", participants.getParticipantCount());
        ladder.generate(() -> true);
        outputView.printMap(participants, ladder);
        Assertions.assertThat(byteArrayOutputStream.toString()).isEqualTo("\n실행결과\n\n"
            + "jamie split  pobi \n"
            + "    |-----|     |\n"
            + "    |-----|     |\n"
            + "    |-----|     |\n"
            + "    |-----|     |\n");
    }

    @DisplayName("모든 라인이 연결되어 있는 않은 경우에 대한 출력.")
    @Test
    void printLadderAllLinesNotConnected() {
        setOutput();
        OutputView outputView = new OutputView();
        Participants participants = new Participants("jamie,split,pobi");
        Ladder ladder = new Ladder("4", participants.getParticipantCount());
        ladder.generate(() -> false);
        outputView.printMap(participants, ladder);
        Assertions.assertThat(byteArrayOutputStream.toString()).isEqualTo("\n실행결과\n\n"
            + "jamie split  pobi \n"
            + "    |     |     |\n"
            + "    |     |     |\n"
            + "    |     |     |\n"
            + "    |     |     |\n");
    }
}
