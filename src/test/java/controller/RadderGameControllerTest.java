package controller;

import domain.Map;
import domain.Participants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomBooleanGenerator;
import validate.ErrorMessage;
import view.InputView;
import view.OutputView;

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

    @DisplayName("컨트롤러는 인풋뷰를 사용해 Map을 정상적으로 생성한다.")
    @Test
    void makeMapSuccess() {
        setInput("3");
        RadderGameController radderGameController = new RadderGameController();
        Participants participants = new Participants("split,jamie,pobi");
        Map map = radderGameController.makeMap(new InputView(), participants, () -> true);
        Assertions.assertThat(map.getLadders().get(0).getStatus()).containsExactly(true, true, true);
        Assertions.assertThat(map.getLadders().get(1).getStatus()).containsExactly(false, false, false);
    }

    @DisplayName("컨트롤러는 잘못된 입력으로 Map 생성시 오류를 던진다.")
    @Test
    void makeMapFail() {
        setInput("11\n3");
        setOutput();
        RadderGameController radderGameController = new RadderGameController();
        Participants participants = new Participants("split,jamie,pobi");
        radderGameController.makeMap(new InputView(), participants, new RandomBooleanGenerator());
        Assertions.assertThat(byteArrayOutputStream.toString()).contains(
            ErrorMessage.INVALID_LADDER_HEIGHT.getMessage()
        );
    }

    @DisplayName("컨틀롤러는 아웃풋뷰를 통해 맵을 출력한다.")
    @Test
    void printMap() {
        setOutput();
        RadderGameController radderGameController = new RadderGameController();
        Participants participants = new Participants("jamie,split,pobi");
        Map map = new Map("4", participants.getParticipantCount());
        map.generate(() -> true);
        radderGameController.showMap(new OutputView(), participants, map);
        Assertions.assertThat(byteArrayOutputStream.toString()).isEqualTo("\n실행결과\n\n"
            + "jamie split  pobi \n"
            + "    |-----|     |\n"
            + "    |-----|     |\n"
            + "    |-----|     |\n"
            + "    |-----|     |\n");

    }
}
