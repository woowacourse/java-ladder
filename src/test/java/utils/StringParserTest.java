package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringParserTest {

    @Test
    @DisplayName("splitByDelimiter는 콤마를 기준으로 사람 이름을 분리할 수 있다.")
    void should_separateUserName_when_splitByDelimiter1() {
        String input = "pobi,honux,crong,jk";

        List<String> userNames = StringParser.splitByDelimiter(input);

        assertThat(userNames).containsExactly("pobi", "honux", "crong", "jk");
    }

    @Test
    @DisplayName("splitByDelimiter는 콤마를 기준으로 사람 이름을 분리할 수 있다.")
    void should_separateUserName_when_splitByDelimiter2() {
        String input = "pobi,,,";

        List<String> userNames = StringParser.splitByDelimiter(input);

        assertThat(userNames).containsExactly("pobi", "", "", "");
    }

    @Test
    @DisplayName("parseToInteger는 입력 값을 정수로 변환시킬 수 있다.")
    void should_convertStringToInteger_when_parseToInteger() {
        String input = "1";

        int number = StringParser.parseToInteger(input);

        assertThat(number).isEqualTo(1);
    }

    @DisplayName("parseToInteger는 입력 값이 정수가 아닐 경우 예외를 던진다.")
    @ParameterizedTest
    @CsvSource({"3.3", "asd", "''", "///.w.w"})
    void should_throwException_when_inputIsNotInteger(String input) {
        assertThatThrownBy(() -> StringParser.parseToInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "문자열에 공백을 삽입하여 5글자로 만든다.")
    @ValueSource(strings = {"a", "adf", "asdfg"})
    void should_makeStringLengthFive_when_insertBlank(String input) {
        String result = StringParser.insertBlank(input);

        assertThat(result.length()).isEqualTo(5);
    }
}
