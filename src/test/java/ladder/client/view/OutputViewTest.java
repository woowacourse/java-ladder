package ladder.client.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class OutputViewTest {

    private final ByteArrayOutputStream printResult = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView();

    @BeforeEach
    void setSystemOut() {
        printResult.reset();
        System.setOut(new PrintStream(printResult));
    }

    @AfterEach
    void restoreSystemOut() {
        System.setOut(System.out);
    }

    @Test
    void 사다리_타이틀을_출력한다() {
        //when
        outputView.printLadderTitle();

        //then
        assertThat(printResult)
                .hasToString("사다리 결과" + System.lineSeparator()
                        + System.lineSeparator());
    }

    @Test
    void 사다리_행들을_출력한다() {
        //given
        List<List<Boolean>> ladderRows = List.of(
                List.of(false, false),
                List.of(true, false));

        //when
        outputView.printLadderRows(ladderRows);

        //then
        assertThat(printResult)
                .hasToString("    |     |     " + System.lineSeparator()
                        + "    |-----|     " + System.lineSeparator());
    }

    @Test
    void 사다리_플레이어를_출력한다() {
        //given
        List<String> playerNames = List.of("a", "b");

        //when
        outputView.printPlayerNames(playerNames);

        //then
        assertThat(printResult)
                .hasToString("a     b     " + System.lineSeparator());
    }

    @Test
    void 결과_하나_출력() {
        outputView.printResult("book");
        assertThat(printResult)
                .hasToString("실행 결과" + System.lineSeparator()
                        + "book" + System.lineSeparator());
    }

    @Test
    void 결과_하나_출력시_없는_사용자이면_없다는_메시지_출력() {
        outputView.printResult(null);
        assertThat(printResult)
                .hasToString("실행 결과" + System.lineSeparator()
                        + "결과가 없는 사람입니다" + System.lineSeparator());
    }

    @Test
    void 결과_여러개_출력() {
        outputView.printResults(Map.of("name", "book"));
        assertThat(printResult)
                .hasToString("실행 결과" + System.lineSeparator() +
                        "name : book" + System.lineSeparator());
    }
}
