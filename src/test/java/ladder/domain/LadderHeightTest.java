package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderHeightTest {
    @Test
    void heightLowerThanOneTest() {
        assertThrows(RuntimeException.class, () -> new LadderHeight(0));
    }
}
