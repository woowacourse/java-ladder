package ladderGame.model.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Test
    void 중복된_이름이_있는_입력() {
        String input = "pobi, pobi, god";
        assertThrows(Exception.class, () -> {
            new PlayerNamesInput(input);
        });
    }

    @Test
    void 빈_이름이_존재하는_입력() {
        String input = "pobi, , god";
        assertThrows(Exception.class, () -> {
            new PlayerNamesInput(input);
        });
    }


}
