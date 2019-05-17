package ladderGame.model.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerNamesInputTest {

    @Test
    void 다섯글자_초과_이름이_포함된_입력() {
        String input = "rockets, pobi";
        assertThrows(Exception.class, () -> {
            new PlayerNamesInput(input);
        });
    }

    @Test
    void 빈_입력_또는_null() {
        assertThrows(Exception.class, () -> {
            new PlayerNamesInput(null);
        });

        assertThrows(Exception.class, () -> {
            new PlayerNamesInput("");
        });
    }
}
