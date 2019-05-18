package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerNameTest {
    @Test
    void nameLengthOverTest() {
        assertThrows(RuntimeException.class, () -> new PlayerName("123456"));
    }

    @Test
    void nameLengthZeroTest() {
        assertThrows(RuntimeException.class, () -> new PlayerName(""));
    }

    @Test
    void nameNullTest() {
        assertThrows(RuntimeException.class, () -> new PlayerName(null));
    }
}
