package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @DisplayName("구분자에 따라 공백을 포함하여 문자열을 나눈다.")
    @Test
    void splitByCommaIncludingBlank() {
        String input = " ,, as";
        Assertions.assertThat(StringParser.splitByComma(input, ",")).containsExactly(" ", "", " as");
    }
}
