package ladder.client.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import ladder.domain.dto.LadderInfoDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class OutputViewTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        outContent.reset();
        System.setOut(new PrintStream(outContent));
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
        assertThat(outContent)
                .hasToString("사다리 결과" + System.lineSeparator()
                        + System.lineSeparator()
                        + "a     b     " + System.lineSeparator()
                        + "    |     |     " + System.lineSeparator()
                        + "    |-----|     " + System.lineSeparator()
                        + "c     d     " + System.lineSeparator());
    }

    @AfterEach
    void restoreSystemOut() {
        System.setOut(System.out);
    }
}
