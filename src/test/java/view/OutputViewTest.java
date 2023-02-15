package view;

import domain.Map;
import domain.Participants;
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

    @DisplayName("첫 번째 사다리의 모든 라인이 연결된 경우에 대한 출력.")
    @Test
    void printMapFirstLadderAllConnected() {
        setOutput();
        OutputView outputView = new OutputView();
        Participants participants = new Participants("jamie,split,pobi");
        Map map = new Map("4", participants.getParticipantCount());
        map.generate(() -> true);
        outputView.printMap(participants, map);
        Assertions.assertThat(byteArrayOutputStream.toString()).isEqualTo("jamie split  pobi \n"
            + "    |-----|     |\n"
            + "    |-----|     |\n"
            + "    |-----|     |\n"
            + "    |-----|     |\n\n");
    }

    @DisplayName("모든 사다리의 라인이 연결되어 있지 않은 경우에 대한 출력")
    @Test
    void printMapAllLaddersNotConnected() {
        setOutput();
        OutputView outputView = new OutputView();
        Participants participants = new Participants("jamie,split,pobi");
        Map map = new Map("4", participants.getParticipantCount());
        map.generate(() -> false);
        outputView.printMap(participants, map);
        Assertions.assertThat(byteArrayOutputStream.toString()).isEqualTo("jamie split  pobi \n"
            + "    |     |     |\n"
            + "    |     |     |\n"
            + "    |     |     |\n"
            + "    |     |     |\n\n");
    }
}
