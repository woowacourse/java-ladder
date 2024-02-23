package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    void 사다리_높이가_1_미만이면_예외가_발생한다() {
        int invalidHeight = 0;
        int numberOfParticipants = 5;

        assertThatThrownBy(() -> new Ladder(invalidHeight, numberOfParticipants))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_높이가_1_이상이면_예외가_발생하지_않는다() {
        int validHeight = 1;
        int numberOfParticipants = 5;

        assertThatCode(() -> new Ladder(validHeight, numberOfParticipants)).doesNotThrowAnyException();
    }
}
