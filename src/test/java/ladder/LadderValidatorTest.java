package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderValidatorTest {
    @Test
    void 높이가_0인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            LadderValidator.checkHeight(0);
        });
    }

    @Test
    void 높이가_음수인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            LadderValidator.checkHeight(-1);
        });
    }
}
