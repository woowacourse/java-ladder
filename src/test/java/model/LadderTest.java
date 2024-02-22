package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    void 사다리_높이는_1_미만이면_예외가_발생한다() {
        int invalidHeight = 0;
        int validHeight = 1;
        int numberOfParticipants = 5;
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Ladder(invalidHeight, numberOfParticipants)),
                () -> assertDoesNotThrow(() -> new Ladder(validHeight, numberOfParticipants))
        );
    }
}
