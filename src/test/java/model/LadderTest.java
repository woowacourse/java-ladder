package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    void 사다리_높이는_1_미만이면_예외가_발생한다() {
        int height = 0;
        int numberOfParticipants = 5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ladder(height, numberOfParticipants));
    }
}
