package ladderGame.model.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowNumberValidatorTest {
    @Test
    void 영_또는_음수() {

        assertThrows(Exception.class, () -> {
            RowNumberValidator.validates(0);
        });

        assertThrows(Exception.class, () -> {
            RowNumberValidator.validates(-1);
        });
    }

}
