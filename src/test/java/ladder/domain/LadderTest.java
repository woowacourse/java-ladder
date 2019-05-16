package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    Crossbars crossbars1;
    Crossbars crossbars2;

    @BeforeEach
    void setUp() {
        crossbars1 = new Crossbars(Arrays.asList(false, false));
        crossbars2 = new Crossbars(Arrays.asList(false, true, false));
    }

    @Test
    void Ladder가_제대로_생성되는지_테스트() {
        List<Boolean> userSetCroossbar = Arrays.asList(false, true, false);

        assertThat(new Ladder(3, new UserSetCrossbarGenerator(userSetCroossbar)))
                .isEqualTo(new Ladder(3, new UserSetCrossbarGenerator(userSetCroossbar)));
    }

    @Test
    void Ladder의_높이가_1보다_작을_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, new RandomCrossbarGenerator(4)));
    }
}
