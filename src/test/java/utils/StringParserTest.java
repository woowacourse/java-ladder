package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringParserTest {
    @Test
    @DisplayName("콤마를 기준으로 사람이름을 분리한다.")
    void splitByCommaTest() {
        String input = "pobi,honux,crong,jk";

        List<String> strings = StringParser.splitByDelimiter(input);

        assertThat(strings).containsExactly("pobi", "honux", "crong", "jk");
    }

    @Test
    @DisplayName("콤마를 기준으로 사람이름을 분리한다.")
    void splitByCommaEdgeCaseTest() {
        String input = "pobi,,,";

        List<String> strings = StringParser.splitByDelimiter(input);

        assertThat(strings).containsExactly("pobi", "", "", "");
    }

    @Test
    @DisplayName("문자열을 int로 변환한다.")
    void convertToNumberTest() {
        String input = "1";

        int number = StringParser.parseToInteger(input);

        assertThat(number).isEqualTo(1);
    }

    @Test
    @DisplayName("정수가 아닌 문자열이 들어오면 예외발생")
    void convertToNumberFailureTest() {
        String input = "adsf";

        assertThatThrownBy(() -> StringParser.parseToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수만 입력가능합니다.");
    }

    @ParameterizedTest(name = "문자열에 공백을 삽입하여 5글자로 만든다.")
    @ValueSource(strings = {"a","adf","asdfg"})
    void putBlankTest(String input) {
        String result = StringParser.insertBlank(input);

        assertThat(result.length()).isEqualTo(5);
    }
}