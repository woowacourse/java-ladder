package view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersPrinterTest {
    @Test
    @DisplayName("이름 문자열 생성")
    void namesToString() {
        List<String> rawNames = List.of("a", "aa", "aaa", "aaaa", "aaaaa");
        String actual = PlayersPrinter.from(rawNames);
        String expected = "   a    aa   aaa  aaaa  aaaaa";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
