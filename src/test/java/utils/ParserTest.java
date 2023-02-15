package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @DisplayName("구분자에 따라 문자열을 나눠주는 테스트 케이스")
    @Test
    void parseTest() {
        String input = " ,, as";
        Assertions.assertThat(Parser.parse(input, ",")).containsExactly(" ", "", " as");
    }
}
