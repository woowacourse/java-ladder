package view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderPrinterTest {
    @Test
    @DisplayName("사다리 문자열 생성")
    void ladderToString() {
        List<List<Boolean>> rawLadder = makeRawLadder();
        String actual = LadderPrinter.from(rawLadder);
        String expected = "    |     |-----|\n".repeat(5);
        expected = expected.substring(0, expected.length() - 1);
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    private static List<List<Boolean>> makeRawLadder() {
        return List.of(
                List.of(false, true),
                List.of(false, true),
                List.of(false, true),
                List.of(false, true),
                List.of(false, true)
        );
    }

}