package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderPrinterTest {
    @Test
    @DisplayName("사다리 문자열 생성")
    void ladderToString() {
        Ladder ladder = new Ladder(5, 2, width1 -> List.of(true));
        String actual = LadderPrinter.from(ladder);
        String expected = "    |-----|\n".repeat(5);
        expected = expected.substring(0, expected.length() - 1);
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

}