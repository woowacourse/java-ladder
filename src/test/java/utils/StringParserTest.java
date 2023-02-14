package utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {
    @Test
    @DisplayName("콤마를 기준으로 사람이름을 분리한다.")
    void splitByCommaTest() {
        String input = "pobi,honux,crong,jk";

        List<String> strings = StringParser.splitByComma(input);

        assertThat(strings).containsExactly("pobi", "honux", "crong", "jk");
    }

    @Test
    @DisplayName("콤마를 기준으로 사람이름을 분리한다.")
    void splitByCommaEdgeCaseTest() {
        String input = "pobi,,,";

        List<String> strings = StringParser.splitByComma(input);

        assertThat(strings).containsExactly("pobi", "", "", "");
    }

    @Test
    @DisplayName("문자열을 int로 변환한다.")
    void convertToNumber() {
        String input = "1";

        int number = StringParser.parseToInteger(input);

        assertThat(number).isEqualTo(1);
    }
}