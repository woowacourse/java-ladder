package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RowStringMakerTest {
    @Test
    @DisplayName("다리 1열 문자열 생성")
    void testLadderRow() {
        final List<Boolean> bridges = List.of(true, false, false, true);

        final String actual = RowStringMaker.make(new Row(bridges));
        final String expected = "    |-----|     |     |-----|";

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}