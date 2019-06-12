package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    @Test
    void 길이_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkInput(Arrays.asList("abcdef"));
        });
    }

    @Test
    void 길이_비교() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkMemberCount(2, 3);
        });
    }
}
