package controller;

import domain.Ladder;
import domain.Participants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomBooleanGenerator;
import view.input.ErrorMessage;
import view.input.InputView;
import view.output.OutputView;

class RadderGameControllerTest {

    private ByteArrayOutputStream byteArrayOutputStream;

    void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    void setOutput() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @DisplayName("컨트롤러는 인풋뷰를 사용해 Participant를 정상적으로 생성한다.")
    @Test
    void makeParticipantsSuccess() {
        setInput("split,jamie");
        RadderGameController radderGameController = new RadderGameController();
        Participants participants = radderGameController.makeParticipants(new InputView());
        Assertions.assertThat(participants.getParticipantsNames()).containsExactly("split", "jamie");
    }

    @DisplayName("컨트롤러는 잘못된 입력으로 Participant를 생성 시 오류를 던진다.")
    @Test
    void makeParticipantsFail() {
        setInput("abcdef,abcde\nsplit,jamie");
        setOutput();
        RadderGameController radderGameController = new RadderGameController();
        radderGameController.makeParticipants(new InputView());
        Assertions.assertThat(byteArrayOutputStream.toString()).contains(
            ErrorMessage.INVALID_PERSON_NAME.getMessage()
        );
    }

    @DisplayName("컨트롤러는 인풋뷰를 사용해 사다리를 정상적으로 생성한다.")
    @Test
    void makeLadderSuccess() {
        setInput("3");
        RadderGameController radderGameController = new RadderGameController();
        Participants participants = new Participants("split,jamie,pobi");
        Ladder ladder = radderGameController.makeLadder(new InputView(), participants, () -> true);
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(3);
        Assertions.assertThat(ladder.getLines().get(0).getStatus()).containsExactly(true, false);
        Assertions.assertThat(ladder.getLines().get(1).getStatus()).containsExactly(true, false);
        Assertions.assertThat(ladder.getLines().get(2).getStatus()).containsExactly(true, false);
    }

    @DisplayName("컨트롤러는 잘못된 입력으로 사다리 생성시 오류를 던진다.")
    @Test
    void makeLadderFail() {
        setInput("11\n3");
        setOutput();
        RadderGameController radderGameController = new RadderGameController();
        Participants participants = new Participants("split,jamie,pobi");
        radderGameController.makeLadder(new InputView(), participants, new RandomBooleanGenerator());
        Assertions.assertThat(byteArrayOutputStream.toString()).contains(
            ErrorMessage.INVALID_LADDER_HEIGHT.getMessage()
        );
    }

    @DisplayName("컨틀롤러는 아웃풋뷰를 통해 맵을 출력한다.")
    @Test
    void printLadder() {
        setOutput();
        RadderGameController radderGameController = new RadderGameController();
        Participants participants = new Participants("jamie,split,pobi");
        Ladder map = new Ladder("4", participants.getParticipantCount());
        map.generate(() -> true);
        radderGameController.showLadder(new OutputView(), participants, map);
        Assertions.assertThat(byteArrayOutputStream.toString()).isEqualTo("\n실행결과\n\n"
            + "jamie split  pobi \n"
            + "    |-----|     |\n"
            + "    |-----|     |\n"
            + "    |-----|     |\n"
            + "    |-----|     |\n");

    }
}
