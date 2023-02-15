package controller;

import domain.Participants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validate.ErrorMessage;
import view.InputView;

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
        Assertions.assertThat(participants.getParticipantsName()).containsExactly("split", "jamie");
    }

    @DisplayName("컨트롤러는 잘못된 입력으로 Participant를 생성 시 오류를 던진다.")
    @Test
    void makeParticipantsFail() {
        setInput("abcdef\nsplit,jamie");
        setOutput();
        RadderGameController radderGameController = new RadderGameController();
        Participants participants = radderGameController.makeParticipants(new InputView());
        Assertions.assertThat(byteArrayOutputStream.toString()).contains(
            ErrorMessage.INVALID_PERSON_NAME.getMessage()
        );
    }
}
