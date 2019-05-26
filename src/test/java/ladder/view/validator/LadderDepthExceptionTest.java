package ladder.view.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderDepthExceptionTest {
    @Test
    void ladderMinDepth_0_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            LadderDepthValidate.ladderMinDepth(0);
        });
    }
}
