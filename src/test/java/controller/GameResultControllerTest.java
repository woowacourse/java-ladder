package controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import exception.ErrorMessage;
import util.TestGenerator;
import view.InputView;
import view.OutputView;

class GameResultControllerTest {

    private ByteArrayOutputStream byteArrayOutputStream;
    private static TestGenerator testGenerator;

    @BeforeEach
    void before() {
        List<Boolean> generateStatus = List.of(
                true, true,
                false, true,
                true, false,
                false, true,
                true, true
        );

        testGenerator = new TestGenerator();
        testGenerator.addAll(generateStatus);
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
        LadderGameController ladderGameController =
                new LadderGameController(new InputView(new Scanner(System.in)),
                new OutputView(), testGenerator);

        setOutput();
        ladderGameController.play();
        Assertions.assertThat(byteArrayOutputStream.toString())
                  .contains(
                          "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n"
                          , "\n최대 사다리 높이는 몇 개인가요?\n"
                          , "\n사다리 결과\n"
                          , "\n"
                          , " pobi honux crong    jk \n"
                          , "    |-----|     |-----|\n"
                          , "    |     |-----|     |\n"
                          , "    |-----|     |     |\n"
                          , "    |     |-----|     |\n"
                          , "    |-----|     |-----|\n"
                          , "    a     b     c     d \n"
                          , "실행 결과\n"
                          , "pobi : a\n"
                          , "honux : d\n"
                          , "crong : c\n"
                          , "jk : b\n");
    }

    @DisplayName("컨트롤러는 잘못된 입력으로 Participant를 생성 시 오류를 던진다.")
    @Test
    void makeParticipantsFail() {
        setInput("abcdef,abcde\nsplit,jamie\na,b\n5\nall");
        LadderGameController ladderGameController =
                new LadderGameController(new InputView(new Scanner(System.in)),
                new OutputView(), testGenerator);

        setOutput();
        ladderGameController.play();
        Assertions.assertThat(byteArrayOutputStream.toString())
                  .contains(ErrorMessage.INVALID_PERSON_NAME.getMessage());
    }

    @DisplayName("컨트롤러는 잘못된 입력으로 Results 생성 시 오류를 던진다.")
    @Test
    void makeResultsFail() {
        setInput("split,jamie\na,b,c\na,b\n5\nall");
        LadderGameController ladderGameController =
                new LadderGameController(new InputView(new Scanner(System.in)),
                new OutputView(), testGenerator);

        setOutput();
        ladderGameController.play();
        Assertions.assertThat(byteArrayOutputStream.toString())
                  .contains(ErrorMessage.INVALID_RESULT_COUNT.getMessage());
    }

    @DisplayName("컨트롤러는 잘못된 입력으로 사다리 생성시 오류를 던진다.")
    @Test
    void makeLadderFail() {
        setInput("split,jamie,pobi\na,b,c\n11\n3\nall");
        LadderGameController ladderGameController =
                new LadderGameController(new InputView(new Scanner(System.in)),
                new OutputView(), testGenerator);

        setOutput();
        ladderGameController.play();
        Assertions.assertThat(byteArrayOutputStream.toString())
                  .contains(ErrorMessage.INVALID_LADDER_HEIGHT.getMessage());
    }
}
