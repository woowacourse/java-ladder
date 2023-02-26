package ladder.client.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import ladder.domain.dto.LadderInfoDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class OutputViewTest {

    private final ByteArrayOutputStream printResult = new ByteArrayOutputStream();

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
    void 사다리_결과를_출력한다() {
        //given
        LadderInfoDto ladderInfoDto = new LadderInfoDto(
                List.of("a", "b"),
                List.of(
                        List.of(false, false),
                        List.of(true, false)),
                List.of("c", "d"));

        //when
        OutputView.printLadder(ladderInfoDto);

        //then
        assertThat(printResult)
                .hasToString("사다리 결과" + System.lineSeparator()
                        + System.lineSeparator()
                        + "a     b     " + System.lineSeparator()
                        + "    |     |     " + System.lineSeparator()
                        + "    |-----|     " + System.lineSeparator()
                        + "c     d     " + System.lineSeparator());
    }

    @Test
    void 결과_하나_출력() {
        OutputView.printResult("book");
        assertThat(printResult)
                .hasToString("실행 결과" + System.lineSeparator()
                        + "book" + System.lineSeparator());
    }

    @Test
    void 결과_하나_출력시_없는_사용자이면_없다는_메시지_출력() {
        OutputView.printResult(null);
        assertThat(printResult)
                .hasToString("실행 결과" + System.lineSeparator()
                        + "결과가 없는 사람입니다" + System.lineSeparator());
    }

    @Test
    void 결과_여러개_출력() {
        OutputView.printResults(Map.of("name", "book"));
        assertThat(printResult)
                .hasToString("실행 결과" + System.lineSeparator() +
                        "name : book" + System.lineSeparator());
    }
}
