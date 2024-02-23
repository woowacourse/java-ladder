package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesPrinterTest {
    @Test
    @DisplayName("이름 문자열 생성")
    void test() {
        Names names = new Names(List.of("a", "aa", "aaa", "aaaa", "aaaaa"));
        String actual = NamesPrinter.from(names);
        String expected = "   a    aa   aaa  aaaa  aaaaa";
        Assertions.assertThat(actual).isEqualTo(expected);
    }


}