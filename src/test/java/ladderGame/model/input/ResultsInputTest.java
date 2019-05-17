package ladderGame.model.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsInputTest {
    @Test
    void 글자수를_초과하는_입력() throws Exception {
        String input = "꽝, 고고씽씽씽싱, 고고싱";
        PlayerNamesInput playerNamesInput = new PlayerNamesInput("pobi,me,you");

        assertThrows(Exception.class, () -> {
            new ResultsInput(input);
        });
    }

    @Test
    void 빈_입력_또는_null() {
        assertThrows(Exception.class, () -> {
            new ResultsInput(null);
        });

        assertThrows(Exception.class, () -> {
            new ResultsInput("");
        });
    }

}
