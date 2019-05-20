package ladder;

import ladder.model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @Test
    void 올바른_이름일_때_생성_검증() {
        assertDoesNotThrow(()-> new Player("bmo"));
    }

    @Test
    void _5글자를_초과하는_이름일_때_예외발생_검증() {
        assertThrows(IllegalArgumentException.class, () -> new Player("bmocon"));
    }

    @Test
    void 빈문자열_이름일_때_예외발생_검증() {
        assertThrows(IllegalArgumentException.class, () -> new Player(""));
    }

    @Test
    void null_이름일_때_예외발생_검증() {
        assertThrows(IllegalArgumentException.class, () -> new Player(null));
    }
}
