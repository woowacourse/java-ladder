package ladder.domain.gamecomponent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerNameTest {
    @Test
    void 이름의_길이가_5_이하인_경우() {
        assertDoesNotThrow(() -> new PlayerName("pobi"));
    }

    @Test
    void 이름의_길이가_5_초과인_경우() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName("pooobi"));
    }
}
