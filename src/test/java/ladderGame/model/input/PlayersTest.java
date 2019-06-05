package ladderGame.model.input;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {

    @Test
    void 다섯글자_초과_이름이_포함된_입력() {
        String input = "rockets, pobi";
        assertThrows(IllegalArgumentException.class, () -> {
            PlayersFactory.getPlayers(Arrays.asList(input.split(",")));
        });
    }

    @Test
    void 빈_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlayersFactory.getPlayers(Arrays.asList("".split(",")));
        });
    }

    @Test
    void null_입력() {
        String input = null;
        assertThrows(NullPointerException.class, () -> {
            PlayersFactory.getPlayers(Arrays.asList(input.split(",")));
        });
    }

    @Test
    void 중복된_이름이_있는_입력() {
        String input = "pobi,pobi,god";
        assertThrows(IllegalArgumentException.class, () -> {
            PlayersFactory.getPlayers(Arrays.asList(input.split(",")));
        });
    }

    @Test
    void 빈_이름이_존재하는_입력() {
        String input = StringUtils.deleteWhitespace("pobi, , ji");
        assertThrows(IllegalArgumentException.class, () -> {
            PlayersFactory.getPlayers(Arrays.asList(input.split(",")));
        });
    }

    @Test
    void 정상_입력() {
        String input = "pobi,ole,ko";
        assertDoesNotThrow(() -> {
            PlayersFactory.getPlayers(Arrays.asList(input.split(",")));
        });
    }


}
