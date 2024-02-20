package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    @DisplayName("사람 이름은 쉼표(,)를 기준으로 구분한다.")
    void nameSplitByComma() {
        String input = "pobi,crong,honux";
        List<String> names = Parser.splitName(input);
        assertEquals(List.of("pobi", "crong", "honux"), names);
    }

    @Test
    @DisplayName("사다리 높이는 정수만 허용한다.")
    void isHeightInteger() {
        String input = "1개";
        assertThrows(NumberFormatException.class, () -> Parser.parseHeight(input));
    }
}
