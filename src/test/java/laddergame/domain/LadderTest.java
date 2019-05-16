package laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    Ladder ladder;

    @Test
    void 사다리객체가_제대로_만들어지는지_테스트() {
        assertThat(ladder).isEqualTo(new Ladder(4,5));
    }

    @Test
    void 사다리의_높이_유효성_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(4,0));
    }
}
