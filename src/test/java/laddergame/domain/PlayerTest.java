package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    void null_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(null);
        });
    }

    @Test
    void 공백_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
           new Player("");
        });
    }

    @Test
    void 다섯자_초과_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("abcdef");
        });
    }
}
