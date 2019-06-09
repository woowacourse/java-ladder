package ladderGame.model.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowNumberValidatorTest {
    @Test
    void 영() {
        assertThrows(IllegalStateException.class, () -> {
            RowNumberValidator.validates(0);
        });
    }

}
