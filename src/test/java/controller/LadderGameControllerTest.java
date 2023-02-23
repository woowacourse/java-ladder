package controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.input.ErrorMessage;
import view.input.InputView;
import view.output.OutputView;

class LadderGameControllerTest {

    private ByteArrayOutputStream byteArrayOutputStream;
    private LadderGameController ladderGameController;

    @BeforeEach
    void before() {
        ladderGameController = new LadderGameController();
    }

    void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    void setOutput() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @DisplayName("정삭적으로 사다리가 생성된다.")
    @Test
    void playSuccess() {
        setInput("pobi,honux,crong,jk\na,b,c,d\n5\nall\n");
        setOutput();
        ladderGameController.play(new InputView(), new OutputView(), () -> true);
        Assertions.assertThat(byteArrayOutputStream.toString())
                  .contains(
                          "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n"
                          , "\n최대 사다리 높이는 몇 개인가요?\n"
                          , "\n사다리 결과\n"
                          , "\n"
                          , " pobi honux crong    jk \n"
                          , "    |-----|     |-----|\n"
                          , "    |-----|     |-----|\n"
                          , "    |-----|     |-----|\n"
                          , "    |-----|     |-----|\n"
                          , "    |-----|     |-----|\n"
                          , "    a     b     c     d \n"
                          , "실행 결과\n"
                          , "pobi : b\n"
                          , "honux : a\n"
                          , "crong : d\n"
                          , "jk : c\n");
    }

    @DisplayName("컨트롤러는 잘못된 입력으로 Participant를 생성 시 오류를 던진다.")
    @Test
    void makeParticipantsFail() {
        setInput("abcdef,abcde\nsplit,jamie\na,b\n5\nall");
        setOutput();
        ladderGameController.play(new InputView(), new OutputView(), () -> true);
        Assertions.assertThat(byteArrayOutputStream.toString())
                  .contains(ErrorMessage.INVALID_PERSON_NAME.getMessage());
    }

    @DisplayName("컨트롤러는 잘못된 입력으로 Results 생성 시 오류를 던진다.")
    @Test
    void makeResultsFail() {
        setInput("split,jamie\na,b,c\na,b\n5\nall");
        setOutput();
        ladderGameController.play(new InputView(), new OutputView(), () -> true);
        Assertions.assertThat(byteArrayOutputStream.toString())
                  .contains(ErrorMessage.INVALID_RESULT_COUNT.getMessage());
    }

    @DisplayName("컨트롤러는 잘못된 입력으로 사다리 생성시 오류를 던진다.")
    @Test
    void makeLadderFail() {
        setInput("split,jamie,pobi\na,b,c\n11\n3\nall");
        setOutput();
        ladderGameController.play(new InputView(), new OutputView(), () -> true);
        Assertions.assertThat(byteArrayOutputStream.toString())
                  .contains(ErrorMessage.INVALID_LADDER_HEIGHT.getMessage());
    }
}
