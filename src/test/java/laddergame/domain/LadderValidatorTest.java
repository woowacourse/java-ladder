package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderValidatorTest {
    @Test
    void 사다리의_높이를_자연수만_받는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> LadderValidator.checkNumeric("-1"));
    }

    @Test
    void 사다리의_높이가_1보다_작을때_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> LadderValidator.checkLadderHeight("0"));
    }
}
