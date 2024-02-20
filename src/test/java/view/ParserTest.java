package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
