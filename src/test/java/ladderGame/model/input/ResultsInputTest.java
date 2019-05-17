package ladderGame.model.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsInputTest {
    @Test
    void 글자수를_초과하는_입력() throws Exception {
        String input = "꽝, 고고씽씽씽싱, 고고싱";
        PlayerNamesInput playerNamesInput = new PlayerNamesInput("pobi,me,you");

        assertThrows(Exception.class, () -> {
            new ResultsInput(input, playerNamesInput);
        });
    }


    @Test
    void 이름들_입력보다_많은_결과들_입력() throws Exception {
        String input = "꽝, 고싱, 고고싱";
        PlayerNamesInput playerNamesInput = new PlayerNamesInput("pobi,me");
        assertThrows(Exception.class, () -> {
            new ResultsInput(input, playerNamesInput);
        });
    }

}
