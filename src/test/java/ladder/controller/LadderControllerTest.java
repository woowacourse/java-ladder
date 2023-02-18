package ladder.controller;

import ladder.domain.valueGenerator.MockValueGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderControllerTest {

    private LadderController ladderController;

    @Test
    @DisplayName("사다리 컨트롤러 정상 테스트")
    void ladderControllerTest() {
        String input = "a,b,c,d,e,f" + System.lineSeparator() + "5";

        InputStream inputStream = new ByteArrayInputStream(input.getBytes(UTF_8));
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);

        new LadderController(new InputView(), new ResultView(), new MockValueGenerator()).run();
        assertThat(outputStream.toString())
                .contains("    a     b     c     d     e     f",
                        "실행결과",
                        "    |     |     |     |     |     |" + System.lineSeparator() +
                        "    |     |     |     |     |     |" + System.lineSeparator() +
                        "    |     |     |     |     |     |" + System.lineSeparator() +
                        "    |     |     |     |     |     |" + System.lineSeparator() +
                        "    |     |     |     |     |     |"
                        );
    }

    @Test
    @DisplayName("사다리 컨트롤러 예외 후 정상 테스트")
    void ladderControllerExceptionTest() {
        String input = "a,b,c,d,e,e" + System.lineSeparator() +
                "a" + System.lineSeparator() +
                "aaaaaa,b,c,d,e,e" + System.lineSeparator() +
                "a,b,c,d,e,f" + System.lineSeparator() +
                "j" + System.lineSeparator() +
                "5";

        InputStream inputStream = new ByteArrayInputStream(input.getBytes(UTF_8));
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);

        new LadderController(new InputView(), new ResultView(), new MockValueGenerator()).run();
        assertThat(outputStream.toString())
                .contains("    a     b     c     d     e     f",
                        "[ERROR]",
                        "실행결과",
                        "    |     |     |     |     |     |" + System.lineSeparator() +
                        "    |     |     |     |     |     |" + System.lineSeparator() +
                        "    |     |     |     |     |     |" + System.lineSeparator() +
                        "    |     |     |     |     |     |" + System.lineSeparator() +
                        "    |     |     |     |     |     |"
                );
    }

}
