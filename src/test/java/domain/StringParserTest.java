package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @DisplayName("구분자에 따라 문자열을 나눠주는 테스트 케이스")
    @Test
    void splitByCommaTest() {
        String input = " ,, as";
        Assertions.assertThat(StringParser.splitByComma(input, ",")).containsExactly(" ", "", " as");
    }
}
