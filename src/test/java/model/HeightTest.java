package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.ladder.Height;
import org.junit.jupiter.api.Test;

public class HeightTest {
    @Test
    void 사다리_높이가_1_미만이면_예외가_발생한다() {
        int invalidHeightValue = 0;

        assertThatThrownBy(() -> new Height(invalidHeightValue)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_높이가_1_이상이면_예외가_발생하지_않는다() {
        int validHeightValue = 1;

        assertThatCode(() -> new Height(validHeightValue)).doesNotThrowAnyException();
    }
}
