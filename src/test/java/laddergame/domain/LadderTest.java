package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    @Test
    void 사다리객체가_제대로_만들어지는지_테스트() {
        assertThat(new Ladder(4, "5")).isEqualTo(new Ladder(4, "5"));
    }

    @Test
    void 사다리의_높이_유효성_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(4, "0"));
    }
}
